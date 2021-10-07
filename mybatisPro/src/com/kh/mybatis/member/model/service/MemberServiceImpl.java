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

}
