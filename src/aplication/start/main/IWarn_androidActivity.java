package aplication.start.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

import objects.Event;




import com.google.android.maps.MapView;
import com.google.gson.Gson;

import connections.Connection;
import location.MyLocationListener;
import lu.thinds.android.RestService;
import mngt_activity.ManagementDescriptionType;
import mngt_activity.Management_ShowEvents;
import mngt_activity.ManagementsAndroidMapas;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class IWarn_androidActivity extends Activity {
    /** Called when the activity is first created. */
	RestService restServiceG, restServiceP;
	TextView t_query1 = null, t_query2 = null;
	
	
	
	
	

	
	
	
	
	
    @Override    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        // politicas para permitir conexion  a servidor
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy); 
        
        t_query1 = (TextView) findViewById(R.id.editText2); //Setup Views and Button for response
        
        //Connection a=new Connection();
        
        
        //restServiceG = new RestService(mHandlerGet, this, "http://10.0.2.2:3000/bars/"); //Create new rest service for get
        
        //  restServiceG = new RestService(mHandlerGet, this, "http://iwarn-staging.herokuapp.com/events/1.json"); //Create new rest service for get
          // a=new Connection();
           
         //  a.callWebService("");
         //  t_query1.setText(a.result);
		//Event d=new Event("Esta es la descrpicion de",10.3,50.8,"registered","simple");
        
        
        // intetn con loas otras vistas
       	//Intent intent=new Intent();
       	
       	// mandar la referencia del mapa para insertar marca
       	//MyLocationListener.setMap((MapView)findViewById(R.id.mapa));
   
        //intent.setClass(this,managementLicense_Plate.class);
       	//intent.setClass(this,ManagementsAndroidMapas.class);
       	//intent.setClass(this,ManagementDescriptionType.class);
       	//intent.setClass(this,ManagementID_Person.class);
        //intent.setClass(this,Management_ShowEvent.class);
       	
      	//startActivity(intent);
        
        
        
  
        
        
        	
        Button b_query2 = (Button) findViewById(R.id.btn_ob);
    	b_query2.setOnClickListener(new View.OnClickListener(){
    		public void onClick(View view){
    			try {
    				
    				//Gson gs=new Gson();
    				  
    //				  String[] placas = {"abc", "def", "ghi"};
    //				  //WebService sv=new WebService("");
    				  //t_query2 = (TextView) findViewById(R.id.editText1);
    				  //String g=t_query2.getText().toString();
    				  
    				  
    				  //ListView list = (ListView) findViewById(R.id.editText1);
    				  //list.setListAdapter(new ArrayAdapter<String>(this, R.layout.listView1, placas));
    				  
    				  
    		//		  ListView lV = (ListView) findViewById(R.id.listView1);
    				  String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
    				  	"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
    				  	"Linux", "OS/2" };

    				  // First paramenter - Context
    				  // Second parameter - Layout for the row
    				  // Third parameter - ID of the View to which the data is written
    				  // Forth - the Array of data
    		//		  lV.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_fruit,p));

    				  // Assign adapter to ListView
    	//			  listView.setAdapter(adapter);
    				  
    				  
    				  
    				  
    			//String x=" {\"event\": {\"description\": \"Nueva descripcion\", \"latitude\": 100.1, \"longitude\": 100.2, \"state\": \"registered\", \"type\": \"simple\"}}";
    			
/*    			String description="Esta es la decripcion del accidente";
    			double latitude=70.1;
    			double longitude=11.0;
    			String state="registered";
    			String	type="simple";*/
    			
    			//t_query2.setText(description);
    			//Event d=new Event("Esta es la descrpicion de",10.3,50.8,"simple");
    			  //	  String z=gs.toJson(d);    			
    			
    				//  System.out.println(x);
    			//  	t_query2.setText(z);
    				      				  
    		           //a.callWebServiceForGetData(g);
    				  //attended
    				  String k="{\"event\": {\"state\": \"attended\"}}";
    				  
    				  Connection a=new Connection();
    				  //a.callWebService("");
    				   a.callWebServiceForUpadateState("4",k);
    			  	
    				  //a.callWebServiceForSendData(x);    				  
    				  
    		          t_query1.setText(a.result);
    				
    				   
    				   
    				   
    				   
    				/*   Event obj[] = gs.fromJson(a.result,  Event[].class);
    				   
    				   Management_ShowEvents.setData(obj);
    				   Management_ShowEvents.updateDateOfAllData();
    				 	Intent intent=new Intent();
    				 	intent.setClass(view.getContext(),Management_ShowEvents.class);    			       	
    			      	startActivity(intent);
				*/
    				   
    			/*	   Event tev=obj[0];
    				   tev.getLatitude();
    				   tev.getType();
    				   tev.getCreated();*/
    				   //String fec[]=tev.getCreated().split(" ");
    				   // quitando  el 0000
    				   
    				   //fec=fec.substring(1, fec.length()-6);
    				   
    				   //tev.createDate();
    				   
    				   //String da=getCalendar().
    				   
    				   
    				   
    				  // String texto= tev.getDescription()+","+tev.getLatitude()+","+tev.getLongitude()+","+tev.getType()+","+tev.getCalendar().getTime().toString()+","+tev.getCreated();
    				   
    				   
    				   
    				   
    				   
    				   
    				   
    				   
    				   //t_query2.setText(a.result);
    				  // t_query2.setText(texto);
    				   //t_query2.setText("ya");
    				   
    				   
    				   
    				   
    				   
				} catch (Exception e) {
					
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					e.printStackTrace(pw);
					String s=sw.toString();
					t_query1.setText("Error al Obtener "+e.toString()+" - "+s);
				}
    		}
    	});
    }
    
    
    private final Handler mHandlerGet = new Handler(){
    	@Override
    	public void handleMessage(Message msg){
    			t_query1.setText((String) msg.obj);
    		}		
    };
    
    private final Handler mHandlerPost = new Handler(){
    	@Override
    	public void handleMessage(Message msg){
    			t_query2.setText((String) msg.obj);
    		}		
    };
}