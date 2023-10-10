package controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.Encry;
import common.ViewPath;
import service.login.LoginService;
import vo.users.UsersVO;

@Controller
public class LoginController {

	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/login/loginform")
	public String LoginForm(HttpServletRequest request, String id) {
		boolean check = false;
		if (id == null) {
			Cookie[] cks = request.getCookies();

			if (cks != null) {
				for (Cookie ck : cks) {
					if (ck.getName().equals("ckid")) {
						id = ck.getValue();
						check = true;
						break;
					}
				}
			}
		}

		request.setAttribute("id", id);
		request.setAttribute("check", check);

		return ViewPath.LOGIN + "login.jsp";

	}

	@RequestMapping("/login/findform")
	public String findForm() {
		return ViewPath.LOGIN + "findform.jsp";
	}

	@RequestMapping("/login/find")
	public String find(Model model, UsersVO vo, String mode) {

		String find = null;

		if (vo.getUsername() == null) {
			find = loginService.findId(vo);
		}

		boolean check = false;
		if (find != null) {
			check = true;
			String re = "";
			for (int i = 0; i < find.length(); i++) {
				if (i % 2 == 0) {
					re += find.charAt(i);
				} else {
					re += "*";
				}
			}

			if (mode.equals("id")) {
				model.addAttribute("id", re);
			}
		}

		model.addAttribute("check", check);

		if (mode.equals("id")) {
			return ViewPath.LOGIN + "findresult.jsp";
		} else {
			return "redirect:/login/updatePw";
		}

	}
//
//	@RequestMapping("/login/updatePw")
//	public String updatePw(Model model, UsersVO vo) {
//
//		UsersVO uVo = loginService.findNo(vo);
//		if (uVo != null) {
//			model.addAttribute("UuserId", vo.getUsername());
//		} else {
//			return "redirect:/login/findform?mode=id";
//		}
//
//		return ViewPath.LOGIN + "updatePw.jsp";
//	}
//
//	// 비밀번호 재설정
//	@RequestMapping("/login/newPw")
//	public String newPw(Model model, UsersVO vo, HttpSession session) {
//
//		String salt = loginService.getSaltById(vo.getUsername());
//		System.out.println(salt);
//		String password = vo.getPassword();
//		password = Encry.encry(password, salt);
//		System.out.println(password);
//		vo.setPassword(password);
//		int su = loginService.updatePw(vo);
//		UsersVO newVo = new UsersVO();
//		newVo.setPassword(vo.getPassword());
//		if (su != 0) {
//			return "redirect:/login/loginform";
//		}
//		return ViewPath.LOGIN + "updatePw.jsp";
//	}
//
//	@RequestMapping("/login/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//
//		return ViewPath.LOGIN + "logout.jsp";
//	}
}
