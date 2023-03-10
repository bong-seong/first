package model.dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 create table member (
	mno int auto_increment primary key,
    mid varchar(30) not null unique,		-- 회원 아이디 [ 공백불가 , 중복불가 ] 
    mpwd varchar(20) not null,				-- 회원 비밀번호 [ 공백불가 ] 
    mimg longtext,							-- 웹서버에 저장된 사진 경로
    memail varchar(100) not null unique		-- 회원 이메일 [ 공백불가 , 중복불가 ]
);
 */

public class MemberDto {
	
	// 1. 필드
	private int mno;
	private String mid;
	private String mpwd;
	private String mimg;
	private String memail;
	
	
	// 1. 이메일 전송 메소드 [ 받는사람이메일 , 받는내용 HTML ]
	public boolean sendEmail( String toEmail , String contentHTML ) {
		
		// 1. 보내는 사람의 정보
		String fromEmail = "네이버이메일주소"; 	// 네이버이메일주소		// * 실제 계정정보 git 올리지말기 !!!
		String Emailpwd = "네이버이메일 비밀번호";	// 네이버이메일 비밀번호	// * 실제 계정정보 git 올리지말기 !!!
		// 2. 호스팅 설정 [ 네이버 기준 ]
		Properties properties = new Properties();
		properties.put( "mail.smtp.host", "smtp.naver.com" );		// smtp.gmail.com
		properties.put( "mail.smtp.port", 587 );					// 동일
		properties.put( "mail.smtp.auth", true );					// 동일
		properties.put( "mail.smtp.ssl.protocols", "TLSv1.2" );		// 동일
		
		// 3. 인증처리 [ Session : import javax.mail; ]
			// Session.getDefaultInstance( '설정' , new Authenticator() {} );
			// [ Authenticator : javax.mail ]
			// [ PasswordAuthentication : javax.mail ] 
			// new PasswordAuthentication("인증할계정주소", "비밀번호" );
		Session session = Session.getDefaultInstance(
				properties , new Authenticator() {
					// 패스워드인증 함수를 오버라이딩
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, Emailpwd);
					}
				});
		// 4. 메일 보내기
		try {
			// Mime프로토콜 : smtp가 보낼수 있는 표쥰 형식[포멧] 
			MimeMessage message = new MimeMessage( session ); // 인증된 세션 대입해서 포멧
			message.setFrom( new InternetAddress( fromEmail ) );
			message.addRecipient( Message.RecipientType.TO , new InternetAddress( toEmail ) );
			// 내용 구성
			message.setSubject( "Ezen community 회원가입 메일 인증코드" ); // 메일 제목
			message.setText( contentHTML );
			// 전송
			Transport.send(message); // 표준형식[포멧]의 데이터를 SMTP 전송
			
			return true; // 메일 전송 성공
		}catch (Exception e) { System.out.println(e); }
		
		return false; // 메일 전송 실패
	}
	
	
	
	// 2. 생성자
	public MemberDto() {}

	public MemberDto(int mno, String mid, String mpwd, String mimg, String memail) {
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mimg = mimg;
		this.memail = memail;
	}

	
	// 3. 메소드
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mimg=" + mimg + ", memail=" + memail
				+ "]";
	}
	
	
	
	
}
