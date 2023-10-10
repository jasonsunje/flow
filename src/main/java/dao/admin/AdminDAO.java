package dao.admin;

import org.apache.ibatis.session.SqlSession;

import vo.admin.AdminVO;

public class AdminDAO {

	private SqlSession sqlSession;

	public AdminDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 로그인
	public int checkLogin(AdminVO vo) {

		int no = 0;

		try {
			no = sqlSession.selectOne("admin.checkLogin", vo);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return no;
	}

	// 회원가입
	public int insert(AdminVO vo) {
		return sqlSession.insert("admin.insert", vo);
	}

	public AdminVO selectOne(int adminId) {
		return sqlSession.selectOne("admin.selectOne", adminId);
	}

	// 관리자 재설정
	public int update(AdminVO vo) {
		return sqlSession.update("admin.update", vo);
	}

	// 관리자 탈퇴
	public int delete(int adminId) {
		return sqlSession.delete("admin.delete", adminId);
	}

	// 이름 중복검사
	public String checkId(String name) {
		return sqlSession.selectOne("admin.checkId", name);
	}

}
