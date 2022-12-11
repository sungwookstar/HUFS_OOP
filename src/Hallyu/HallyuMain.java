/*
 * 1) 과제설명
 * 
 * 객체지향 프로그래밍 평가과제(배점 25점)
 * 학과 : 공과대학 컴퓨터공학부
 * 학번 : 202103093
 * 이름 : 정성욱
 * 
 * 과제 주제 : 권역별 한류컨텐츠의 선호도 순위와 빌보드 차트에 진입한
 * 아티스트의 곡 목록을 찾아주는 프로그램
 */


package Hallyu;
import java.io.*;
import java.util.*;
public class HallyuMain {

	public static void main(String[] args) throws Exception {
		// 4)예외처리 : throws 키워드를 통해 자신을 호출한 메서드에게 책임을 전가
		// 4)예외처리 : try ~ catch 문을 이용한 예외처리, 파일이 없거나 입출력 오류 처리
		try {
			// 8)파일입출력 : txt파일을 불러오기 위해 입출력 스트림 중 BufferedInputStream 사용
			// 8)파일입출력 : C:\\java_txt\\Definition.txt에서 한류의 정의를 불러옴

			String path = "C:\\java_txt\\Definition.txt"; 
			// 8)파일입출력 : file input stream
			FileInputStream fis = null;
			// 8)파일입출력 : 파일 스트림 생성
			fis = new FileInputStream(path);
			
			// 8)파일입출력 : 버퍼 선언
			byte[] readBuffer = new byte[fis.available()];
			
			while (fis.read( readBuffer ) != -1){}
			// 8)파일입출력 : 출력
			System.out.println(new String(readBuffer));
			// 8)파일입출력 : 스트림 닫기(메모리 누수 방지)
			fis.close();
			
		} // 4)예외처리 : try ~ catch 문을 이용한 예외처리, 파일이 없거나 입출력 오류 처리
		catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		Scanner sc = new Scanner(System.in);
		
		// 6)참조타입 : 참조타입(배열)로 5개의 권역명을 배열에 저장하여 활용할 수 있도록 함
		String[] ContinentArr = 
			{"아시아","미주","유럽","중동","아프리카"};
		
		// 8)파일입출력 : 파일 입출력의 프린터 보조 스트림을 이용하여 라인 단위로 출력함
		// 8)파일입출력 : 바이트 기반 출력 스트림을 생성하고 프린트 스트림 보조 스트림 연결
		FileOutputStream fos = new FileOutputStream("C:\\java_txt\\selectList.txt");
		// 8)파일입출력 :  프린트 스트림 생성
		PrintStream ps = new PrintStream(fos);
		
		
		
		// 6)참조타입 : 참조타입(열거타입) 선언한 변수에 열거 상수 대입
		Contents kpop = Contents.KPOP;
		Contents it = Contents.IT;
		Contents taekwondo = Contents.TAEKWONDO;
		Contents food = Contents.FOOD;
		Contents beauty = Contents.BEAUTY;
		Contents star = Contents.STAR;
		Contents car = Contents.CAR;
		Contents fashion = Contents.FASHION;
		Contents drama = Contents.DRAMA;
		Contents kitchen = Contents.KITCHEN;
		Contents animation = Contents.ANIMATION;
		Contents game = Contents.GAME;
		Contents movie = Contents.MOVIE;
		
		// 5) 다형성 : 클래스 상속을 활용한 다형성 구현
		Continent continent= new Continent(ContinentArr[0],
								ContinentArr[1],ContinentArr[2],
								ContinentArr[3],ContinentArr[4]);
		
		Asia asia = new Asia(kpop.getName(),
				drama.getName(),food.getName(),
				beauty.getName(),star.getName());
		
		America america = new America(kpop.getName(),taekwondo.getName(),
				food.getName(),kitchen.getName(),animation.getName());
		
		Europe europe = new Europe(kpop.getName(),it.getName(),
				taekwondo.getName(),car.getName(),food.getName());
		
		MiddleEast middleeast = new MiddleEast(drama.getName(),beauty.getName(),
				car.getName(),movie.getName(),it.getName());
		
		Africa africa = new Africa(it.getName(),animation.getName(),
				fashion.getName(),game.getName(),kitchen.getName());
		
		BillboardInfo billboardinfo = new BillboardInfo();
		
		int select;
		
		Continent selectContinent = null;
		ps.println("선택한 권역 목록");
		// 5) 다형성 : 클래스 상속을 활용한 필드의 다형성 구현
		while(true) {
			// 4)예외처리 : try ~ catch 문을 이용한 예외처리, 숫자입력시 잘못된 입력을 방지
			try {
			selectContinent = continent;
			selectContinent.printInfo();
			select = Integer.parseInt(sc.nextLine());
			
			if(select==0) {
				System.out.println("다음 선택으로 넘어갑니다.");
				System.out.println("==============================");
				System.out.println("==============================");
				break;
			}

			//8) 파일입출력 : 선택한 선택지를 txt파일에 기록
			switch(select) {
			case 1:
				selectContinent = asia;
				selectContinent.printInfo();
				ps.println("아시아");
				break;
			case 2:
				selectContinent = america;
				selectContinent.printInfo();
				ps.println("미주");
				break;
			case 3:
				selectContinent = europe;
				selectContinent.printInfo();
				ps.println("유럽");
				break;
			case 4:
				selectContinent = middleeast;
				selectContinent.printInfo();
				ps.println("중동");
				break;
			case 5:
				selectContinent = africa;
				selectContinent.printInfo();
				break;
			default:
				System.out.println("잘못입력하셨습니다 다시 입력해주세요");
				break;
				
			}
			}catch(NumberFormatException e) {
				System.out.println("잘못입력하셨습니다 다시 입력해주세요");
			}
				
		}
		
		ps.println("=================================");
		ps.println("선택한 가수 목록");
		while(true) {
			// 4)예외처리 : try ~ catch 문을 이용한 예외처리, 숫자입력시 잘못된 입력을 방지
			try {
			System.out.println("\n빌보드에 진입한 아티스트의 곡 목록");
			System.out.println("1. 싸이");
			System.out.println("2. BTS");
			System.out.println("3. 블랙핑크");
			System.out.println("0. 종료");
			select = Integer.parseInt(sc.nextLine());

			
			if(select==0) {
				System.out.println("종료합니다.");
				break;
			}
			//3) 인터페이스 : 매개변수의 다형성을 위한 인터페이스 사용
			//8) 파일입출력 : 선택한 선택지를 txt파일에 기록
			switch(select) {
			case 1:
				billboardinfo.information(new Psy());
				ps.println("싸이");
				break;
			case 2:
				billboardinfo.information(new BTS());
				ps.println("BTS");
				break;
			case 3:
				billboardinfo.information(new BlackPink());
				ps.println("블랙핑크");
				break;
			default:
				System.out.println("잘못입력하셨습니다 다시 입력해주세요");
				break;
			}
			}catch(NumberFormatException e) {
				System.out.println("잘못입력하셨습니다 다시 입력해주세요");
			}
		}
		sc.close();
		ps.close();
		System.out.println("선택지를 기록했습니다.");
	}
}

		




		



