package aplication.start.main;


import java.io.IOException;
import java.util.ArrayList;

import objects.Event;
import objects.People;
import objects.Vehicle;



import com.google.gson.Gson;



import connections.Connection;
import location.MyLocationListener;
import mngt_activity.ManagementDescriptionType;
import mngt_activity.ManagementID_Person;
import mngt_activity.ManagementLicense_Plate;
import mngt_activity.Management_Select_Service;
import mngt_activity.Management_ShowEvents;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class result_view extends Activity{
	Connection a;

    



	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

        
         //String json = "{ \"recipes\": \n" + "  [ \n" + "    {\n" + "      \"name\":\"Recipe 1\",\n" + "      \"id\":\"8aecfd9b2fa26e83012fa298c2a50017\",\n" + "      \"recipe\":\"1 Lorem ipsum...\",\n" + "      \"image\":\"/malibu-server/recipe/getImage/8aecfd9b2fa26e83012fa298c2a50017\"\n" + "    }, \n" + "    { \n" + "      \"name\":\"Recipe 2\",\n" + "      \"id\":\"8aecfd9b2fa26e83012fa298c2a90018\",\n" + "      \"recipe\":\"2 Lorem ipsum...\",\n" + "      \"image\": \"/malibu-server/recipe/getImage/8aecfd9b2fa26e83012fa298c2a90018\"\n" + "    },\n" + "    {\n" + "      \"name\": \"Recipe 3\",\n" + "      \"id\":\"8aecfd9b2fa26e83012fa298c2ae0019\",\n" + "      \"recipe\":\"3 Lorem ipsum...\",\n" + "      \"image\":  \"/malibu-server/recipe/getImage/8aecfd9b2fa26e83012fa298c2ae0019\"\n" + "      } \n" + "  ]\n" + "}\n" + "";

            
           
           

        
                
        
        setContentView(R.layout.showresults);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy); 

        
        
        
        String id=ManagementID_Person.getIDs();
        String plate=ManagementLicense_Plate.getPlates();
        
        String description=ManagementDescriptionType.getDescription();                    	
    	
    	String type =ManagementDescriptionType.getType();
    	

    	
    	double latitude =MyLocationListener.getLatitude();
        double longitude =MyLocationListener.getLongitude();
    	
    	
    	
    	//String x="{\"event\": {\"description\": \""+description+"\", \"latitude\": "+latitude+", \"longitude\": "+longitude+", \"state\": \"registered\", \"type\": \""+type+"\"}}";

       Gson gs=new Gson();
       Event e=new Event(description,latitude,longitude,type);
       String x="{\"event\":"+gs.toJson(e)+"}";
    	
    	
    	
    	
    	a=new Connection();
    	
    	a.callWebServiceForSendData(x);
    	
    	
    	String res="Your event was  not sent ";
    	Event ob=null;;
		try{
		 ob = gs.fromJson(a.result,  Event.class);
		}catch(Exception E){
			
		
		}
    	
    	//show.setText(description+"\n"+latitude+"\n"+longitude+"\n"+type+"\n"+id+"\n"+plate);
    	
    	//EditText show=(EditText) findViewById(R.id.result_box);
    	//show.setText(a.result);
    	
    	//String isOK[]=a.result.split(":");
    	    	    	    	    	

    	//if(isOK[0].equals("{\"id\"")){
    	
    	if(ob!=null){
    		boolean swfail=false;	
    		
    		if(ManagementID_Person.ids.size()>0){
    		x="{\"people\":"+id +"}";
    		
    		
    		
    		
    		try{
    		a.callWebServiceForSendIdPerson(ob.id,x);
    		People pe[] = gs.fromJson(a.result,  People[].class);
	    		if(pe!=null && pe.length >0 ){
	    			res="Your event was  successfully sent ";
	    		}
    		}catch(Exception ex){
    			swfail=true;
    			
    		}
    		
    		
    		
    		
    	}
    	if(ManagementLicense_Plate.plates.size()>0 && swfail==false){
    				
    		
    			x="{\"vehicles\":"+plate+"}";	
    			
    			try{
    			a.callWebServiceForSendVehicles(ob.id,x);
        		
        		Vehicle ve[] = gs.fromJson(a.result,  Vehicle[].class);
    			
    			if(ve!=null && ve.length >0){    				
    			res="Your event was  successfully sent ";    			    			
    			
    			}}
    			catch(Exception ex){
    				swfail=true;
    			}
    		
    		
    	}
    			
    	if(swfail==false){
    		Button btnaux = (Button) findViewById(R.id.btn_send_alert);
			Management_Select_Service.eventId=ob.id;
			btnaux.setClickable(true);
			res="Your event was  successfully sent ";
    	}
    	else{
    		res="Your event was  not sent ";
    	}	
    		 
    		 
    	}
    	
    	
    	
    	TextView tshow=(TextView) findViewById(R.id.result_text);
    	tshow.setText(res);
    	//result_text
    	
    	
    	
    	
    	
		  Button btn2 = (Button) findViewById(R.id.btn_finish);
	      	btn2.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      				      			
	      			ManagementDescriptionType.clear();
	      			ManagementLicense_Plate.clear();
	      			MyLocationListener.clear();
	      				      			
	      	        ManagementID_Person.clear();
	      	        ManagementLicense_Plate.clear();
	      	        finish();
	      			
	      			 	      			
	      			}
	      		});
    	
	      	
	      	//btn_send_alert
	      	
	      	Button btn3 = (Button) findViewById(R.id.btn_send_alert);
	      	btn3.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      				      			
	      			ManagementDescriptionType.clear();
	      			ManagementLicense_Plate.clear();
	      			MyLocationListener.clear();
	      				      			
	      	        ManagementID_Person.clear();
	      	        ManagementLicense_Plate.clear();
	      	        finish();
	      	      Intent intent=new Intent();
				   intent.setClass(view.getContext(),Management_Select_Service.class);
				   startActivity(intent);
	      			 	      			
	      			}
	      		});

    	
    	
    }

}
