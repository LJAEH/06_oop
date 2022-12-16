package com.kh.test.money.model.vo;

public class Money {
	
	public final static String UNIT = "원";  
	
	// <= 클래스 다이어그램에 static이 들어가는경우엔 및줄표시됨
	
	private int money;
	
	public Money() {
		money = 10000;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

}
