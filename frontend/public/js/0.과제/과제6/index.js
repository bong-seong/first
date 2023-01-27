// 1. userbox / logbox / monbox Dom 객체 가져오기
let userbox = document.querySelector('.userbox')
let logbox = document.querySelector('.logbox')
let logbox2 = document.querySelector('.logbox2')
let monbox = document.querySelector('.monbox')
let u_hpbar = document.querySelector('.u_hpbar')
let m_hpbar = document.querySelector('.m_hpbar')
let u_hpbar_back = document.querySelector('.u_hpbar_back')
let m_hpbar_back = document.querySelector('.m_hpbar_back')

let u_hp_text = document.querySelector('.u_hp_text')
let m_hp_text = document.querySelector('.m_hp_text')


// * userbox [기본/처음] 위치



let monster = [
	{ m_img: '스포아.gif' , hp: 100 , left: 900, exp: 50, maxhp: 100 },
	{ m_img: '경호대장.gif' , hp: 250 , left: 900, exp: 100, maxhp: 250 },
	{ m_img: '파란버섯.gif' , hp: 400 , left: 900, exp: 0, maxhp: 400 },
]

let upindex = 0;

let c_img = [ '캐릭터1.png' , '캐릭터2.png' , '캐릭터3.png']

let user = {
	img: c_img,
	maxhp: 200,
	hp: 200,
	left: 10,
	exp: 0,
	lev: 1,
	power: 20
}

let user_HP = user.hp * user.lev ;

// js 처음 실행시 렌더링 //
u_hp_text.innerHTML = `체력 : ${ user_HP }`			// 유저 체력게이지
m_hp_text.innerHTML = `체력 : ${ monster[upindex].hp }`	// 몬스터 체력게이지
logbox.innerHTML = `<div> 캐릭터 좌표 : ${ user.left } </div>`
logbox2.innerHTML = `<div> 몬스터 좌표 : ${ monster[upindex].left } </div>`
// js 실행시 표시 //

// 2. 문서 안에서 키 입력 이벤트
document.addEventListener( 'keydown' , (e)=>{
	
	let key = e.keyCode; // 입력된 키 코드를 변수에 저장
	if( key == 37 ){ // 왼쪽
		user.left -= 10
		user.left = user.left < 0 ? 0 : user.left ;	// 만약에 차감된 왼쪽 좌표가 0보다 작으면 0 아니면 u_left;
		 
	}else if( key == 39){ // 오른쪽
		user.left += 10
		user.left = user.left > 920 ? 920 : user.left ;
		userbox.style.backgroundImage = `url(img/캐릭터2.png)` // 이동모션이미지
		userbox.style.backgroundSize = `85%`
	}else if( key == 65 ){ // a키 -> 공격
		userbox.style.backgroundImage = `url(img/캐릭터3.png)` // 공격모션이미지
		userbox.style.backgroundSize = `85%`
		// * 
		if( mon_moving() - user.left < 150 && mon_moving() - user.left > 0 ){ 
			monster[upindex].hp -= userPower()
			m_hpbar.style.width = `${ monster[upindex].hp }px`
			m_hp_text.innerHTML = `체력 : ${ monster[upindex].hp }`	// 몬스터 체력게이지
		}
	}
	
	
	
	userbox.style.left = `${ user.left }px` // * 키 입력후 css: left 변경
	//*
	logbox.innerHTML = `<div> 캐릭터 좌표 : ${ user.left } </div>`	
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
	if( rand2 == 1 ) monster[upindex].left += rand //
	else monster[upindex].left -= rand //
	
	// 2. 게임화면에 고정 
	if( monster[upindex].left < 0 ){ monster[upindex].left = 0; }
	if( monster[upindex].left > 900 ){ monster[upindex].left = 900; }
	// 3.
	monbox.style.left = `${ monster[upindex].left }px`
	// * 현재 좌표를 로그에 출력
	logbox2.innerHTML = `<div> 몬스터 좌표 : ${ monster[upindex].left } </div>`
	
	
	userHit()
	
	
	if( monster[upindex].hp < 0){ 
		
		upindex++
		
		if( upindex >= monster.length){  
			clearInterval( moving )
			monbox.style.backgroundImage = `none`
			document.querySelector('.gameclear').style.display = `block`;
		}
		else{ 
			user.exp += monster[upindex-1].exp
			levelUp(); statusPrint()
			console.log( user.exp )
			console.log( user.lev )
		}
	}
	
	
	return monster[upindex].left
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
	
	let hitbox = monster[upindex].left - user.left
	
	statusPrint()
	
	if( hitbox < 50 && hitbox > -50){ 
		user.hp -= monstPower()
		u_hpbar.style.width = `${ user.hp }px`
		u_hp_text.innerHTML = `체력 : ${ user.hp }`
	}
	
	if( user.hp < 0 ){ 
		document.querySelector('.gameover').style.display = `block`;
	}
}



function statusPrint(){
	
	u_hp_text.innerHTML = `체력 : ${ user.hp }`
	u_hpbar.style.width = `${ user.hp }px`
	u_hpbar_back.style.width = `${ user.maxhp }px`
			
	m_hp_text.innerHTML = `체력 : ${ monster[upindex].hp }`
	m_hpbar.style.width = `${ monster[upindex].hp }px`
	m_hpbar_back.style.width = `${ monster[upindex].maxhp }px`
			
	monbox.style.backgroundImage = `url("img/${monster[upindex].m_img}")`	

}




function levelUp(){ 
	if( user.exp > 100 ){ 
		user.lev++ ;
		user.exp = 0 ;
		user.hp = user.lev * user.maxhp
		user.maxhp = user.lev * user.maxhp
	}
}


// ############################################################################### //

/*
	함수 형태
		1. 일반함수 : function 함수명(){ }
		2. 익명함수 : function(){ }
		3. 람다식함수 : ()=>{ } 
		4. 변수함수 : let 변수명 = ()=>{ }
	Math.random() : 0~1 사이의 실수
	Math.random()*10 : 0~10 사이의 실수 ==> 10은 절대안나옴 9.9999999
*/















