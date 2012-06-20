package mngt_activity;

import java.util.ArrayList;
import java.util.Arrays;

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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import aplication.start.main.R;
import aplication.start.main.R.id;
import aplication.start.main.R.layout;

public class ManagementID_Person extends Activity{
	
	private ListView mainListView ;  
	private ArrayAdapter<String> listAdapter ;  

	   static public ArrayList<String>ids =new ArrayList<String>();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idpeople);
        
        if(ids.size()>0){
 			 mainListView = (ListView) findViewById( R.id.List_id );  			 
 			  listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow, ids);
 			mainListView.setAdapter( listAdapter ); 
        }
  
		  			  
		  			  
	//	  		    mainListView = (ListView) findViewById( R.id.List_id );

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
		  		    
		  		    
		  		    
				  Button btn1 = (Button) findViewById(R.id.btn_add_IP);
		      	btn1.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			TextView txt = (TextView) findViewById(R.id.id_person_txt);
		      			if(txt!=null){
		      			
		      			String plate=txt.getText().toString();
		      			txt.setText("");
		      			ids.add(plate);
		      			 mainListView = (ListView) findViewById( R.id.List_id );
		      			 
		      			  listAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.simplerow, ids);
		      			mainListView.setAdapter( listAdapter ); 
		      			}
		      		}
		      		
		      	});
				  
		      	
		      	Button b2 = (Button) findViewById(R.id.btn_next_IP);
		      	b2.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			 finish();
		      			Intent intent=new Intent();		      					      	
		      			intent.setClass(view.getContext(),ManagementLicense_Plate.class);
		      	      	startActivity(intent);

		      			
		      			}
		      		});

		      	Button b3 = (Button) findViewById(R.id.btn_back_IP);
		      	b3.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			 finish();
		      			Intent intent=new Intent();		      					      		
		      			intent.setClass(view.getContext(),ManagementsAndroidMapas.class);
		      	      	startActivity(intent);
		      		
		      			
		      			}
		      		});		      	
		      	
		      	mainListView = (ListView) findViewById( R.id.List_id );
		    	mainListView.setOnItemClickListener(new OnItemClickListener() {
		            @Override
		            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		            	
		            	//rb_id
		            	CheckBox ch = (CheckBox) findViewById( R.id.rb_id );
		            	if(ch.isChecked()==true)
		            	ids.remove(position);
		      			 mainListView = (ListView) findViewById( R.id.List_id );
		      			 
		      			  listAdapter = new ArrayAdapter<String>(v.getContext(),R.layout.simplerow, ids);
		      			mainListView.setAdapter( listAdapter ); 
		            	
		                //tv1.setText("Poblaci�n de "+ lv1.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
		            }
		        });
		      	
		  		    
		  			  
		  			  
   }
    
    public static String getIDs(){
    	
    	Gson gs=new Gson();
    	String x=gs.toJson(ids);
    	return x;
    } 
    
    public static void clear(){
    	ids=new ArrayList<String>();
    	
    }

}
