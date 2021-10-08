package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
		
		Member loginUser = null;
		
//		 m 객체를 memberMapper 매퍼에 loginMember 가 id인 것을 찾아가서 넘겨주고 sql을 실행시켜 Member객체를 받아온다.
		loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		return loginUser;
	}

	public int insertMember(SqlSession sqlSession, Member m) {

		return sqlSession.insert("memberMapper.insertMember" , m);
	}

	public int updateMember(SqlSession sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember" , m);
	}

	public int deleteMember(SqlSession sqlSession, String userIed) {

		return sqlSession.delete("memberMapper.deleteMember" , userIed);
	}


}
