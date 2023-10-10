package service.login;

import dao.users.UsersDAO;
import vo.users.UsersVO;

public class LoginService {

	private UsersDAO usersDao;

	public void setUserDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}

	// 로그인
	public int checkLogin(UsersVO vo) {
		return usersDao.checkLogin(vo);
	}

	// 회원 상태
	public int checkStatus(UsersVO vo) {
		return usersDao.checkStatus(vo);
	}

	// 아이디 찾기
	public String findId(UsersVO vo) {
		return usersDao.findId(vo);
	}

	// 비밀번호 찾기
	public String findPw(UsersVO vo) {
		return usersDao.findPw(vo);
	}

	// 비밀번호 재설정
	public int updatePw(UsersVO vo) {

		return usersDao.updatePw(vo);
	}

	public String getSaltById(String uuserId) {
		return usersDao.getSaltById(uuserId);
	}

	// 유저 번호 찾기
	public UsersVO findNo(UsersVO vo) {
		return usersDao.findNo(vo);
	}

}
