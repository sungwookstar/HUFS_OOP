package Hallyu;
//6) 참조타입 : 열거타입의 생성자를 이용해 문자열 타입을 담을 수 있도록 함
public enum Contents {
	KPOP("케이팝"),
	IT("IT 기술"),
	TAEKWONDO("태권도"),
	DRAMA("드라마"),
	ANIMATION("애니메이션"),
	FOOD("음식"),
	BEAUTY("뷰티"),
	STAR("한류스타"),
	CAR("자동차"),
	FASHION("패션"),
	KITCHEN("한국식당"),
	MOVIE("영화"),
	GAME("게임");
	
    String name;
    
    Contents(String name){
        this.name = name;
    }
    
    String getName() {
    	return this.name;
    }
}

