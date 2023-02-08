package Day06.Ex6_비회원게시판_배열버전;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판_배열버전 { // class s
	
	public static void main(String[] args) throws Exception { // main s // 4. 예외처리
		
		// step1 : 필요한 데이터를 입력받아 저장
		// step2 : 쓰기 페이지 실행되는 조건 
		// step3 : 입력된 데이터를 파일처리 [ 영구저장 ] 
		// step4 : 파일에 있는 문자열 가지고 오기
		
		// * 입력객체
		Scanner scanner = new Scanner( System.in );
		
		while( true ) {	// 2. 무한루프 [ 종료조건 : -2 입력시 ]
		

			// 현재 파일에 존재하는 모든 문자열 호출
			// 1. 파일 입력
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			// 읽어온 바이트를 저장하기 위해 바이트배열 1000 바이트 미리 생성
			byte[] inbytes = new byte[ 1000 ]; // 영문 1바이트 , 한글 3바이트
			
			// .read() 메소드를 이용한 파일 읽기 [ * 읽은 바이트를 바이트배열 저장 ]
				// inbytes : 읽어온 바이트를 배열에 저장
				// bytecount : 읽어온 바이트의 개수 변수에 저장
			int bytecount = fin.read( inbytes );	// 읽어온 바이트를 바이트배열 저장
			// 4. 바이트배열 ---> 문자열
				// new String("유재석")
				// new String( 바이트배열 ); new String( 바이트배열, 시작인덱스, 마지막인덱스 );
			String fStr = new String( inbytes , 0 , bytecount ); // 바이트배열 --> 문자열
			
			
			 // fStr = "안녕하세요,자바글쓰기,유재석,1234\n호호호호호,자바글쓰기,강호동,4567\n
			 
			
			
			// * 행 기준 자르기
			String[] boards = fStr.split("\n"); // 행 기준으로 분리 [ // * 바이트 수만큼 가져오지 않으면 게시물 2개일때는 3조각인데 마지막인덱스 사용안함 ]
			
			// boards = { "안녕하세요,자바글쓰기, 유재석, 1234" , "호호호호호, 자바글쓰기, 강호동, 4567" }
			
			// * [행마다] 열 기준 다르기 [ 길이-1 : 마지막인덱스 제외 ]
			System.out.println("------------ 게시판 -------------");
			System.out.printf("%2s\t %-10s\t %-5s\t \n" , "번호", "제목", "작성자");
			System.out.println("-------------------------------");
			for( int i=0; i<boards.length; i++ ) {
			
				// * 게시물 마다 열 자르기 
				String[] cols = boards[i].split(",");
				String title = cols[0];  String content = cols[1];
				String writer = cols[2]; String password = cols[3];
				System.out.printf("%2d\t %-10s\t %-5s\t \n" , i, title, writer);
				
			}
			System.out.println("-------------------------------");
			
			/*
			 	 // boards = { "안녕하세요,자바글쓰기, 유재석, 1234" , "호호호호호, 자바글쓰기, 강호동, 4567" }
				for i = 0 일때
					 	boards[0] = "안녕하세요,자바글쓰기,유재석,1234"
						cols = { "인녕하세요", "자바글쓰기", "유재석", "1234" }
					for i = 1 일때
						boards[1] = "안녕하세요,자바글쓰기,유재석,1234"
						cols = { "호호호호호", "자바글쓰기", "강호동", "4567" }
			 */
			
					
			
			System.out.print("메뉴 >>>  쓰기[-1]  나가기[-2]  :  ");
			int ch = scanner.nextInt();
			if( ch == -1 ) {
				// 1. 입력객체로 입력받기
				System.out.print("제목 : ");	 	String title = scanner.next();
				System.out.print("내용 : "); 		String content = scanner.next();
				System.out.print("작성자 : "); 	String writer = scanner.next();
				System.out.print("비밀번호 : "); 	String password = scanner.next();
				
				// , : 열 구분선 		\n : 행 구분선 [ 게시물구분 ] 
				String outStr = title + "," + content + "," + writer + "," + password + "\n";
				
				// 3. 파일처리 [ 클래스 ] ( "파일경로", true ); 
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt" , true );
				fout.write( outStr.getBytes() );
				
			}
			if( ch == -2 ) { break; }
			
			
		}
		
		
		
		
	} // main e
	
} // class e
