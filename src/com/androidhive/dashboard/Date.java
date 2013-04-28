package com.androidhive.dashboard;

public class Date {
	
	//private variables
	int _id;
	String _date;
	String _phone_number;
	
	// Empty constructor
	public Date(){
		
	}
	// constructor
	public Date(int id, String date, String _phone_number){
		this._id = id;
		this._date = date;
		this._phone_number = _phone_number;
	}
	
	// constructor
	public Date(String date, String _phone_number){
		this._date = date;
		this._phone_number = _phone_number;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getDate(){
		return this._date;
	}
	
	// setting name
	public void setUrl(String date){
		this._date = date;
	}
	
	// getting phone number
	public String getPhoneNumber(){
		return this._phone_number;
	}
	
	// setting phone number
	public void setPhoneNumber(String phone_number){
		this._phone_number = phone_number;
	}
	
}
