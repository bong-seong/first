use jsp_web ;

-- 회원 테이블
drop table if exists mpoint;
drop table if exists friend;
drop table if exists member ;

create table member (
	mno int auto_increment primary key,
    mid varchar(30) not null unique,		-- 회원 아이디 [ 공백불가 , 중복불가 ] 
    mpwd varchar(20) not null,				-- 회원 비밀번호 [ 공백불가 ] 
    mimg longtext,							-- 웹서버에 저장된 사진 경로
    memail varchar(100) not null unique		-- 회원 이메일 [ 공백불가 , 중복불가 ]
);


create table friend (
	fno int auto_increment primary key,
    ffrom int,		-- 친구 신청 받은 회원
    fto int, 		-- 친구 신청한 회원
    foreign key ( ffrom ) references member ( mno ) on delete set null ,
    foreign key ( fto ) references member ( mno ) on delete set null		-- 친구가 탈퇴하면 null
);

-- 포인트

create table mpoint (
	mpno int auto_increment primary key,		-- 포인트 내역 식별변호
    mpcomment varchar(1000) not null,			-- 포인트 내역
    mpamount int default 0 ,					-- 포인트 수량
    mdate datetime default now(),				-- 포인트 날짜
    mno int,									-- 포인트 소유 멤버 
    foreign key ( mno ) references member ( mno ) on delete set null -- 탈퇴하면 포인트 null
);




