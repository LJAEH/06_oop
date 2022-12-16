package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {

	public void practice() {
		
		Book b1 = new Book();
		
		System.out.println(b1.toString());
		/*
		System.out.println(b1.getTitle());
		System.out.println(b1.getPrice());
		System.out.println(b1.getDiscountRate());
		System.out.println(b1.getAuthor());
		*/
		
		Book b2 = new Book("코딩죽이기", 30, 0.30, "코딩수재");
		
	
		System.out.println(b2.toString());
		
		System.out.println("=========================");
		
		/*System.out.println(b2.getTitle());
		System.out.println(b2.getPrice());
		System.out.println(b2.getDiscountRate());
		System.out.println(b2.getAuthor());
		
		*/
		
		b1.setTitle("코딩살리기");
		b1.setPrice(50);
		b1.setDiscountRate(0.20);
		b1.setAuthor("안뇽");

	    System.out.println("책 정보 수정");
	    

		System.out.println(b1.toString());
	    
		
	    System.out.println("=========================");

		System.out.println("도서명 = " + b1.getTitle());
		System.out.println("할인된 가격 = "
				+ (b1.getPrice()-(b1.getPrice()*b1.getDiscountRate())));

		System.out.println("도서명 = " + b2.getTitle());
		System.out.println("할인된 가격 = "
				+ (b2.getPrice()-(b2.getPrice()*b2.getDiscountRate())));
		
		
		
	}
	
	
}
