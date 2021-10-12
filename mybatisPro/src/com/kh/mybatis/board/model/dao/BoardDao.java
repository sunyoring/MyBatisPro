package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.SearchCondition;

public class BoardDao {

	public int getListCount(SqlSession sqlSession) throws Exception {

		
		return sqlSession.selectOne("boardMapper.getListCount");
	}
	
	public int getListCountCon(SearchCondition sc, SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.getListCountCon",sc);
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) throws Exception  {
		// * offset : 몇개의 게시글을 건너 뛰고 조회할 지에 대해 계산
				// ex) boardLimit : 5
				// currentPage = 1		1~5		0개의 게시글 건너 뛰고 1부터 5개 조회
				// currentPage = 2		6~10	5개의 게시글 건너 뛰고 6부터 5개 조회
				// currentPage = 3		11~15	10개의 게시글 건너 뛰고 11부터 5개 조회
				// currentPage = 4		16~20	15개의 게시글 건너 뛰고 16부터 5개 조회

		
		int offset = (pi.getCurrentPage()-1)* pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		//RowBounds : 마이바티에스 페이징을 구현하기위한 기능으로 제공하고 있다.
		// 전체 내용을 먼저 뽑아온후 RowBounds를 이용해 건너뛰면서 조회하기 때문에 데이터가 매우 많을 경우에는 속도가 저하될 수 있다. 
		
		return 	(ArrayList)sqlSession.selectList("boardMapper.selectList", null , rowBounds); //두번째 인자는 파라미터 타입이므로 세번째 인자로 rowBounds를 넘김
	}

	public ArrayList<Board> selectListCon(SearchCondition sc, SqlSession sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage()-1)* pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());		
		
		return 	(ArrayList)sqlSession.selectList("boardMapper.selectListCon", sc , rowBounds); //두번째 인자는 파라미터 타입이므로 세번째 인자로 rowBounds를 넘김
	}

	public int countUp(SqlSession sqlSession, int bno) {
		
		return sqlSession.update("boardMapper.countUp",bno);
	}

	public Board selectBoard(SqlSession sqlSession, int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.selectBoard",bno);
	}



}
