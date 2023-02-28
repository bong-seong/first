package Day20.gallery.controller;

import java.util.ArrayList;

import Day20.gallery.model.dao.BoardDAO;
import Day20.gallery.model.dto.BoardDTO;
import Day20.gallery.model.dto.CategoryDTO;

public class Bcontroller {
	
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() {
		return bc;
	}
	
	
	// 1. 카테고리 추가 처리
	public boolean categoryAdd( String cname ) {
		return BoardDAO.getInstance().categoryAdd(cname);
	}
	
	
	// 2. 모든 카테고리 호출 처리
	public ArrayList<CategoryDTO> categoryPrint(){
		return BoardDAO.getInstance().categoryPrint();
	}
	
	
	// 3. 게시물 등록
	public boolean boardAdd( String btitle, String bcontent , int cno) {
		
		return BoardDAO.getInstance().boardAdd(btitle, bcontent, Mcontroller.getInstance().getLoginSession(), cno);
	}
	
	
	// 4.
	public ArrayList<BoardDTO> boardPrintRecent(){
		return BoardDAO.getInstance().boardPrintRecent();
	}
	
	// 5. 
	public ArrayList<BoardDTO> boardPrint( int cno ){
		return BoardDAO.getInstance().boardPrint(cno);
	}
}
