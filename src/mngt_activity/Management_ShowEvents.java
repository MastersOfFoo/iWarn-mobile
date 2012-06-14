package mngt_activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import aplication.start.main.R;
import aplication.start.main.R.id;
import aplication.start.main.R.layout;

import objects.Event;

public class Management_ShowEvents extends Activity{
	static  ArrayList<HashMap<String,String>> list =new ArrayList<HashMap<String,String>>();
   static   Event datasource[];
   public static int pg=0;
   public int limit=5;
	private ListView mainListView ;  
	private ArrayAdapter<String> listAdapter ;
	
	
	
	

   
   
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.view_events);
       
       
		    
		    
		    
       	updateview();
 			
       	//showing
    	TextView t1 = (TextView) findViewById(R.id.showing_txt);
    	if(datasource.length<5){ 
    		int in=0;
    		if(datasource.length>0){in=1;}
    		t1.setText("Showing from "+(in)+" to "+(datasource.length)+" of "+(datasource.length) +" Events");	
    	}
    	else{
    		t1.setText("Showing from "+(pg+1)+" to "+(pg+limit)+" of "+(datasource.length) +" Events");
    	}
       	
       	
	      	Button b1 = (Button) findViewById(R.id.btn_next_event);
	      	b1.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      			if(pg+limit<datasource.length){
	      				pg=pg+limit;
	      				updateview();
	      			}
	      	    	TextView t1 = (TextView) findViewById(R.id.showing_txt);
	      	    	String to=""+(pg+limit);
	      	    	if((pg+limit)>datasource.length){
	      	    		to=""+(datasource.length);
	      	    	}
	      	    	
	      	    	t1.setText("Showing from "+(pg+1)+" to "+to+" of "+(datasource.length)+" Events" );     				      			 	      			
	      			}
	      		});
	      	
	      	Button b2 = (Button) findViewById(R.id.btn_back_event);
	      	b2.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      			if((pg-limit)>=0){
	      				pg=pg-limit;
	      				updateview();
	      			}
	      	    	TextView t1 = (TextView) findViewById(R.id.showing_txt);
	      	    	t1.setText("Showing from "+(pg+1)+" to "+(pg+limit)+" of "+(datasource.length)+" Events" );
	      			      				      			 	      			
	      			}
	      		});
	      	
	      	Button b3 = (Button) findViewById(R.id.btn_events_back_main);
	      	b3.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      			finish();
    				
	      		
	      			      				      			 	      			
	      			}
	      		});

	      	
	    	// el click de los list
	    	
	    	mainListView=(ListView) findViewById(R.id.list_show_events);
	    	mainListView.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            	
	            	Management_Information_Event.clear();
	            	Event e=datasource[position+pg];
	            	finish();	            	
	            	Intent intent=new Intent();	            	
	            	intent.setClass(parent.getContext(),Management_Information_Event.class);
	            	intent.putExtra("Description",e.getDescription());
	            	intent.putExtra("Type",e.getType());
	            	intent.putExtra("State",e.getState());
	            	intent.putExtra("Longitude",e.getLongitude());
	            	intent.putExtra("Latitude",e.getLatitude());
	            	intent.putExtra("Id",e.getId());	            	
	            	startActivity(intent);
	            	
	                //tv1.setText("Población de "+ lv1.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
	            }
	        });
	      	
	      	
	      	
   }
	
	
	private void poblateList() {
		HashMap<String,String> temp = new HashMap<String,String>();
		temp.put("pen","MONT Blanc");
		temp.put("price", "200.00$");
		temp.put("color", "Silver, Grey, Black");
		list.add(temp);
		HashMap<String,String> temp1 = new HashMap<String,String>();
		temp1.put("pen","Gucci");
		temp1.put("price", "300.00$");
		temp1.put("color", "Gold, Red");
		list.add(temp1);
		HashMap<String,String> temp2 = new HashMap<String,String>();
		temp2.put("pen","Parker");
		temp2.put("price", "400.00$");
		temp2.put("color", "Gold, Blue");
		list.add(temp2);
		HashMap<String,String> temp3 = new HashMap<String,String>();
		temp3.put("pen","Sailor");
		temp3.put("price", "500.00$");
		temp3.put("color", "Silver");
		list.add(temp3);
		HashMap<String,String> temp4 = new HashMap<String,String>();
		temp4.put("pen","Porsche Design");
		temp4.put("price", "600.00$");
		temp4.put("color", "Silver, Grey, Red");
		list.add(temp4);
		}
	
	public void poblate(){
		list.clear();
		for(int i=pg;i<datasource.length && (i-pg)<limit;i++){
		HashMap<String,String> temp = new HashMap<String,String>();
		Event e =datasource[i];		 
		temp.put("Type",e.getType().toUpperCase());		
		temp.put("Date",e.getCreated());
		temp.put("id",Integer.toString(i));
		list.add(temp);
		
		// 
		
		}
		
	}
	
	public static void setData(Event events[]){
		datasource=events;
	}

	public void updateview(){
		
		 
		 mainListView = (ListView) findViewById( R.id.list_show_events );
		 
		  //listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow, list);
		 
		poblate(); 
		SimpleAdapter adapter = new SimpleAdapter(this,	list,R.layout.custom_row_view,	new String[] {"Type","Date"},new int[] {R.id.text1,R.id.text2}
		
				);
		 
		 
		mainListView.setAdapter( adapter );
		
		
	}

   public static void updateDateOfAllData(){
	  
	   
		for(int i=0;i<datasource.length;i++){
			datasource[i].createDate();
		}
	   
   }
}
