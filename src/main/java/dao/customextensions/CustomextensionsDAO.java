package dao.customextensions;

import org.apache.ibatis.session.SqlSession;

import vo.customextensions.CustomextensionsVO;

public class CustomextensionsDAO {
	
	private SqlSession sqlSession;
	
	public CustomextensionsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public CustomextensionsVO selectOne (int customextensionsid) {
		return sqlSession.selectOne("select.cus", customextensionsid);
	}

	public int insert(CustomextensionsVO vo) {
		return sqlSession.insert("insert.cus", vo);
	}
}
