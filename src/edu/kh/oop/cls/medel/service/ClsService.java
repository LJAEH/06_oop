package edu.kh.oop.cls.medel.service;

import edu.ku.oop.cls.model.vo.User;
import edu.ku.oop.cls.model.vo.student;

public class ClsService {
	// 클래스 접근제한자 확인하기
	
	public void ex1() {
		student std = new student();
		// public class 인 Student 는 import 가능
		
		//TestVo test = new Testvo();
		// (default) class인 TestVo는 import 불가 (다른 패키지여서)
		
		System.out.println(std.v1);
		// 다른 패키지에서도 접근 가능한 public만 에러가 없다
	}
	
	public void ex2() {
		// static 필드 확인 예제
		
		
		student std1 = new student();
		student std2 = new student();
		
		System.out.println(std1.schoolName);
		// public 이기 때문에 직접 접근가능
		//System.out.println(std1.Name);
		
		System.out.println("변경전" + std1.getName());
		std1.setName("이재혁");
		System.out.println("변경후" + std1.getName());

		System.out.println(std2.schoolName);
		// public 이기 때문에 직접 접근가능
		
		System.out.println("변경전" + std1.schoolName);
		std1.schoolName = "고등학교!";
		System.out.println("변경후" + std1.schoolName);
		
		// schoolName에 노란줄이 뜨는 이유! -> 제대로 작성 안해서
		// *** static 이 붙은 필드(변수)는
		// 클래스명.변수명 으로 사용함
		
		/*student.schoolName = "kgg";
		System.out.println("student.schoolName : " + student.schoolName);
		*/

		/*
			static
			
			1) 공유메모리 영역(또는 정적 메모리 영역) 이라고 함
			=> 프로그램 시작 시 static이 붙은 코드들이
			모두 static 영역에 생성되고
			프로그램이 종료될 때 까지 사라지지않음. (정적)
			그리고 static 영역에 생성된 변수는 어디서든 공유가능 (ㄷ공유)
			
			2) 사용법 : 클래스명.변수명

		*/
	}
	
	public void ex3() {
		// 생성자 확인 테스트
		
		student s1 = new student();
					  // 기본 생성자
		
		// User 기본 생성자를 이용해 객체생성
		User u1 = new User();
		
		// User 객체 필드 초기화 확인
		//System.out.println(u1.getName());
		// ==> 클래스에서 메서드에 getter/setter가 정의되지않음
		//간접 접근 불가능
		
		System.out.println(u1.getUserId());
		System.out.println(u1.getUserName());
		System.out.println(u1.getUserPw());
		System.out.println(u1.getUserGender());
		System.out.println(u1.getUserAge());
		
		User u2 = new User();
		
		
		System.out.println("=================================");
		
		// 현재의 문제점 : u1이 참조하는 User 객체와 
		//              u2가 참조하는 User 객체가 같이 모두 동일함 
		//              같은 기본생성자로 User 객체 생성했기 때문임
		
		// 해결 방법 1 : setter를 이용해서 새로운 값 대입
		
		u2.setUserId("wowoowo");
		u2.setUserPw("wwwwss");
		u2.setUserName("koko");
		u2.setUserAge(4);
		u2.setUserGender('M');

		System.out.println(u2.getUserId());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserGender());
		System.out.println(u2.getUserAge());
		
		
        // 해결 방법 2 : 매개변수 생성자 이용
		
		
		User u3 = new User("코코아","좋아","코코",4,'M');
		
		
		System.out.println(u3.getUserId());
		System.out.println(u3.getUserPw());
		System.out.println(u3.getUserName());
		System.out.println(u3.getUserAge());
		System.out.println(u3.getUserGender());
		// 여기서 u3 : 지역변수  
		
		
	}
}

