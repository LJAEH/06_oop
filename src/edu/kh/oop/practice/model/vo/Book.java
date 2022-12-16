package edu.kh.oop.practice.model.vo;

public class Book {
	
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	public Book() {
		
		String title;
		int price;
		double discountRate;
		String author;
		
	}
	
	public Book(String title, int price, 
			double discountRate, String author ) {
		
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
			
	}
	
		
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//Override 오버라이딩 ---
	public String toString() {
		return title + "/" + price + "/" + discountRate + "/" + author;
	}

	
	// 매서드 사용법 == [지역변수].[메서드]()
	// 			 ex  System.out.println(b1.toString());
	//               bp.practice();
	

}
