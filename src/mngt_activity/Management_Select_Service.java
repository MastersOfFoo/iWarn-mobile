package mngt_activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import connections.Connection;

import objects.Event;
import objects.Service;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import aplication.start.main.R;

public class Management_Select_Service extends Activity{
	static  ArrayList<HashMap<String,String>> list =new ArrayList<HashMap<String,String>>();
	public static Service servicesList[];
	private ListView mainListView;
	public static String eventId;
	
    @Override    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.select_service);
        
        
        mainListView=(ListView) findViewById(R.id.list_services);
    	mainListView.setOnItemClickListener(new OnItemClickListener() {    		
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	//txt_message_alert
            	Management_Information_Event.clear();
            	Service e=servicesList[position];
            	//finish();	            	
            	//Intent intent=new Intent();	            	
            	//intent.setClass(parent.getContext(),Management_Information_Event.class);
            	//intent.putExtra("id",e.id);
            	//intent.putExtra("idEvent",eventId);
            	//intent.putExtra("name",e.name);
            	
            	
            	
            	EditText et=(EditText) findViewById(R.id.txt_message_alert);
            	
            	
            	Connection c=new Connection();
            	
            	
            	
            	String mensaje=et.getText().toString();
				   String data= "{\"alert\": {\"service_id\":"+servicesList[position].id+", \"event_id\":"+ eventId+", \"message\": \""+mensaje+"\" }}";
				   String result="Alert not sent";
            	try{
				c.callWebServiceForSendService(eventId,data);
				Gson gs=new Gson();
            	Service se = gs.fromJson(c.result,  Service.class);
            	 result="Alert not sent";
            	if(se!=null && se.id!=null){
            		result="Alert sent Successfully";
		              
            	}
            	}catch(Exception E){
            		
            	}
            	
            	Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
            	
            	finish();
            	            
            	
            }
        });
    	
    	
    	//btn_back_to_main_alert
        Button bt=(Button) findViewById(R.id.btn_back_to_main_alert);
        bt.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			
      			finish();
      			
      			
      		}});    	
        
    	poblate();
        updateview();
                
        }
    
    
	public void poblate(){
		list.clear();
		for(int i=0;i<servicesList.length;i++){
		HashMap<String,String> temp = new HashMap<String,String>();
		Service e =servicesList[i];		 				
		temp.put("name",e.name);
		
		list.add(temp);
		
		// 
		
		}
		
	}
	
	
	public void updateview(){
		
		 
		 mainListView = (ListView) findViewById( R.id.list_services );
		 
		  //listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow, list);
		 
		poblate(); 
		SimpleAdapter adapter = new SimpleAdapter(this,	list,R.layout.custom_row_view,	new String[] {"name"},new int[] {R.id.text1}
		
				);
		 
		 
		mainListView.setAdapter( adapter );
		
		
	}

}
