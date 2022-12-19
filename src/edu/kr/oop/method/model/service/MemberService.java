package edu.kr.oop.method.model.service;

import java.util.Scanner;

import edu.kr.oop.method.model.vo.Member;

public class MemberService { // 클래스
	// 속성(필드)
	// 필드는 기본적으로 캡슐화 원칙에의해 private 이라는 접근 대상자를 꼭 작성
	// 필드에 변수를 하나 작성하면, 클래스 안에서 어디에서든 사용 가능
	
	private Scanner sc = new Scanner(System.in);
			// Systen.in :  자바에서 기본적으로 지정해둔 입력장치(키보드)
	
	private Member memberInfo = null; // 가입한 회원의 정보를 저장할 변수
	// 자료형 Member이며 
	
	private Member loginMember = null; // 로그인한 회원은 정보를 저장할 변수
	
	// 기능(생성자, 메서드)
	// 여러기능을 하나의 메소드에 모두 작성하지 말 것..
	// 되도록 하나의 기능만 수행하도록 작성
	// 메소드는 메소드당 딱 하나의 기능만 가지고 있는게 좋다.
	
	// why?
	// 기능별로 세분화 해둬야 필요한 기능만 호출하여 쓸 수 있다.
	/*
	public void today() {
		// 1. 밥먹는 행위
		// 2. 일하는 행위
	}
	
	public void eat() {}
	public void work() {}
	*/
		// 두가지를 나눠서 메소드를 만들고,
		// eat(); work(); 하나씩 골라서 쓸 수 있게 된다.
	
	public MemberService() {}

	// public MemberService(int a) {}
	
	// ** 메서드 작성법 **
	// [접근제한자]   [예약어]      반환형         메소드명([매개변수]) {}
	//  public     static    기본자료형
	// protected    final   참조형(배열,클래스)
	// (default)  abstract    void
	//  private  static final
	
	// ** 반환형 void **
	// - 반환(return)이란? 메서드 수행 후 호출부로 돌아가는 것
	// - 반환 값 : 돌아가면서 가져갈 결과 값
	// - 반환 형 : 반환 값의 자료형
	// -> void (텅빈, 없는, 무효의) : 흘려보낼 값(변환 값)이 없다.
	
	// 메뉴화면 출력기능
	public void displayMenu() {
		// 일은 하는데 결과값은 없음
		int menuNum = 0; // 지역 변수
		
		do {
			System.out.println("=====회원 정보 관리 프로그램=====");
			System.out.println("1.회원 가입");
			System.out.println("2.로그인");
			System.out.println("3.회원 정보 조회");
			System.out.println("4.회원 정보 수정");
			System.out.println("0.프로그램 종료");
			
			System.out.print("메뉴입력 >>>>");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc 사용
			sc.nextLine(); //입력버퍼에 남은 개행문자 제거
			
			switch(menuNum) {
			case 1 : System.out.println( signup() ); break;
			case 2 : System.out.println( login() ); break;
			case 3 : System.out.println( selectMember() );break;
			case 4 : 
				// 회원 정보 수정 메서드 수행후
				// 반환되는 결과를 result 변수에 저장
				int result = updateMember(); // -1 or 0 or 1
				
				if (result == 1) {
					System.out.println("로그인해주세요");
				} else if (result == 0) {
					System.out.println("회원정보수정실패(비밀번호불일치)");
				} else {
					System.out.println("회원정보가수정되었습니다");
				}
				
				break;
			case 0 : System.out.println("프로그램 종료합니다");
				break;
			default : System.out.println("잘못된 입력입니다. 다시입력");
			}
			
		}while(menuNum != 0); // menuNum 이 0 이면 반복종료
		
		
	}
	
	// 회원 가입 기능
	public String signup() {
		// (반환형)
		System.out.println("++++ 회원가입 ++++");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("비밀번호확인 : ");
		String memberPw2 = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
		if(memberPw.equals(memberPw2)) {
			memberInfo = new Member(memberId, memberPw,
					memberName, memberAge);
			return "회원 가입 완료";	
		} else {
			return "비밀번호 불일치 재시도" ;
			
		}
		
	}
	
	// 로그인 메서드(기능)
	public String login() {
		
		System.out.print("==로그인==");
		
		// 회원가입을 했는지 부터 확인
		// ** memberInfo가 객체를 참조하고 있는지 확인
		if( memberInfo == null ) { // 회원가입을 먼저 안한 경우
			return "회원 가입을 진행해주세요";
		}
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		if (memberId.equals(memberInfo.getMemberId())&& 
				memberPw.equals(memberInfo.getMemberPw())) {	
			loginMember = memberInfo;
			return  loginMember.getMemberId() + "님 환영합니다";
		} else {
			return "아이디 또는 비밀번호가 일치하지 않습니다";
		}
		
	}
	
	// 회원 정보 조회 기능
	// 아이디, 이름, 나이 까지만 조회
	
	// CRUD ( C:Create, R:Read, U:Update, D:Delete )
	
	public String selectMember() {
		System.out.println("회원 조회 정보");
		
		//손코딩해보기
		// 1) 로그인 여부 확인 => 필드 loginMember가 참조하는 객체가 있는지 확인

		if(loginMember == null) {
			return "로그인 해주세요";
		} else {
		// 2) 로그인이 되어있는 경우
		//    회원정보를 출력할 문자열을 만들어서 반환(return)
		//    단, 비밀번호는 제외
		
		String str = "이름 : " + loginMember.getMemberName();
		str += "\n아이디 : " + loginMember.getMemberId();
		str += "\n나이 : " + loginMember.getMemberAge();
		
		return str;
		
		}
		
	}
	
	// 회원 정보 수정(update) 기능
	
	public int updateMember() {
		System.out.println("\n회원 정보 수정");
		
		// 1) 로그인 여부 판별
		//    로그인이 되어있지 않으면 -1변환
		if (loginMember == null) {
			return -1;
		}
		// 2) 수정할 회원 정보 입력 받기(이름, 나이)
			System.out.print("수정할 이름 입력 : ");
			String inputName = sc.next();
			
			System.out.print("수정할 나이 입력 : ");
			int inputAge = sc.nextInt();
			
			sc.nextLine();
			// 입력버퍼 초기화
		
		
		// 3) 비밀번호 입력받아서
		//	  로그인한 회원의 비밀번호와 일치하는지 확인
			
			System.out.print("비밀번호 입력 : ");
			String inputPw = sc.next();
			
			if( inputPw.equals(loginMember.getMemberPw())) {
				
				loginMember.setMemberName(inputPw);
				// 입력받은 inputName을
				// loginMember가 참조하는 Member객체의 필드 member
				loginMember.setMemberAge(inputAge);
				
				return 1;
			}
		// 4) 비밀번호 같은 경우
		//	  로그인한 회원의 이름, 나이 정보를 입력받은 값으로 변경후
		//	  1 반환
		
		// 5) 비밀번호가 다른경우 0 반환
	}
	
}
