package location;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;
import aplication.start.main.R;
import aplication.start.main.R.id;

   
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;



import com.google.android.maps.Overlay;
  
   public class MyLocationListener implements LocationListener {
       private Context context;
       private LocationManager locationManager;
       private MapController mapController;
       private static double  latitudeP;
       private static double longitudeP;
       private static MapView mp;
    
       public MyLocationListener(MapController mapController, LocationManager locationManager, Context context)
       {
           this.mapController = mapController;
           this.locationManager = locationManager;
           this.context = context;
       }
       
       @Override
       public void onLocationChanged(Location loc) {
           Toast.makeText(context, "onLocationChanged", Toast.LENGTH_SHORT).show();
           
           if (loc!=null) {
               Toast.makeText(context, 
                       "Location changed : Lat: " + loc.getLatitude() + " Lng: " + loc.getLongitude(), Toast.LENGTH_SHORT).show();
              
                   GeoPoint p = new GeoPoint(
                           (int) (loc.getLatitude() * 1E6), 
                           (int) (loc.getLongitude() * 1E6));
    
                   mapController.animateTo(p);
                   mapController.setZoom(18);  //12
                    latitudeP=loc.getLatitude();
                   longitudeP=loc.getLongitude() ;
                   MapView Mapa = mp;

                   
                   
                   //Mostramos los controles de zoom sobre el mapa
                   Mapa.setBuiltInZoomControls(true);
                   
           		//Añadimos la capa de marcas
           		List<Overlay> capas = Mapa.getOverlays();
           		OverlayMapa om = new OverlayMapa(latitudeP * 1E6,longitudeP * 1E6);
           		capas.add(om);
           		Mapa.postInvalidate();

           }
           else
           {
               Toast.makeText(context, "location changed to null value", Toast.LENGTH_SHORT).show();
           }
           
           // por el emulador??
           locationManager.removeUpdates(this);
           locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, 
                   new MyLocationListener(mapController, locationManager, context));
       }
    
       @Override
       public void onProviderDisabled(String arg0) {
           Toast.makeText(context, "Provider Disabled", 
                   Toast.LENGTH_SHORT).show();
       }
    
       @Override
       public void onProviderEnabled(String arg0) {
           Toast.makeText(context, "Provider Enabled", 
                   Toast.LENGTH_SHORT).show();
    
    
       }
    
       @Override
       public void onStatusChanged(String provider, int status, Bundle arg2) {
           Toast.makeText(context, "Status on " + provider + " is " +  getStatusMessage(status), 
                   Toast.LENGTH_SHORT).show();
       }
    
       private String getStatusMessage(int status) {
           // TODO Auto-generated method stub
           if (status == 1)
               return "contecting";
           else if (status == 2)
               return "conected";
           return "unknown";
       }
    
       public static double getLatitude (){
    	   return  latitudeP;
       }
       public static double getLongitude (){
    	   return  longitudeP;
       }
       
      public static void clear(){
    	  latitudeP=0;
    	  longitudeP=0;
    	  
      }
      
    public static void setMap(MapView map){
    	mp=map;
    	
    }  
      
   }