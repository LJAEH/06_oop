package edu.ku.oop.cls.model.vo;

public class User {
	
	// 클래스에 필요한 3가지 
	
	// 필드
	// == 속성
	
	// 아이디, 비밀번호, 이름, 나이, 성별 (추상화 진행)
	
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender; // <<= 멤버변수 (static 변수없이 만들어짐)
	
	// 생성자
	// 기본생성자 
	public User() {
		// 기능
		System.out.println("기본 생성자로 User 객체 생성");
		
		// 필드 초기화 + 기능
		userId = "user01";
		userPw = "www123";
		userName = "jaehuyk";
		userAge = 29;
		userGender = 'M';		
	} 
	
	// 매개변수 생성자
	// ** 사용되는 기술, 변수 : 매개변수, Overloading(오버로딩), this 
	
	// ** 매개변수 : 생성자나 메서드 호출 시 () 안에 작성되어 전달
	//			   되어지는 값을 저장하는 변수
	//           -> 전달 받은 값을 저장하고있는 매개체(지니고있음) 역할의 변수
	

	// 필드를 전부 초기화 하는 목적의 매개변수 생성자
	public User(String userId,String userPw,String userName,
			int userAge,char userGender) { // <= 매개변수생성자

		// 이미 생성된 매개변수 생성자 가 있을경우엔
		// this.(userId, userPw); 이런식으로 작성가능
		//      <= 같은 클래스의 다른 생성자 생성할때
		//      <= 이방법을 사용할때엔 반드시 첫째줄에 작성되어야함 ~
		//      ... 코드길이 감소, 재사용성은 증가하나 가독성이 떨어짐
		
		// User.(userId, userPw); 이런식은 불가능 
		//      <= User는 본인을 3인칭으로 부르는것을 싫어함
		
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;

		// *** this 참조 변수 ***
		// this <= 매개변수로 전달받은 값을 필드에 초기화(this 참조변수)
		
		// - 모든객체 내부에 숨겨져있다.
		// ?? 왜사용할까 ??
		// => 필드명과 매개변수명이 같을 경우 
		//    이를 구분하기 위해서 주로 사용	
	}
	// ** 자바 규칙 **
	// 자바는 기본적으로 필드명, 생성자면, 메소드명, 변수명의 중복을 허용하지 않음
	
	// *** 오버로딩 (Overloading) ***
	// - 클래스 내에 동일한 이름의 매서드(생성자도 포함)를 여러개 작성하는 기법
	// -> 하나의 이름으로 여러 기능을 수행할 수 있게 한다.
	
	// [ 오버로딩 조건 ] 
	// 1) 메서드 (생성자 포함)의 이름이 동일
	// 2) 매개변수의 개수, 타입, 순서 중 1개라도 달라야 함.
	
	//  public User() {}  <= 이렇게 작성시 기본 생성자가 이미 작성되어 있어 중복으로 인식
	
	
	public User ( String userId ) {} // <= 같은 이름에 매개변수의 개수가 같은 생성자가 없음
	                                 // -> 오버로딩 성립
	
	public User ( int userAge ) {} // <= 위의 생성자와 매개변수의 개수는 같지만
									//   타입이 다름 
									// -> 오버로딩 성립
	
	public User ( String userId, int userAge ) {} // 개수가 같은것이 있으나 매개변수의 타입이 다름
												  // -> 오버로딩 성립
	
	public User ( int userAge, String userId ) {} // 매개변수의 개수와 타입이 같으나
													// 순서가 다름
													// -> 오버로딩 성립
	// public User ( int userAge, String userId ) {}
	// 매개변수의 개수, 타입, 순서가 모두같아서 오버로딩 불가
	// -> 변수 명은 계속 같아도 상관X
	
	public User ( String userName, String userId, String userPw) {}
	
	// public User ( String userPw, String userName, String userId) {}
	
	// 순서는 다르나 타입 개수가 같음
	
	
	// 메서드
	// 캡슐화로 인한 간접 접근 기능(getter/setter)
	
	public String getUserId() { // userUd의 getter 
	  // 반환할 값의 자료형
	     return userId;	
	}
	public void setUserId(String userId) {  // userId의 setter
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
	// getter/setter 자동 완성
	// alt + shift + s => generate getters and setters
	
	// 
	
	
	

}
