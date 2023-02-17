package Day13.Ex2_p347;

import javax.crypto.spec.RC2ParameterSpec;

public class Audio implements RemoteControl {
	
	// 필드
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	
	@Override
	public void trunOff() {
		System.out.println("Audio를 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME ) { // 만약에 요청한 볼륨이 최대볼륨보다 크면
			this.volume = RemoteControl.MAX_VOLUME; // 현재볼륨에 최대볼륨을 대입
			System.out.println("최대 볼륨보다 커질수 없습니다. 최대볼륨으로 설정");
		}else if ( volume < RemoteControl.MIN_VOLUME ){ // 만약에 요청한 볼륨이 최소볼륨보다 작으면
			this.volume = RemoteControl.MIN_VOLUME;
			System.out.println("최소 볼륨보다 작아질 수 없습니다. 최소 볼륨으로 설정");
		}else {
			this.volume = volume;
		}
		System.out.println("현재 AUDIO 볼륨 : " + this.volume ); // 현재 볼륨 
	}
	
	
	// p.355 추가 내용
	
	// 필드
	private int memoryVolume; // 추가 필드 선언 
		// 음소거 하기 전에 기존 볼륨을 저장하는 변수
	@Override // 디폴트 메소드 오버라이딩
	public void setMute(boolean mute) {
		
		if( mute ) {
			this.memoryVolume = this.volume;
			System.out.println("무음 처리 합니다.");
			setVolume(RemoteControl.MIN_VOLUME);
		}else {
			System.out.println("무음 해제 합니다.");
			// 기존 소음 가져오기
			setVolume( this.memoryVolume );
		}
			
		
	}
	
	

}
