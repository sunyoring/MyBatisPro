package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.kh.mybatis.common.Template.*;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.model.dao.MemberDao;
public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = getSqlSession();

		Member loginUser = memberDao.loginMember(sqlSession, m);
		
		sqlSession.close();
		return loginUser;
	}

	@Override
	public void insertMember(Member m) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = memberDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		
		sqlSession.close();
		
	}

	@Override
	public void updateMember(Member m) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = memberDao.updateMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		
		sqlSession.close();
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = memberDao.deleteMember(sqlSession, userId);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
			throw new Exception();
		}
		
		sqlSession.close();		
	}

}
