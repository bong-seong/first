package 과제.과제9.클래스.예제3_펜;

import java.util.Scanner;

public class Front {
	
	
	Scanner scanner = new Scanner(System.in);
	펜 펜;
	
	public void index() {
		while(true) {
			
			System.out.println("펜을 선택하세요 1. 샤프 / 2. 볼펜 / 3. 만년필");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) {
				펜 = new 샤프();
				use_sharp();
			}
			else if( ch == 2 ) {
				System.out.println("볼펜을 선택하셨습니다.");
				
				볼펜 볼펜 = new 볼펜();
				ballpen : while( true ) {
					System.out.println("어떤 색상을 사용하시겠습니까 ? ( 검정, 빨강, 파랑 ) ( 다른펜쓰러가기 : \"종료\" ) ");
					String selectColor = scanner.next();
					if( selectColor.equals("검정") || selectColor.equals("빨강") || selectColor.equals("파랑") ) {
					
						while( true ) {
							볼펜.color = selectColor;
							볼펜.컬러(selectColor);
							System.out.println("1. 쓰기 / 2. 색상 다시선택하기 / 3. 다른펜쓰러가기");
							int select = scanner.nextInt();
							if( select == 1 ) { 볼펜.사용(); }
							else if( select == 2 ) { break; } 
							else if( select == 3 ) { break ballpen; }
						}
							
					}else if( selectColor.equals("종료") ){
						break;
					}else {
						System.err.println("지원하지 않는 색상입니다.");
						System.out.println("종료를 희망하시면 \"종료\"를 입력해주세요.");
					}
				} 
			} else if( ch == 3 ) {
				펜 = new 만년필();
				use_FountainPen();
			}
			
		}
	}
	
	public void use_sharp() {
		while(true) {
			System.out.println("샤프를 선택하셨습니다.");
			샤프 샤프 = (샤프)펜;
			
			System.out.println("남은 사용횟수 : " + 샤프.use_sharp );
			System.out.println("1. 쓰기 / 2. 샤프심 넣기 / 3.다른펜 쓰러가기");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				if( !샤프.installation ) {
					System.err.println("샤프심을 장착해주세요!!");
				}else {
					샤프.사용();
				}
			}else if( ch == 2 ) {
				샤프.샤프심();
			}else if( ch == 3 ) { break; } 
		}
	}
	
	
	public void use_FountainPen() {
		while(true) {
			System.out.println("만년필을 선택하셨습니다.");
			만년필 만년필 = (만년필)펜;
			
			System.out.println("1. 쓰기 / 2. 잉크묻히기 / 3.다른펜 쓰러가기");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				if( !만년필.installation ) {
					System.err.println("잉크를 묻혀주세요!!");
				}else {
					만년필.사용();
				}
			}else if( ch == 2 ) {
				만년필.잉크();
			}else if( ch == 3 ) { break; }
		}
	}	
		
		
}
