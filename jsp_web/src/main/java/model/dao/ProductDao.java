package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.dto.ChatDto;
import model.dto.ProductDto;

public class ProductDao extends Dao {

	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao ; }
	
	// 1. 제품 등록 [ synchronized : 멀티스레드 사용시 ( 서블릿 ) 해당 메소드 동시사용불가 = await 
	public synchronized boolean write( ProductDto dto ) {
		
		// 1. 제품 우선 등록
		String sql = "insert into product( pname , pcomment , pprice , plat , plng , mno ) "
				+ " value ( ? , ? , ? , ? , ? , ? )";
		
		try {
			// insert 후 생성된 제품 pk 번호 호출
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
			
			ps.setString(1, dto.getPname() );
			ps.setString(2, dto.getPcomment() );
			ps.setLong(3, dto.getPprice() );
			ps.setString(4, dto.getPlat() );
			ps.setString(5, dto.getPlng() );
			ps.setInt(6, dto.getMno() );
			
			ps.executeUpdate();
			
			// insert 후 생성된 제품 pk 번호 호출
			rs = ps.getGeneratedKeys();
			if( rs.next() ) { // 만약에 생성된 제품 pk번호가 존재하면
				for( String pimgname : dto.getPimglist() ) {
					// dto 내 첨부파일명 리스트에 하나씩 첨부파일명을 insert 하기
					sql = "insert into pimg( pimgname , pno ) values ( ? , ? )";
					
					ps = con.prepareStatement(sql);
					
					ps.setString(1, pimgname); 
					ps.setInt(2, rs.getInt(1) );
					
					ps.executeUpdate();
					
				}
			}
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 2. 제품 호출
	public synchronized ArrayList<ProductDto> getProduct( String dong , String seo , String nam ,String book ){
		
		ArrayList<ProductDto> list = new ArrayList<>();
		
		String sql = "select p.* , m.mid , m.mimg from product p natural join member m "
				+ " where p.plng <= ? and p.plng >= ? and p.plat >= ? and p.plat <= ? ";
		
		try{
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dong);
			ps.setString(2, seo);
			ps.setString(3, nam);
			ps.setString(4, book);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				ArrayList<String> pimglist = new ArrayList<>();
				sql = "select * from pimg where pno = " + rs.getInt(1); // 동일한 제품번호의 이미지들을 호출
				
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
						
				
				while( rs2.next() ) {
					pimglist.add( rs2.getString(2) ); // 검색된 이미지이름을 리스트에 저장
				}
				
				ProductDto dto = new ProductDto( 
						rs.getInt(1) , rs.getString(2) , rs.getString(3), 
						rs.getInt(4) , rs.getInt(5) , rs.getString(6) , 
						rs.getString(7) , rs.getInt(8) , rs.getString(9) , 
						rs.getInt(10) , rs.getString(11) , rs.getString(12) , pimglist );
				
				list.add( dto );
						
			}
		
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return list ;
	}
	
	
	// 3. 찜하기
	public synchronized boolean setplike( int pno , int mno ) {
		
		// 1. 등록할지 취소할지 검색 먼저하기
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) { // 이미 찜하기를 한 제품
				
				sql = "delete from plike where pno = "+pno+" and mno = "+mno ;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return false;
				
			}else {
				
				sql = "insert into plike ( pno , mno ) values ( "+pno+" , "+mno+" )";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 4. 현재 회원이 해당 제품의 찜하기 상태 확인
	public synchronized boolean getplike( int pno , int mno ) {
		
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;
		
			try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) { return true ; }
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	// 5. 제품에 채팅 저장하기 
	public synchronized boolean setChat( ChatDto dto ) {
		
		String sql = "insert into note ( ncontent , pno , from_mno , to_mno ) values ( ? , ? , ? , ?)";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getNcontent() );
			ps.setInt(2, dto.getPno());
			ps.setInt(3, dto.getFrom_mno() );
			ps.setInt(4, dto.getTo_mno() );
			
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}

	
	// 6. 제품에 등록된 채팅 [ 제품번호 일치 , 현재 보고있는 회원 [ 로그인된 회원 ] 받거나 보낸 내용들 ]
		// 1. 채팅목록출력 [ js.9함수 ] / 2. 채팅방내 메시지목록 출력 [ js.10함수 ]
	public synchronized ArrayList<ChatDto> getChatList( int pno , int mno , int chatmno ){
		
		ArrayList<ChatDto> list = new ArrayList<>();
		
		String sql = "";
		
		if( chatmno != 0 ) {
			sql = "select * from note "
					+ " where pno = ? and "
					+ " ( (from_mno = ? and to_mno = ?) or (from_mno = ? and to_mno = ?) )";
		}else {
			sql = "select * from note where pno = ? and ( from_mno = ? or to_mno = ? )";
		}
		
		// 
		
		
		// 현재 같이 채팅 하고 있는 대상자들의 내용물만 출력
		
		
		/*
		 	- 1. 로그인된 회원 기준으로 보내거나 받은 메시지를 모두 출력
		 		select * from note where pno = ? and ( from_mno = ? or to_mno = ? )
		 		1. 구매자 문제없음 / 2. 판매자는 채팅 대상만의 메시지만 출력
		 		
		 	- 2. 
		 		만약에 채팅방에 4번회원과 5번회원 존재
		 		frommno = 4 이면서 tomno = 5 이거나 frommno = 5 이면서 tomno = 4 
		 		- 4번회원이 보냈거나 받았으면 5번회원이 받았거나 보냈으면
		 */
		
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, pno);
			if( chatmno != 0) {
				ps.setInt(2, mno);
				ps.setInt(3, chatmno);
				ps.setInt(4, chatmno);
				ps.setInt(5, mno);
			}else {
				ps.setInt(2, mno);
				ps.setInt(3, mno);
			}
			
			
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				ChatDto dto = new ChatDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5) , rs.getInt(6) );
				
				// 보낸회원의 정보 호출
				sql = "select mid , mimg from member where mno = " + rs.getInt(5); // from_mno
				
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				
				if( rs2.next() ) {
					dto.setFrommid( rs2.getString(1) );
					dto.setFrommimg( rs2.getString(2) );
				}
				
				list.add( dto );
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	
	// 7. 날짜별 포인트 충전 내역
	public HashMap< String , Integer > getSum() {
		
		HashMap< String , Integer > map = new HashMap<>(); // String 타입의 키와 Integer 타입의 데이터 저장
		
		String sql = "select "
				+ "	date_format( mdate , '%Y-%m-%d' ) as mdate ,"
				+ "    sum( if( mpcomment = '포인트 충전' , mpamount , 0 ) ) as point "
				+ " from mpoint group by date_format( mdate , '%Y-%m-%d' ) "
				+ " order by  mdate desc limit 5;";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				map.put( rs.getString(1) , rs.getInt(2) );
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return map;
	}

}

/*
	
	// 1. 해당 타입의 객체를 여러개 저장할 수 있는 리스트 객체 선언
 	ArrayList< 타입 > list = new ArrayList<>();
 		데이터 : '유재석' , '강호동' , '신동엽' -> 타입 1개
 		[ '유재석' , '강호동' , '신동엽' ]
 		
 		.add( 데이터 )
 	
 	// 2. 해당 키타입과 데이터타입에 해당하는 키와데이터를 여러개 저장 할 수 있는 맵 객체 선언 
 	HashMap< 키타입 , 데이터타입 > map = new HashMap<>();
 		데이터 : '유재석=30' , '강호동=10' , '신동엽=20'
 		
 	
 
 */









