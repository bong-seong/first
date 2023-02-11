package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {

	public ArrayList<Board> boardDb = new ArrayList<>();
		
	// 게시물 저장
	public String savePost( String title , String content , String id ) {
		
		Board board = new Board(id, title, content);
		
		boardDb.add( board );
		
		return null;
	}
	
	
	// 게시물 보기
	public Board viewPost( int ch , String id ){
		boardDb.get(ch).count++; // 해당 함수 (글보기) 실행시 조회수( count ) 1 증가
		return boardDb.get(ch); // 전달받은 ch 번째의 인덱스 객체 반환
	}
	
	// 게시물 삭제하기
	public String delPost( int ch , String id ) { // boardDb 의 ch(인덱스) 번째
			if( boardDb.get(ch).id.equals( id ) ) { // ch번째 값의 id가 일치할경우
				boardDb.remove(ch); // 해당 ch번째 값 삭제
				return "del" ; // "del" 리턴
			}
		return "pass"; // 아닐경우 "pass" 리턴 ** null 로 리턴할경우 에러가남...
	}
	
	
	// 게시물 수정하기
	// 삭제와 거의 유사한 방식으로, 프론트에서 입력받은 새로운 content 값을 ch번째의 content에 대입 
	public String editPost( int ch , String id , String editContent ) {
		if( boardDb.get(ch).id.equals( id ) ) {
			boardDb.get(ch).content = editContent ;
			return "edit" ;
		}
	return "pass";
}
	
	
}
