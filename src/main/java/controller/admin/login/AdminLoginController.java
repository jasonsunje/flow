package controller.admin.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.admin.login.AdminLoginService;
import vo.admin.AdminVO;

@Controller
@RequestMapping("/admin/login/*")
public class AdminLoginController {

	private AdminLoginService adminLoginService;

	public AdminLoginController(AdminLoginService adminLoginService) {
		super();
		this.adminLoginService = adminLoginService;
	}

	@RequestMapping("loginForm")
	public String loginForm(HttpServletRequest request, String adminId) {

		boolean check = false;

		if (adminId == null) {
			Cookie[] cks = request.getCookies();

			if (cks != null) {
				for (Cookie ck : cks) {
					if (ck.getName().equals("ckid")) {
						adminId = ck.getValue();
						check = true;
						break;
					}
				}
			}
		}

		request.setAttribute("adminId", adminId);
		request.setAttribute("check", check);

		return ViewPath.ADMINLOGIN + "login.jsp";
	}

	@RequestMapping("checkLogin")
	public String checkLogin(HttpServletRequest request, HttpServletResponse response, AdminVO vo) {

		int no = adminLoginService.checkLogin(vo);

		String msg = null;
		boolean check = false;

		if (no != 0) {
			msg = vo.getAdminId() + "으로 로그인 하셨습니다.";
			check = true;

			request.getSession().setAttribute("login", no);

			String ckid = request.getParameter("ckid");

			Cookie ck = null;

			Cookie[] cks = request.getCookies();

			if (cks != null) {
				for (Cookie c : cks) {
					if (c.getName().equals("ckid")) {
						ck = c;
						break;
					}
				}
			}

			if (ckid != null) {
				if (ck == null) {
					ck = new Cookie("ckid", vo.getName());

					ck.setPath("/");

					ck.setMaxAge(60 * 60 * 24);

					response.addCookie(ck);
				} else {
					if (!ck.getValue().equals(vo.getAdminId())) {
						ck.setValue(vo.getName());
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			} else {
				if (ck != null) {
					if (ck.getValue().equals(vo.getAdminId())) {
						ck.setPath("/");
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}

		} else {
			msg = "아이디 혹은 비밀번호가 잘못되었습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("check", check);

		return ViewPath.ADMINLOGIN + "result.jsp";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return ViewPath.ADMINLOGIN + "logout.jsp";
	}

}