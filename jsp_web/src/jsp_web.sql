use jsp_web ;

-- 회원 테이블
drop table if exists mpoint;
drop table if exists friend;
drop table if exists board;
drop table if exists category;
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


-- 카테고리 테이블 [ 카테고리번호 , 카테고리이름 (공지사항 , 커뮤니티 , QnA , 노하우 등등) ]
create table category (
	cno int auto_increment primary key,
    cname varchar(100) not null
);


-- 게시물 테이블 [ 번호 , 제목 , 내용 , 첨부파일 , 작성일 , 조회수 , 좋아요수 , 싫어요수 , 작성자 ,카테고리 번호 ]
create table board(
	bno int auto_increment primary key,
    btitle varchar(10001) not null,
    bcontent longtext not null,
    bfile longtext,
    bdate datetime default now(),
    bview int default 0,
    bup int default 0,
    bdown int default 0,
    mno int,
    cno int,
    foreign key ( mno ) references member ( mno ) on delete set null, -- [ 회원 ] PK 가 삭제되면 게시물
    foreign key ( cno ) references category ( cno ) on delete cascade -- [ 카테고리 ] PK 가 삭제되면 해당 카테고리에 해당하는 게시물 같이 삭제
);

-- on delete cascade 	: PK 가 삭제되면 FK 같이 삭제
-- on delete set null 	: PK 가 삭제되면 FK null 값으로 업데이트
-- 생략 					: FK 로 사용되는 PK 는 삭제 불가능

-- 1. 
insert into category ( cname ) values ( '공지사항' ) ;
insert into category ( cname ) values ( '커뮤니티' ) ;
insert into category ( cname ) values ( 'QnA' ) ;
insert into category ( cname ) values ( '노하우' ) ;


