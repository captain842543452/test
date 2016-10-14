package com.captain.newcrawl;

import java.io.Serializable;

public class Book implements Serializable,Comparable<Book>{
	private String name;
	private double score; 
	private int eva_num;
	private String author;
	private String publisher;
	private String date;
	private String price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public int getEva_num() {
		return eva_num;
	}

	public void setEva_num(int eva_num) {
		this.eva_num = eva_num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Book() {
		super();
	}

	public Book(String name, Double score, int eva_num, String author,
			String publisher, String date, String price) {
		super();
		this.name = name;
		this.score = score;
		this.eva_num = eva_num;
		this.author = author;
		this.publisher = publisher;
		this.date = date;
		this.price = price;
	}

	
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", score=" + score + ", eva_num="
				+ eva_num + ", author=" + author + ", publisher=" + publisher
				+ ", date=" + date + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Book o) {
		if(this.score>o.score){
			return -1;
		}else if(this.score<o.score){
			return 1;
		}else{
			if(this.eva_num>o.eva_num){
				return -1;
			}else if(this.eva_num<o.eva_num){
				return 1;
			}else{
				return this.name.compareTo(o.name);
			}
		}
	} 
	
}
