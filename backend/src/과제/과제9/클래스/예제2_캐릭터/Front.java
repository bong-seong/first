package 과제.과제9.클래스.예제2_캐릭터;

import java.util.Scanner;

public class Front {

	
	Scanner scanner = new Scanner(System.in);
	
	캐릭터 전직 = new 캐릭터("초보자" , 100 , 100 , 100);
	
	// 메인화면
	public void index() {
		while( true ) {
						
			System.out.println("---------- 무슨무슨게임 ----------");
			System.out.println("안녕하세요, 즐거운 게임되세요");
			System.out.println("전직은 자유자재로 변경 가능합니다!!");
			System.out.println();
			stat_info();
			System.out.println();
			System.out.println("전직 [ 선택 / 변경 ]");
			System.out.println("1. 전사 / 2. 마법사 / 3.도적 ");
			int ch = scanner.nextInt();
			select_class( ch );

		}
	}
	
	// 캐릭터 스텟 출력 함수
	public void stat_info() {
		System.out.println("[스테이터스]");
		System.out.println("전직 : " + 전직.현재전직 );
		System.out.println("체력 : " + 전직.체력 );
		System.out.println("마력 : " + 전직.마력 );
		System.out.println("스테미너 : " + 전직.스테미너 );
		System.out.print("공격방식 : "); 전직.공격();
	}
	
	
	// 전직 함수
	public void select_class( int ch) {
		if( ch == 1 ) {
			if( !(전직 instanceof 전사 ) && !(전직 instanceof 마법사) && !(전직 instanceof 도적) ) {
				전직 = new 전사( "전사", 500, 100, 200 );
			}else if( 전직 instanceof 전사 ) {
				System.err.println("이미 선택하신 직업입니다");
				return;
			}else if( 전직 instanceof 마법사 || 전직 instanceof 도적 ) {
				System.out.println("직업을 변경하시겠습니까 ? ");
				System.out.println("현재직업 : " + 전직.현재전직 );
				System.out.println("확정 : 1  / 뒤로가기 : 2 ");
				int ch2 = scanner.nextInt();
				if( ch2 == 1 ) {
					전직 = new 전사( "전사", 500, 100, 200 );
				}
				else if( ch2 == 2 ) { return ;}
			}
			class_change( 전직 );
		}
		else if( ch == 2 ) {
			if( !(전직 instanceof 전사 ) && !(전직 instanceof 마법사) && !(전직 instanceof 도적) ) {
				전직 = new 마법사( "마법사", 200 , 500 , 100 );
			}else if( 전직 instanceof 마법사 ) {
				System.err.println("이미 선택하신 직업입니다");
				return;
			}else if( 전직 instanceof 전사 || 전직 instanceof 도적 ) {
				System.out.println("직업을 변경하시겠습니까 ? ");
				System.out.println("현재직업 : " + 전직.현재전직 );
				System.out.println("확정 : 1  / 뒤로가기 : 2 ");
				int ch2 = scanner.nextInt();
				if( ch2 == 1 ) {
					전직 = new 마법사( "마법사", 200 , 500 , 100 );
				}
				else if( ch2 == 2 ) { return ;}
			}
			class_change( 전직 );
		}
		else if( ch == 3 ) {
			if( !(전직 instanceof 전사 ) && !(전직 instanceof 마법사) && !(전직 instanceof 도적) ) {
				전직 = new 도적( "도적", 300 , 300 , 200 );
			}else if( 전직 instanceof 도적 ) {
				System.err.println("이미 선택하신 직업입니다");
				return;
			}else if( 전직 instanceof 마법사 || 전직 instanceof 전사 ) {
				System.out.println("직업을 변경하시겠습니까 ? ");
				System.out.println("현재직업 : " + 전직.현재전직 );
				System.out.println("확정 : 1  / 뒤로가기 : 2 ");
				int ch2 = scanner.nextInt();
				if( ch2 == 1 ) {
					전직 = new 도적( "도적", 300 , 300 , 200 );
				}
				else if( ch2 == 2 ) { return ;}
			}
			
			class_change( 전직 );
		}
		
	}
	
	// 전직 후 페이지
	public void class_change( 캐릭터 전직 ) {
		System.out.println("전직을 환영합니다!!");
		stat_info();
		if( 전직 instanceof 전사 ) {
			System.out.println();
			전사 워리어 = (전사)전직;
			System.out.println("추가로 아래의 기술을 사용할 수 있습니다.");
			워리어.스킬();
		}else if( 전직 instanceof 마법사 ) {
			System.out.println();
			마법사 위자드 = (마법사)전직;
			System.out.println("추가로 아래의 기술을 사용할 수 있습니다.");
			위자드.스킬();
		}else if( 전직 instanceof 도적 ) {
			도적 어쌔신 = (도적)전직;
			System.out.println();
			System.out.println("추가로 아래의 기술을 사용할 수 있습니다.");
			어쌔신.스킬();
		}
		
		System.out.println();
		System.out.println("전직을 축하합니다! ( \"0\" 키를 눌러 계속하기 )");
		int ch = scanner.nextInt();
	}
	
}
