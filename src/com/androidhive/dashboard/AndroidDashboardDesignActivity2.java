package com.androidhive.dashboard;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidhive.dashboard.R;

public class AndroidDashboardDesignActivity2 extends Activity {
    
    

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        
        /**
         * Creating all buttons instances
         * */
        // Dashboard News feed button
        Button btn_agenda = (Button) findViewById(R.id.btn_agenda);
        
        // Dashboard Friends button
        Button btn_friends = (Button) findViewById(R.id.btn_friends);
        
        Button btn_history = (Button) findViewById(R.id.btn_history);
        TextView foot=(TextView) findViewById(R.id.foot);
        
        
        
        /**
         * Handling all button click events
         * */
        
        // Listening to News Feed button click
        btn_agenda.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Settings.class);
				startActivity(i);
			}
		});
        
       // Listening Friends button click
        btn_friends.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
			}
		});
       btn_history.setOnClickListener(new View.OnClickListener() {
			
     			public void onClick(View view) {
     				// Launching News Feed Screen
     				Intent i = new Intent(getApplicationContext(), Businesscards.class);
       				startActivity(i);
     			}
     		});
       foot.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gcwebsolutions.com"));
   				startActivity(browserIntent);

            }
        });
        
        // Listening Messages button click
       
    }
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
 	   if (requestCode == 0) {
 	      if (resultCode == RESULT_OK) {
 	         
				String contents = intent.getStringExtra("SCAN_RESULT");
				
	
 	         @SuppressWarnings("unused")
				String formats = intent.getStringExtra("SCAN_RESULT_FORMAT");
 	         	String resultformat=null;
 	         	
 	         	if(contents.startsWith("http://")||contents.startsWith("https://")||(contents.startsWith("www.")))
 	         	{
 	         		resultformat = "url";
 	         	}
 	         		else if(contents.startsWith("TEL")||(contents.startsWith("tel")))
 	         				{
 	         			resultformat = "phone";
 	         				}
 	         		else if(contents.startsWith("SMSTO")||(contents.startsWith("smsto")))
 	         				{
 	         			resultformat = "sms";
 	         				}
 	         		else
 	         		{
 	         			resultformat = "plain";
 	         		}
 	         			
 	        //String form=formats.format(formats);
 	     
 	         
 	         //EditText text=(EditText) findViewById(R.id.editText1);
 	         //text.setText(contents);
 	         final String KEY_NAME = "name";
 	         final String KEY_PH_NO = "phone_number";
 	         //DatabaseHandler db = new DatabaseHandler(this);
 	         DatabaseHandler2 db2= new DatabaseHandler2(this);
 	        Calendar currentDate = Calendar.getInstance();
 	        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
 	        String date = formatter.format(currentDate.getTime());
 	         //db.addContact(new Contact(contents, ""));
 	         db2.addContact(new Contact2(contents, date));
 	        Intent i = new Intent(getApplicationContext(), Scan.class);
 	       i.putExtra("scan_result",contents);
 	      i.putExtra("result_format",resultformat);
			startActivity(i);
 	        //Toast.makeText(AndroidDashboardDesignActivity2.this, formats, Toast.LENGTH_SHORT).show();
 	         /*List<Contact> contacts=db.getAllContacts();
 	         for(int i = 1; i < contacts.size(); i++){
 	        	 Contact person1=db.getContact(i);
 	        	 String name=person1.getName();
 	        	 String phone = person1.getPhoneNumber();
 	        	 
 	        	 HashMap<String,String> map = new HashMap<String,String>();
 	         	//map.put(KEY_PH_NO,phone);
 	         	map.put(KEY_NAME, name);
 	         	map.put(KEY_PH_NO,phone);
 	         	contactList.add(map);
 	         }
 	         ListAdapter adapter = new SimpleAdapter(this, contactList,
 	                 R.layout.list_item,
 	                 new String[] {KEY_PH_NO,KEY_NAME}, new int[] {
 	                         R.id.phone,R.id.name});
 	  
 	         setListAdapter(adapter);*/
 	         
 	         // Handle successful scan
 	      } else if (resultCode == RESULT_CANCELED) {
 	         // Handle cancel
 	      }
 	   }
 	}
 // Initiating Menu XML file (menu.xml)
    
 
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    
   /* public boolean onOptionsItemSelected(MenuItem item)
    {
 
        switch (item.getItemId())
        {
        
 
        case R.id.menu_share:
            //Toast.makeText(AndroidDashboardDesignActivity.this, "Share is Selected", Toast.LENGTH_SHORT).show();
            //return true;
        	Intent intent = new Intent("com.google.zxing.client.android.SCAN");
			intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(intent, 0);
			return true;
			
        case R.id.menu_delete:
            //Toast.makeText(AndroidDashboardDesignActivity.this, "Delete is Selected", Toast.LENGTH_SHORT).show();
            //return true;
        	Intent i = new Intent(getApplicationContext(), Businesscards.class);
			startActivity(i);
			return true;
        
 
        default:
            return super.onOptionsItemSelected(item);
        }
        
    }*/    
}