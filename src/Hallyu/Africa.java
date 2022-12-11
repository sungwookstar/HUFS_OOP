
package Hallyu;
//2) 클래스 상속 : Continent 클래스를 상속하여 아프리카 클래스 구현
public class Africa extends Continent{
	String name;
	Africa(String first,String second,
			String third,String fourth,String fifth){
		super(first,second,third,fourth,fifth);
	}
	
	//재정의
	@Override
	void printInfo() {
		System.out.println("선호도 순위");
		System.out.println("1."+this.first);
		System.out.println("2."+this.second);
		System.out.println("3."+this.third);
		System.out.println("4."+this.fourth);
		System.out.println("5."+this.fifth);
		System.out.println();
		
	}
}
