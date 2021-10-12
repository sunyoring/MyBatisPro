package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.SearchCondition;

public interface BoardService {

	int getListCount() throws Exception;

	ArrayList<Board> selectList(PageInfo pi) throws Exception;

	ArrayList<Board> selectListCon(SearchCondition sc, PageInfo pi) throws Exception;

	int getListCountCon(SearchCondition sc);

	int countUp(int bno);

	Board selectBoard(int bno);

}
