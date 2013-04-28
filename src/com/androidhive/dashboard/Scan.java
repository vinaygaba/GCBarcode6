package com.androidhive.dashboard;

import java.util.List;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidhive.dashboard.R;

public class Scan extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan);
        Button wpadmin = (Button) findViewById(R.id.WPAdmin);
        Button sms = (Button) findViewById(R.id.SMS);
        Button phone = (Button) findViewById(R.id.Phonecall);
        Button browser = (Button) findViewById(R.id.Openbrowser);
        Button history = (Button) findViewById(R.id.history);
        final DatabaseHandler db1= new DatabaseHandler(this);
        phone.setVisibility(View.GONE);
    	sms.setVisibility(View.GONE);
    	browser.setVisibility(View.GONE);
        
        final EditText scan   = (EditText)findViewById(R.id.scans);
        Bundle scanresult = getIntent().getExtras();
        if (scanresult != null) {
            String scan_result =scanresult.getString("scan_result");
            String result_format =scanresult.getString("result_format");
            scan.setText(scan_result);
            if(result_format.equals("phone"))
            {
            	phone.setVisibility(View.VISIBLE);
            	sms.setVisibility(View.GONE);
            	browser.setVisibility(View.GONE);
            }
            else if(result_format.equals("sms"))
            {
            	sms.setVisibility(View.VISIBLE);
            	  phone.setVisibility(View.GONE);
                  browser.setVisibility(View.GONE);
            }
            else if(result_format.equals("url"))
            {
            	browser.setVisibility(View.VISIBLE);
            	sms.setVisibility(View.GONE);
                phone.setVisibility(View.GONE);
            }
            else
            {
            	
            }
            
           sms.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View view) {
    				SmsManager sm = SmsManager.getDefault();
    				String scansms=scan.getText().toString();
    				String delinit=scansms.substring(6);
    				String[] parts = delinit.split(":");
    				String number=parts[0];
    				String message=parts[1];
    				// here is where the destination of the text should go
    				//String number = "6508570720";
    				sm.sendTextMessage(number, null, message, null, null);
    				Toast.makeText(Scan.this, "SMS sent", Toast.LENGTH_SHORT).show();
    			}
    		});
           
           
           browser.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
        
   				String scanurl=scan.getText().toString();
   				if (!scanurl.startsWith("http://") && !scanurl.startsWith("https://"))
   				{
   				   scanurl = "http://" + scanurl;
   				}
   				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanurl));
   				startActivity(browserIntent);
   			}
   		});
        
           phone.setOnClickListener(new View.OnClickListener() {
      			
      			public void onClick(View view) {
      				String scanphone=scan.getText().toString();
      				scanphone=scanphone.toLowerCase();
      				 try {
      			        Intent callIntent = new Intent(Intent.ACTION_CALL);
      			        callIntent.setData(Uri.parse(scanphone));
      			        startActivity(callIntent);
      			    } catch (ActivityNotFoundException e) {
      			        Log.e("helloandroid dialing example", "Call failed", e);
      			    }
      			}
      		});
       
           wpadmin.setOnClickListener(new View.OnClickListener() {
      			
      			public void onClick(View view) {
      				List<Contact> entries=db1.getAllContacts();
      		        if(entries.size()!=0)
      		     	{
      		        Contact link=db1.getContact(1);	
      				String linkstr=link.getUrl();
      				if (!linkstr.startsWith("http://") && !linkstr.startsWith("https://"))
       				{
      					linkstr = "http://" + linkstr;
       				}
      				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkstr));
       				startActivity(browserIntent);
      		     	}
      		        else
      		        {
      		        	Toast.makeText(Scan.this, "Go to settings and enter address", Toast.LENGTH_SHORT).show();
      		        }
      				
      			}
      		});
           history.setOnClickListener(new View.OnClickListener() {
   			
   			public void onClick(View view) {
   				Intent i = new Intent(getApplicationContext(), Businesscards.class);
   				startActivity(i);
   			}
   		});
        
        }
    
    
    
    }
}
