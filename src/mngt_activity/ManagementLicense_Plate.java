package mngt_activity;

import java.util.ArrayList;
import java.util.Arrays;

import objects.Event;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import aplication.start.main.R;
import aplication.start.main.result_view;
import aplication.start.main.R.id;
import aplication.start.main.R.layout;

public class ManagementLicense_Plate extends Activity{
	
	private ListView mainListView ;  
	  private ArrayAdapter<String> listAdapter ;  

	 static  public ArrayList<String>plates =new ArrayList<String>();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.licenseplate);	
  
		
        
        if(plates.size()>0){
 			 mainListView = (ListView) findViewById( R.id.List_plates );  			 
 			  listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow, plates);
 			mainListView.setAdapter( listAdapter ); 
        }
        
        
        
		  			  
	//	  		    mainListView = (ListView) findViewById( R.id.listView1 );

		  		    // Create and populate a List of planet names.		  		    		  		    		  		    
		  		    
		  		    //planetList.addAll( Arrays.asList(planets) );
		  		    
		  		    // Create ArrayAdapter using the planet list.
		  		 //   listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, plates);
		  		    
		  		    // Add more planets. If you passed a String[] instead of a List<String> 
		  		    // into the ArrayAdapter constructor, you must not add more items. 
		  		    // Otherwise an exception will occur.
		  		/*    listAdapter.add( "Ceres" );
		  		    listAdapter.add( "Pluto" );
		  		    listAdapter.add( "Haumea" );
		  		    listAdapter.add( "Makemake" );
		  		    listAdapter.add( "Eris" );*/
		  		    
		  		    // Set the ArrayAdapter as the ListView's adapter.
		  		//    mainListView.setAdapter( listAdapter ); 
		  		    
		  		    
		  		    
		  		  Button ba = (Button) findViewById(R.id.btn_add);
		      	ba.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			TextView txt = (TextView) findViewById(R.id.license_plate_txt);
		      			if(txt!=null){
		      			
		      			String plate=txt.getText().toString();
		      			txt.setText("");
		      			plates.add(plate);
		      			 mainListView = (ListView) findViewById( R.id.List_plates );
		      			 
		      			  listAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.simplerow, plates);
		      			mainListView.setAdapter( listAdapter ); 
		      			}
		      		}
		      		
		      	});
		      	
		      	
		      	Button b1 = (Button) findViewById(R.id.bnt_next_LT);
		      	b1.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			
		      			
		      			 finish();
		      			Intent intent=new Intent();		      					      		
		      			//intent.setClass(view.getContext(),IWarn_androidActivity.class);
		      			intent.setClass(view.getContext(),Management_Confirm_Informacion.class);
		      	      	startActivity(intent);
		      			
		      			
		      			}
		      		});
		      	
		      	
		      	Button b2 = (Button) findViewById(R.id.bnt_back_LT);
		      	b2.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			
		      			
		      			 finish();
		      			Intent intent=new Intent();		      					      				      			
		      			intent.setClass(view.getContext(),ManagementID_Person.class);
		      	      	startActivity(intent);
		      			
		      			
		      			}
		      		});
		      	
		      	
		      	mainListView = (ListView) findViewById( R.id.List_plates );
		    	mainListView.setOnItemClickListener(new OnItemClickListener() {
		            @Override
		            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		            	
		            	//rb_id
		            	CheckBox ch = (CheckBox) findViewById( R.id.cb_plates );
		            	if(ch.isChecked()==true)
		            	plates.remove(position);
		           	 mainListView = (ListView) findViewById( R.id.List_plates );
	      			 
	      			  listAdapter = new ArrayAdapter<String>(v.getContext(),R.layout.simplerow, plates);
	      			mainListView.setAdapter( listAdapter ); 
		            	
		                //tv1.setText("Población de "+ lv1.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
		            }
		        });
		      	

		
		      	
		      	
		      		
		      	}

    public static String getPlates(){
    	
    	Gson gs=new Gson();
    	String x=gs.toJson(plates);    	
    	return x;
    }    

    public static void clear(){
    	plates.clear();
    }
		  			  
}


