package com.androidhive.dashboard;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidhive.dashboard.R;

public class Settings extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feed_layout);
        final DatabaseHandler2 db2= new DatabaseHandler2(this);
        Button save = (Button) findViewById(R.id.save);
       // Button scanhistory = (Button) findViewById(R.id.scanhistory);
        
        final EditText urls   = (EditText)findViewById(R.id.url);
        final DatabaseHandler db1= new DatabaseHandler(this);
        //final DatabaseHandler2 db2= new DatabaseHandler2(this);
        final Builder alertDialog = new AlertDialog.Builder(this);
        // Dashboard Friends button
        Button clear = (Button) findViewById(R.id.clear);
        //Button history = (Button) findViewById(R.id.history);
        List<Contact> entries=db1.getAllContacts();
        
        if(entries.size()!=0)
     	{
        Contact link=db1.getContact(1);	
		String linkstr=link.getUrl();
		urls.setText(linkstr);
     	}
        save.setOnClickListener(new View.OnClickListener() {
		
		
			public void onClick(View view) {
				// Launching News Feed Screen
				final String KEY_NAME = "name";
	 	         final String KEY_PH_NO = "phone_number";
	 	        final String KEY_ID= "id";
	 	         String url= urls.getText().toString();
	 	         if(url.length()==0)
	 	         {
	 	        	Toast.makeText(Settings.this, "Please enter a url", Toast.LENGTH_SHORT).show();
	 	         }
	 	         
	 	         else
	 	         {
	 	        	List<Contact> entries2=db1.getAllContacts();
	 	        	if(entries2.size()==0)
	 	        	{
	 	        		db1.addContact(new Contact("http://www.google.com", ""));   
	 	        	}
	 	         db1.updateContact(new Contact(url, ""));
	 	         
	 	        Toast.makeText(Settings.this, "URL Saved", Toast.LENGTH_SHORT).show();
	 	         }
			}
		});
        clear.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// Launching News Feed Screen
				final String KEY_NAME = "name";
	 	         final String KEY_PH_NO = "phone_number";
	 	        final String KEY_ID= "id";
	 	       final String TABLE_CONTACTS = "contacts";
	 	      final String url= urls.getText().toString();
				 
			    alertDialog.setTitle("Delete Scan History");
			    alertDialog.setMessage("Are you sure you want to delete the scan history?");
			    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // continue with delete
			        	List<Contact2> entries3=db2.getAllContacts();
		 	        	if(entries3.size()==0)
		 	        	{
		 	        		Toast.makeText(Settings.this, "No Scan History", Toast.LENGTH_SHORT).show();   
		 	        	}
		 	        	db2.deleteAll();
			        	//urls.setText("");
			        	
			        }
			     });
			    alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // do nothing
			        }
			     });
			     alertDialog.show();
			}
		});
/*scanhistory.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				Intent i = new Intent(getApplicationContext(), Businesscards.class);
   				startActivity(i);
   			}
*/        
    
    }
    
    
}
