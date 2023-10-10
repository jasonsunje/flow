package service.admin.member;

import dao.admin.AdminDAO;
import vo.admin.AdminVO;

public class AdminMemberService {

	private AdminDAO adminDao;

	public AdminMemberService(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	public int insert(AdminVO vo) {
		return adminDao.insert(vo);
	}

	public AdminVO selectOne(int adminId) {
		return adminDao.selectOne(adminId);
	}

	public int update(AdminVO vo) {
		return adminDao.update(vo);
	}

	public int delete(int adminId) {
		return adminDao.delete(adminId);
	}

	public boolean checkId(String name) {
		return adminDao.checkId(name) != null;
	}

}
