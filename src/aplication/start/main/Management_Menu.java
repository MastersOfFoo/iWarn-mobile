package aplication.start.main;

import location.MyLocationListener;
import mngt_activity.ManagementDescriptionType;
import mngt_activity.ManagementID_Person;
import mngt_activity.ManagementLicense_Plate;
import mngt_activity.Management_Select_Service;
import mngt_activity.Management_ShowEvents;
import objects.Event;
import objects.Service;

import com.google.gson.Gson;

import connections.Connection;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import aplication.start.main.R;

public class Management_Menu extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.menu);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //RelativeLayout ly = (RelativeLayout) findViewById(R.id.ly_main);
        //ly.setBackgroundColor(Color.DKGRAY);
	        // politicas para permitir conexion  a servidor		      	        

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

	    StrictMode.setThreadPolicy(policy); 
        
        
		Gson gs=new Gson();
			Connection a=new Connection();
			a.callWebServiceForGetAllServices();    					
	
	   Service obj[] = gs.fromJson(a.result,  Service[].class);
	   
	   Management_Select_Service.servicesList=obj;

        
                
        
		  Button btn = (Button) findViewById(R.id.btn_new_event);
	      	btn.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      			ManagementDescriptionType.clear();
	      			ManagementLicense_Plate.clear();
	      			MyLocationListener.clear();
	      			
	      			
	      	        ManagementID_Person.clear();
	      	        ManagementLicense_Plate.clear();
	      			Intent intent=new Intent();
	      				      		
	      			intent.setClass(view.getContext(),ManagementDescriptionType.class);
	      	      	startActivity(intent);
	      			 	      			
	      			}
	      		});
	      	
	      	
			  Button btn2 = (Button) findViewById(R.id.btn_view_events);
		      	btn2.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			
		      	        // politicas para permitir conexion  a servidor		      	        
		      	        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		      	        StrictMode.setThreadPolicy(policy); 
		      	        
		      			
	    				Gson gs=new Gson();
	    				Connection a=new Connection();
	    				a.callWebServiceForGetAllData();
	    				Event obj[] = gs.fromJson(a.result,  Event[].class);
	    				   
	    				Management_ShowEvents.setData(obj);
	    				Management_ShowEvents.updateDateOfAllData();
	    				Intent intent1=new Intent();
	    				intent1.setClass(view.getContext(),Management_ShowEvents.class);    			       	
	    			    startActivity(intent1);

		      			 	      			
		      			}
		      		});
		      	
		      	
		      	
		      	 Button btn3 = (Button) findViewById(R.id.btn_exit);
			      	btn3.setOnClickListener(new View.OnClickListener(){
			      		public void onClick(View view){
			      			
			      	       finish();

			      			 	      			
			      			}
			      		});
		      	
		      	
		      	
		      	
    }	

}
