package Hallyu;
//2) 클래스 상속 : 상속을 위한 Continent 클래스
public class Continent {
	String first,second,third,fourth,fifth;

	//생성자
	Continent(String first,String second,
			String third,String fourth,String fifth){
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		
	}
	//권역의 이름을 출력하는 함수
	void printInfo() {
		System.out.println("선호도 순위를 보고싶은 권역의 번호를 선택하세요 ");
		System.out.println("1."+first);
		System.out.println("2."+second);
		System.out.println("3."+third);
		System.out.println("4."+fourth);
		System.out.println("5."+fifth);
		System.out.println("0. 종료");
		System.out.println();
	}
	
	
}

