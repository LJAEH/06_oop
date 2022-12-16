package edu.kr.oop.method.run;

import edu.kr.oop.method.model.service.MemberService;

public class Run {

// [접근제한자][예약어] 반환형 메서드명([매개변수])
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberService ms = new MemberService();
		// MemberService의 기본 생성자가 작성되어 있지는 않지만
		// 문제없이 사용가능.. (컴파일러가 자동으로 생성해줌)
		
		// !!주의할점!!
		// 생산자가 하나라도 있으면 기본생성자 자동 생성 안해줌
		ms.displayMenu();
		
	}

}
