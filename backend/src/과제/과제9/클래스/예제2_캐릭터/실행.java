package 과제.과제9.클래스.예제2_캐릭터;

public class 실행 {
	public static void main(String[] args) {
		
		
		캐릭터 캐릭터1 = new 전사( 500, 100, 100 );
		
		System.out.println("-------- 전사 --------");
		System.out.println("체력 : " + 캐릭터1.체력 );
		System.out.println("마력 : " + 캐릭터1.마력 );
		System.out.println("스테미너 : " + 캐릭터1.스테미너 );
		
		캐릭터1.공격();
		전사 전사 = (전사)캐릭터1;
		System.out.println("전사로 전직하였습니다.");
		
		전사.칼();
		전사.방패();
		
		
		캐릭터 캐릭터2 = new 마법사( 200 , 500 , 50 );
		
		System.out.println("-------- 마법사 --------");
		System.out.println("체력 : " + 캐릭터2.체력 );
		System.out.println("마력 : " + 캐릭터2.마력 );
		System.out.println("스테미너 : " + 캐릭터2.스테미너 );
		
		캐릭터2.공격();
		마법사 마법사 = (마법사)캐릭터2;
		System.out.println("마법사로 전직하였습니다.");
		
		마법사.지팡이();
		마법사.마법();
		
		
		캐릭터 캐릭터3 = new 도적( 300 , 200 , 150 );
		
		System.out.println("-------- 마법사 --------");
		System.out.println("체력 : " + 캐릭터3.체력 );
		System.out.println("마력 : " + 캐릭터3.마력 );
		System.out.println("스테미너 : " + 캐릭터3.스테미너 );
		
		캐릭터3.공격();
		도적 도적 = (도적)캐릭터3;
		System.out.println("도적으로 전직하였습니다.");
		
		도적.단검();
		도적.은신();
		
	}
}
