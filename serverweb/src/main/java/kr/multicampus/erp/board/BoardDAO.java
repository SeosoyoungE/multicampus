package kr.multicampus.erp.board;

import java.util.ArrayList;

import kr.multicampus.erp.user.EmpDTO;


public interface BoardDAO {
	//1. 게시글 등록
	public int insert(BoardDTO emp);
	
	//2. 게시글 전체조회
	public ArrayList<BoardDTO> select();
	
	//3. 게시글 상세보기
	public BoardDTO read(int boardNo);
}

