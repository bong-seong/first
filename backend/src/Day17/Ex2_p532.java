package Day17;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Ex2_p532 {
	public static void main(String[] args) {
		
		// 1. Date , SimpleDateFormat
			// 1. Date : Date 객체명 = new Date();
		Date now = new Date();	// 현재 시스템[컴퓨터] 날짜
		System.out.println( now ); // 객체명 [ .toString ] 
		
			// 2. SimpleDateFormat 객체명 = new SimpleDateFormat( 패턴 );
			// 객체명.format( 날짜객체 ) : 해당날짜객체가 패턴 형식으로 변환
			/*
			 	패턴
			 		y : 연도	 /	M : 월 	 /	 d : 일
			 		H : 시	 /	m : 분	 /	 s : 초
			 
			 */
		SimpleDateFormat sdf 
			= new SimpleDateFormat( "yyyy-MM-dd a H:mm:ss");
		System.out.println( sdf.format(now) );
		
		
		// 2. Calender 클래스
		Calendar cal = Calendar.getInstance(); 
		System.out.println( cal );
		
		System.out.println("현재년도 : " + cal.get( Calendar.YEAR ) );
		System.out.println("현재년도 : " + cal.get( 1 ) );
		
		System.out.println("현재 월 : " + (cal.get( Calendar.MONTH ) +1 ) ); // 1월 : 0 / 2월 : 1 ~~~ 12월 : 11
		System.out.println("현재 일/년 : " + cal.get( Calendar.DAY_OF_YEAR ) ); // 년도 기준으로 1월1일부터 현재까지 ~
		System.out.println("현재 일/월 : " + cal.get( Calendar.DAY_OF_MONTH ) ); // 월 기준으로 해당하는 월의 1일부터 ~
		System.out.println("현재 일/주 : " + cal.get( Calendar.DAY_OF_WEEK ) ); // 주 기준으로 일요일부터 해당하는 요일까지의 숫자  1 2 3 4 5 6 7
		
		
		int week = cal.get( Calendar.DAY_OF_WEEK );
		if( week == Calendar.MONDAY ) { System.out.println("월");}
		if( week == 3 ) { System.out.println("화");}
		if( week == Calendar.WEDNESDAY ) { System.out.println("수");}
		if( week == Calendar.THURSDAY ) { System.out.println("목");}
		if( week == 6 ) { System.out.println("금");}
		if( week == Calendar.SATURDAY ) { System.out.println("토");}
		if( week == 1 ) { System.out.println("일");}
		
		// 오전 : 0 || 오후 :1 
		System.out.println("현재 오전/오후 : " + cal.get( Calendar.AM_PM ) );
		int ampm = cal.get(Calendar.AM_PM);
		if( ampm == 0 ) { System.out.println("오전");}
		else { System.out.println("오후");}
		
		System.out.println("현재 시 : " + cal.get(Calendar.HOUR) );
		System.out.println("현재 분 : " + cal.get(Calendar.MINUTE) );
		System.out.println("현재 초 : " + cal.get(Calendar.SECOND) );
		
		
		// 3. 각국의 표준시 코드 ID 얻기
		for( String timeID : TimeZone.getAvailableIDs() ) {
			System.out.println( timeID );
		}
		
		// 4. LocalDateTime
		LocalDateTime dateTime = LocalDateTime.now();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		System.out.println( dtf.format(dateTime));
		
		System.out.println("1년 후 : " + dateTime.plusYears(1) );
		System.out.println("2개월 전 : " + dateTime.minusMonths(2) );
		System.out.println("7일 후 : " + dateTime.plusDays(7) );
		
		
		// 5. 
		LocalDateTime start = LocalDateTime.of(2021 , 1 , 1 , 0 , 0 , 0 );
		LocalDateTime end = LocalDateTime.of(2021,  12, 31 , 0 , 0 , 0 );
		System.out.println("종료일이 시작일 이후 : " + start.isBefore(end) );
		System.out.println("종료일이 시작일 이전 : " + start.isAfter(end) );
		System.out.println("종료일과 시작일이 같은지 : " + start.isEqual(end) );
		
		System.out.println("같은 연도 인지 : " + ( start.until(end, ChronoUnit.YEARS)) );
		System.out.println("월 차 : " + ( start.until(end, ChronoUnit.MONTHS)) );
		System.out.println("월 일 : " + ( start.until(end, ChronoUnit.DAYS)) );
		System.out.println("시 차 : " + ( start.until(end, ChronoUnit.HOURS)) );
		System.out.println("분 차 : " + ( start.until(end, ChronoUnit.MINUTES)) );
		System.out.println("초 차 : " + ( start.until(end, ChronoUnit.SECONDS)) );
		
		
		// 6. 
		double num = 1234567.89;
		
		DecimalFormat df;
		
		// * 천단위 쉼표 만들기 
		df = new DecimalFormat("#,###");
		System.out.println( df.format(num) );
		System.out.println( df.format(0) );
		
		// * 무조건 소수 첫재 자리 표기 [ 없으면 0 ]
			// 0 : 만일 숫자가 없는 자리면 0 채움
			// # : 만일 숫자가 없는 자리면 공백 
		df = new DecimalFormat("#,###.0");
		System.out.println( df.format( 123456.7 ) );
		System.out.println( df.format( 123456 ) );
		
		// * 금액의 천단위 쉼표 : #,##0
		df = new DecimalFormat("#,##0원");
		System.out.println( df.format( 123456 ));
		System.out.println( df.format( 3 ) );
		
		
		
		
		
		// SimpleDateFormat( 패턴 )
		Date date = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println( dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println( dateFormat.format(date) );
		
		dateFormat = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println( dateFormat.format(date) );
		
		dateFormat = new SimpleDateFormat("오늘은 E요일");
		System.out.println( dateFormat.format(date) );
		
		dateFormat = new SimpleDateFormat("오늘은 D번째 날"); // 년 기준으로 일 구함 1/1 ~ 
		System.out.println( dateFormat.format(date) );
		
		dateFormat = new SimpleDateFormat("오늘은 d번째 날");
		System.out.println( dateFormat.format(date) );	 // 일 기준으로 일 구함 해당하는월/1 ~
		
		
		
		
	}
}

