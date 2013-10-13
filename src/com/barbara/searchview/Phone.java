package com.barbara.searchview;


/** 
* @author  barbara_chou@163.com
* @create 2013-10-13 下午12:08:31 
* @illustrate
*/ 
public class Phone {
	private String name;
	private String num;
	private int sex;
//	private String city;
	
	public Phone(String name, String num, int sex){
		super();
		this.name = name;
		this.num = num;
		this.sex = sex;
//		this.city = city;	
	}
	public String getName(){
		return name;
	}
	public String getNum(){
		return num;
	}
	public int getSex(){
		return sex;
	}
//	public String getCity(){
//		return city;
//	}

	@Override
	public String toString(){
		return name;
	}

}
