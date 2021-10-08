package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int getListCount() throws Exception {
		SqlSession sqlSession = getSqlSession();
		

		int listCont = boardDao.getListCount(sqlSession);
		sqlSession.close();

		return listCont;

		
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) throws Exception {
		SqlSession sqlSession = getSqlSession();

		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		sqlSession.close();

		return list;
	}

}
