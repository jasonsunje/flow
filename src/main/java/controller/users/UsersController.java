package controller.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.users.UsersService;
import vo.users.UsersVO;

@Controller
public class UsersController {
	
	private UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	// 회원가입
	@RequestMapping("/uuser/joincheck")
	public String joinCheck() {
		return ViewPath.UUSER + "joinCheck.jsp";
	}

	@RequestMapping("/uuser/joinform")
	public String joinForm() {
		return ViewPath.UUSER + "joinForm.jsp";
	}

	//회원가입
	@RequestMapping(value = "/uuser/join")
	public String join(Model model, UsersVO vo) {
		vo.setUsername(null);
		vo.setPassword(null);
		int su = usersService.insert(vo);

		String url = null;
		String msg = null;

		if (su != 0) { // 성공 => 알림창 출력 => 메인페이지
			msg = "회원 가입 성공!";
			url = "/sool/login/loginform?id=" + vo.getUsername();
		} else { // 실패 => 에러문구 출력 => 백
			msg = "회원 가입 실패!";
			url = "history.back()";
		}

		model.addAttribute("url", url);
		model.addAttribute("msg", msg);

		return ViewPath.UUSER + "result.jsp";
	}

}
