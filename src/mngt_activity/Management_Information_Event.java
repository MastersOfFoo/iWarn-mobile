package mngt_activity;

import java.util.List;

import location.OverlayMapa;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import aplication.start.main.Management_Menu;
import aplication.start.main.R;
import aplication.start.main.result_view;


public class Management_Information_Event extends MapActivity{
	private MapView mapa = null;
	public static String s="";
	public static String id="";
	public static String t="";
	public static String d="";
	public static double lo=0;
	public static double la=0;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.event_information);
        Bundle bu=getIntent().getExtras();
        if(bu!=null && s!=""){
     	   	  
        }
        else{
        	if(bu!=null){
     	  d=bu.getString("Description");     	  
     	  t=bu.getString("Type");
     	  // Colocar en mayuscula
     	  t=t.toUpperCase();
     	   s=bu.getString("State");
     	  lo=bu.getDouble("Longitude")* 1E6;
     	  la=bu.getDouble("Latitude")* 1E6;
     	   id=bu.getString("Id");
        	}
        }
     	 // description
     	  EditText et=(EditText) findViewById(R.id.editText1);
         et.setText(d);
     	
         //textView1 type
         TextView tv1=(TextView) findViewById(R.id.textView1);
         tv1.setText(t);
         
         // state
         TextView tv2=(TextView) findViewById(R.id.textView2);
         tv2.setText(s);
        
        
        
        // mapa
        
         mapa = (MapView)findViewById(R.id.map_small);
        
        mapa.setBuiltInZoomControls(true);
        
        // posiionar mapa
        MapController mapController=mapa.getController();
        GeoPoint p = new GeoPoint(
                (int) (la), 
                (int) (lo));
        mapController.animateTo(p);
        mapController.setZoom(17);  //12
         
   		List<Overlay> capas = mapa.getOverlays();
   		OverlayMapa om = new OverlayMapa(la  ,lo  );
   		capas.add(om);
   		mapa.postInvalidate();
        
        // back button
        Button b1=(Button) findViewById(R.id.button1);        
      	b1.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      		finish(); 
      		Intent intent1=new Intent();
			intent1.setClass(view.getContext(),Management_ShowEvents.class);    			       	
		    startActivity(intent1);	
      		}
      		
      	});
      	//photos button
        Button b2=(Button) findViewById(R.id.button2);        
      	b2.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      		 
      		Intent intent1=new Intent();
			intent1.setClass(view.getContext(),Management_Select_Image.class);    			       	
		    startActivity(intent1);	
		    Management_Select_Image.id=id;
      		}
      		
      	});
        
        
        
        TextView t1=(TextView) findViewById(R.id.textView2);        
      	t1.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			finish();
      			Intent intent=new Intent();      				      		
      			intent.setClass(view.getContext(),Management_Edit_State.class);
      			intent.putExtra("State",s);
      			intent.putExtra("Id",id);      			
      	      	startActivity(intent); 
      			
      		}      		
      	});
        
        
        
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void clear(){
		s="";
		id="";
		t="";
		d="";
		lo=0;
		la=0;
		
	}

}
