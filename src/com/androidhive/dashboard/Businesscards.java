package com.androidhive.dashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import androidhive.dashboard.R;

public class Businesscards extends ListActivity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business);
        final String KEY_URL = "url";
         final String KEY_PH_NO = "phone_number";
        DatabaseHandler2 db = new DatabaseHandler2(this);
         ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
         List<Contact2> contacts= db.getAllContacts();
	         for(int i = 1; i < contacts.size()+1; i++){
	        	 Contact2 person1= db.getContact(i);
	        	 String url=person1.getUrl();
	        	 String phone = person1.getPhoneNumber();
	        	 
	        	 HashMap<String,String> map = new HashMap<String,String>();
	         	//map.put(KEY_PH_NO,phone);
	         	map.put(KEY_URL, url);
	         	map.put(KEY_PH_NO,phone);
	         	contactList.add(map);
}
	         ListAdapter adapter = new SimpleAdapter(this, contactList,
 	                 R.layout.list_item,
 	                 new String[] {KEY_PH_NO,KEY_URL}, new int[] {
 	                         R.id.phone,R.id.url});
 	  
 	         setListAdapter(adapter);
}
	
}
