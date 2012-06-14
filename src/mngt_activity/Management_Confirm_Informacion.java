package mngt_activity;

import location.MyLocationListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import aplication.start.main.R;
import aplication.start.main.result_view;

public class Management_Confirm_Informacion  extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_information_event);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy); 

        
        
        
       // String id=ManagementID_Person.getIDs();
       // String plate=ManagementLicense_Plate.getPlates();
        
        String description=ManagementDescriptionType.getDescription();                    	
    	
    	String type =ManagementDescriptionType.getType();
    	
    	
    	//String latitude =Double.toString(MyLocationListener.getLatitude());
       //String longitude =Double.toString(MyLocationListener.getLongitude());
    	
    	double latitude =MyLocationListener.getLatitude();
        double longitude =MyLocationListener.getLongitude();
    	
        TextView ty = (TextView) findViewById(R.id.confirm_type);
        ty.setText(type);
                              
        EditText de = (EditText) findViewById(R.id.confirm_description);
        de.setText(description);
        
        Button b1 = (Button) findViewById(R.id.btn_send_event);
        b1.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			finish();
      			Intent intent=new Intent();      				      		
      			intent.setClass(view.getContext(),result_view.class);
      	      	startActivity(intent);
      	      	
      			 	      			
      			}
      		});
        
        
        
        Button b2 = (Button) findViewById(R.id.btn_back_confirm);
        b2.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			finish();
      			Intent intent=new Intent();      				      		
      			intent.setClass(view.getContext(),ManagementLicense_Plate.class);
      	      	startActivity(intent);
      	      	
      			 	      			
      			}
      		});        

        
        }

 
    
}
