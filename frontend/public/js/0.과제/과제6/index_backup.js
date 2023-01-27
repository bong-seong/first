// 1. userbox / logbox / monbox Dom 객체 가져오기
let userbox = document.querySelector('.userbox')
let logbox = document.querySelector('.logbox')
let logbox2 = document.querySelector('.logbox2')
let monbox = document.querySelector('.monbox')
let u_hpbar = document.querySelector('.u_hpbar')
let m_hpbar = document.querySelector('.m_hpbar')


let u_hp_text = document.querySelector('.u_hp_text')
let m_hp_text = document.querySelector('.m_hp_text')


// * userbox [기본/처음] 위치
let u_left = 10;	// 유저
let m_left = 910; 	// 몬스터
let user_HP = 400;
let monster1 = 400; // 몬스터 체력

let monster = [
	{ m_img: '스포아.gif' , hp: 100 , left: 900 },
	{ m_img: '경호대장.gif' , hp: 250 , left: 900 },
	{ m_img: '파란버섯.gif' , hp: 400 , left: 900 },
]





// js 처음 실행시 렌더링 //
u_hp_text.innerHTML = `체력 : ${ user_HP }`			// 유저 체력게이지
m_hp_text.innerHTML = `체력 : ${monster1}`	// 몬스터 체력게이지
logbox.innerHTML = `<div> 캐릭터 좌표 : ${ u_left } </div>`
logbox2.innerHTML = `<div> 몬스터 좌표 : ${ m_left } </div>`
// js 실행시 표시 //

// 2. 문서 안에서 키 입력 이벤트
document.addEventListener( 'keydown' , (e)=>{
	
	let key = e.keyCode; // 입력된 키 코드를 변수에 저장
	if( key == 37 ){ // 왼쪽
		u_left -= 10
		u_left = u_left < 0 ? 0 : u_left ;	// 만약에 차감된 왼쪽 좌표가 0보다 작으면 0 아니면 u_left;
		 
	}else if( key == 39){ // 오른쪽
		u_left += 10
		u_left = u_left > 920 ? 920 : u_left ;
		userbox.style.backgroundImage = `url(img/캐릭터2.png)` // 이동모션이미지
		userbox.style.backgroundSize = `85%`
	}else if( key == 65 ){ // a키 -> 공격
		userbox.style.backgroundImage = `url(img/캐릭터3.png)` // 공격모션이미지
		userbox.style.backgroundSize = `85%`
		// * 
		if( mon_moving() - u_left < 150 && mon_moving() - u_left > 0 ){ 
			monster1 -= userPower()
			m_hpbar.style.width = `${ monster1 }px`
			m_hp_text.innerHTML = `체력 : ${monster1}`	// 몬스터 체력게이지
		}
	}
		
	
	
	userbox.style.left = `${ u_left }px` // * 키 입력후 css: left 변경
	//*
	logbox.innerHTML = `<div> 캐릭터 좌표 : ${ u_left } </div>`	
})


// 2. 문서안에서 키 떼었을때 이벤트
document.addEventListener( 'keyup' , (e)=>{
	userbox.style.backgroundImage = `url(img/캐릭터1.png)`
	userbox.style.backgroundSize = `85%`
})


// 3. 몬스터 이동 난수[ 랜덤 -> 1초 ]
	// 특정 시간마다 함수 실행해주는 함수 : setInterval( ()=>{} , 밀리초(1000/1초 ) )

let moving = setInterval( mon_moving, 500 ) 	

function mon_moving(){
	// 1. 난수 +-10
	let rand = parseInt( Math.random()*30+10 ) // 1~10 사이의 실수 // 이동거리 
	let rand2 = parseInt( Math.random()*2 ); // 0 또는 1 // 이동 방향
	if( rand2 == 1 ) m_left += rand //
	else m_left -= rand //
	
	// 2. 게임화면에 고정 
	if( m_left < 0 ){ m_left = 0; }
	if( m_left > 900 ){ m_left = 900; }
	// 3.
	monbox.style.left = `${ m_left }px`
	// * 현재 좌표를 로그에 출력
	logbox2.innerHTML = `<div> 몬스터 좌표 : ${ m_left } </div>`
	
	
	userHit()
	
	
	if( monster1 < 0){ 
		clearInterval( moving )
		monbox.style.backgroundImage = `none` 
	}
	
	
	return m_left
}

function userPower(){
	let attack = parseInt( Math.random()*30+10)
	return attack
}

function monstPower(){
	let attack = parseInt( Math.random()*10+5)
	return attack
}


function userHit(){
	
	let hitbox = m_left - u_left
	
	if( hitbox < 50 && hitbox > -50){ 
		 user_HP -= monstPower()
		 u_hpbar.style.width = `${user_HP}px`
		 u_hp_text.innerHTML = `체력 : ${user_HP}`
	}
	
	if( user_HP < 0 ){ 
		document.querySelector('.gameover').style.display = `block`;
	}
}


/*
	함수 형태
		1. 일반함수 : function 함수명(){ }
		2. 익명함수 : function(){ }
		3. 람다식함수 : ()=>{ } 
		4. 변수함수 : let 변수명 = ()=>{ }
	Math.random() : 0~1 사이의 실수
	Math.random()*10 : 0~10 사이의 실수 ==> 10은 절대안나옴 9.9999999
*/


// ############################################################################### //
// ############################################################################### //
// ############################################################################### //















