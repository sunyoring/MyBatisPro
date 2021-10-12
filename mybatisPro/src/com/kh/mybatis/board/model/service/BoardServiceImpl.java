package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.SearchCondition;

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

	@Override
	public ArrayList<Board> selectListCon(SearchCondition sc, PageInfo pi) throws Exception {
		SqlSession sqlSession = getSqlSession();

		ArrayList<Board> list = boardDao.selectListCon(sc, sqlSession, pi);
		sqlSession.close();

		return list;
	}

	@Override
	public int getListCountCon(SearchCondition sc) {
		SqlSession sqlSession = getSqlSession();

		int listCont = boardDao.getListCountCon(sc, sqlSession);
		sqlSession.close();

		return listCont;
	}

	@Override
	public int countUp(int bno) {
		SqlSession sqlSession = getSqlSession();

		return boardDao.countUp(sqlSession, bno);
	}

	@Override
	public Board selectBoard(int bno) {
		SqlSession sqlSession = getSqlSession();

		int result = boardDao.countUp(sqlSession, bno);
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return boardDao.selectBoard(sqlSession, bno);
	}

}
