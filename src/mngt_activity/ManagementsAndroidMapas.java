package mngt_activity;



import location.MyLocationListener;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import aplication.start.main.R;
import aplication.start.main.R.id;
import aplication.start.main.R.layout;

public class ManagementsAndroidMapas extends MapActivity {

	private MapView mapa = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latitude_longitude);
    
     //codigo que funciona para solo mostrar mapa   
         
        //Obtenemos una referencia al control MapView
        mapa = (MapView)findViewById(R.id.mapa);
        
        //Mostramos los controles de zoom sobre el mapa
        mapa.setBuiltInZoomControls(true);
        
     	MyLocationListener.setMap((MapView)findViewById(R.id.mapa));
        
        
        MapView mapView = (MapView) findViewById(R.id.mapa);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, 
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
    	 

    		   
    		   
    		   
                new MyLocationListener(mapView.getController(), locationManager, getBaseContext()));
 
        mapView.setBuiltInZoomControls(true);  
        
		  Button btn = (Button) findViewById(R.id.bnt_next_LL);
	      	btn.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      			finish();
	      			Intent intent=new Intent();	      				      	
	      			intent.setClass(view.getContext(),ManagementID_Person.class);
	      	      	startActivity(intent);
	      	      	
	      			 	      			
	      			}
	      		});
	      	
			  Button b2 = (Button) findViewById(R.id.bnt_back_LL);
		      	b2.setOnClickListener(new View.OnClickListener(){
		      		public void onClick(View view){
		      			finish();
		      			Intent intent=new Intent();				      		
		      			intent.setClass(view.getContext(),ManagementDescriptionType.class);
		      	      	startActivity(intent);
		      			
		      	      	
		      			 	      			
		      			}
		      		});	      	
        
        
    }
    
    @Override
    protected boolean isRouteDisplayed() {
    	return false;
    }
    
    
    
    
}



