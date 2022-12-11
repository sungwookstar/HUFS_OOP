package Hallyu;

import java.util.Arrays;
import java.util.List;

//3)인터페이스,5)다형성 : 인터페이스의 매개변수 다형성의 구현객체
public class BTS implements Singer {
	//7) 컬렉션 프레임워크 : 컬렉션 프레임워크(리스트)를 사용하여,곡 목록 리스트를 만들고 출력
	@Override
	public void info() {
		List<String> bts = Arrays.asList("DNA","MIC Drop","FAKE LOVE");
		System.out.println("BTS의 빌보드 차트 진입곡");
		for(String s : bts) {
			System.out.println(s);
		}
		
	}
}
