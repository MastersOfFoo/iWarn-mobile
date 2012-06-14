package mngt_activity;

import objects.Event;

import com.google.gson.Gson;
import connections.Connection;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import aplication.start.main.R;

public class Management_Edit_State extends Activity{
	public String id="";
	
	
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bu=getIntent().getExtras();
        setContentView(R.layout.edit_state);
    
        if(bu.getString("Cancel") !=null){
     	   	  
        }
        else{
     	   String st=bu.getString("State");     	  
     	   id=bu.getString("Id");     	  
     	 //spinner_state
     	  
     	  
      	int pos=0;
      	if(st.equals("attended")){
      		pos=1;
      	}
      	if(st.equals("closed")){
      		pos=2;
      	}
      	
      Spinner sp=(Spinner) findViewById(R.id.spinner_state);
			sp.setSelection(pos,true);
			
			Button b1=(Button) findViewById(R.id.btn_update_state);        
	      	b1.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	              StrictMode.setThreadPolicy(policy); 
	              
	              

	            Connection  a=new Connection();
	            Spinner s=(Spinner)findViewById(R.id.spinner_state);
	            String newState=s.getSelectedItem().toString();
	            
	            
	            String k="{\"event\": {\"state\": \""+newState+"\"}}";
	            
	          	a.callWebServiceForUpadateState(id,k);
	          	
	          	
	          	
	        	Gson gs=new Gson();
				
				a.callWebServiceForGetData(id);
				Event obj = gs.fromJson(a.result,  Event.class);
				if(obj.getState().equals(newState)){
				      Toast toast1 =
				              Toast.makeText(getApplicationContext(),
				                      "State changed Succesfuly", Toast.LENGTH_SHORT);
				   
				          toast1.show();				          				          			          				      						      			
				      			 					      	        
					      			
				    		// restaurar valores en servidor		
				    				
				    				a.callWebServiceForGetAllData();
				    				Event obje[] = gs.fromJson(a.result,  Event[].class);
				    				   
				    				Management_ShowEvents.setData(obje);
				    				Management_ShowEvents.updateDateOfAllData();
				    				Management_ShowEvents.pg=0;

				      			
							          finish();
							          Management_Information_Event.clear();
						            	Intent intent=new Intent();	            	
						            	intent.setClass(view.getContext(),Management_Information_Event.class);
						            	intent.putExtra("Description",obj.getDescription());
						            	intent.putExtra("Type",obj.getType());
						            	intent.putExtra("State",obj.getState());
						            	intent.putExtra("Longitude",obj.getLongitude());
						            	intent.putExtra("Latitude",obj.getLatitude());
						            	intent.putExtra("Id",obj.getId());	            	
						            	startActivity(intent);

				      		
										          
				          
				          
				}

	      			
	      			
	      			
	      			
	      		finish(); 
	      			
	      		}
	      		
	      	});
	      	
	      	

			Button b2=(Button) findViewById(R.id.btn_back_to_event);        
	      	b2.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){	
	      		
	      		finish();
	      		Intent intent=new Intent();	            	
            	intent.setClass(view.getContext(),Management_Information_Event.class);
            	startActivity(intent);

	      	}
	      		
	      	});		      	
	      	
	      	

     	  }
	}
	
	
	
	//btn_update_state

}
