package com.androidhive.dashboard;

public class ScanItem {
	//private variables
		int _id;
		String _url;
		String _phone_number;
		
		// Empty constructor
		public ScanItem(){
			
		}
		// constructor
		public ScanItem(int id, String url, String _phone_number){
			this._id = id;
			this._url = url;
			this._phone_number = _phone_number;
		}
		
		// constructor
		public ScanItem(String url, String _phone_number){
			this._url = url;
			this._phone_number = _phone_number;
		}
		// getting ID
		public int getID2(){
			return this._id;
		}
		
		// setting id
		public void setID2(int id){
			this._id = id;
		}
		
		// getting name
		public String getUrl2(){
			return this._url;
		}
		
		// setting name
		public void setUrl2(String url){
			this._url = url;
		}
		
		// getting phone number
		public String getPhoneNumber2(){
			return this._phone_number;
		}
		
		// setting phone number
		public void setPhoneNumber2(String phone_number){
			this._phone_number = phone_number;
		}
}
