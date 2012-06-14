package aplication.start.main;


import java.io.IOException;
import java.util.ArrayList;

import objects.Event;



import com.google.gson.Gson;



import connections.Connection;
import location.MyLocationListener;
import mngt_activity.ManagementDescriptionType;
import mngt_activity.ManagementID_Person;
import mngt_activity.ManagementLicense_Plate;
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
    	//show.setText(description+"\n"+latitude+"\n"+longitude+"\n"+type+"\n"+id+"\n"+plate);
    	
    	//EditText show=(EditText) findViewById(R.id.result_box);
    	//show.setText(a.result);
    	
    	String isOK[]=a.result.split(":");
    	String res="Your event was  not sent ";
    	if(isOK[0].equals("{\"id\"")){
    		 res="Your event was  successfully sent ";
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
    	
    	
    	
    }

}
