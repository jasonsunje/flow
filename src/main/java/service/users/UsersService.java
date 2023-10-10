package service.users;

import common.Encry;
import dao.users.UsersDAO;
import vo.users.UsersVO;

public class UsersService {

	private UsersDAO usersDao;

	public UsersService(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}

	public int insert(UsersVO vo) {
		String salt = Encry.getSalt();
		vo.setSalt(salt);

		String password = vo.getPassword();
		password = Encry.encry(password, salt);

		vo.setPassword(password);

		return usersDao.insert(vo);
	}

	public int update(UsersVO vo) {
		String salt = usersDao.getSaltByNo(vo.getUserid());
		String password = vo.getPassword();
		password = Encry.encry(password, salt);
		vo.setPassword(password);
		return usersDao.update(vo);
	}

	public boolean checkId(String id) {
		return usersDao.checkId(id) != null;
	}

	public int withdrawal(int uuserNo) {
		return usersDao.withdrawal(uuserNo);
	}

}
