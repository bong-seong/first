package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {

	ArrayList<Board> boardDb = new ArrayList<>();
		
	// 게시물 저장
	public String savePost( String title , String content , String writer ) {
		
		Board board = new Board(writer, title, content, 0);
		
		boardDb.add( board );
		
		return null;
	}
	
}
