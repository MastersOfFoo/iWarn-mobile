package mngt_activity;

import com.google.gson.Gson;

import connections.Connection;
import objects.Event;
import objects.Photo;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import aplication.start.main.R;

public class Management_image_group extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.view_image_group);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

	        StrictMode.setThreadPolicy(policy); 
	        
			
		Gson gs=new Gson();
		Connection a=new Connection();
		//a.callWebServiceForGetAllPhotosOfevent(Management_.id);
		
		Event obj[] = gs.fromJson(a.result,  Event[].class);

        
        
        
        }

}
