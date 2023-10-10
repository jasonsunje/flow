package dao.users;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.users.UsersVO;

public class UsersDAO {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlsession) {
		this.sqlSession = sqlsession;
	}

	// 로그인
	public int checkLogin(UsersVO vo) {

		int no = 0;

		try {
			no = sqlSession.selectOne("users.checkLogin", vo);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return no;
	}

	// 회원상태 가져오기
	public int checkStatus(UsersVO vo) {
		return sqlSession.selectOne("users.checkStatus", vo);
	}

	// 아이디 찾기
	public String findId(UsersVO vo) {
		return sqlSession.selectOne("users.findId", vo);
	}

	// 비밀번호 찾기
	public String findPw(UsersVO vo) {
		return sqlSession.selectOne("users.findPw", vo);
	}

	// 비밀번호 재설정
	public int updatePw(UsersVO vo) {
		return sqlSession.selectOne("users.updatePw", vo);
	}

	// 회원가입
	public int insert(UsersVO vo) {
		return sqlSession.selectOne("users.insert", vo);
	}

	// 아이디 중복검사
	public String checkId(String userid) {
		return sqlSession.selectOne("users.checkId", userid);
	}

	// 회원 정보 수정
	public int update(UsersVO vo) {
		return sqlSession.update("users.update", vo);
	}

	// 회원탈퇴
	public int withdrawal(int userid) {
		return sqlSession.update("users.withdrawal", userid);
	}

	// salt
	public String getSaltById(String userid) {
		return sqlSession.selectOne("users.salt", userid);
	}

	// salt no로 가져오기
	public String getSaltByNo(int no) {
		return sqlSession.selectOne("users.saltNo", no);
	}

	public UsersVO findNo(UsersVO vo) {
		return sqlSession.selectOne("users.findNo", vo);
	}

}
