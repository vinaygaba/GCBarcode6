package com.androidhive.dashboard;

import java.util.List;

public class ScanDate{

	//private variables
	int _id;
	String _url;
	String _phone_number;
	List<ScanItem> _scan;
	
	// Empty constructor
	public ScanDate(){
		
	}
	// constructor
	public ScanDate(int id, String url, String _phone_number){
		this._id = id;
		this._url = url;
		this._phone_number = _phone_number;
	}
	
	// constructor
	public ScanDate(String url, String _phone_number){
		this._url = url;
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
	public String getUrl(){
		return this._url;
	}
	
	// setting name
	public void setUrl(String url){
		this._url = url;
	}
	
	// getting phone number
	public String getPhoneNumber(){
		return this._phone_number;
	}
	
	// setting phone number
	public void setPhoneNumber(String phone_number){
		this._phone_number = phone_number;
	}
	 public void setItems(List<ScanItem> scan) {
	        this._scan = scan;
	    }
	 
	    /**
	     * All get methods
	     * */
	    public List<ScanItem> getItems() {
	        return this._scan;
	    }
}
