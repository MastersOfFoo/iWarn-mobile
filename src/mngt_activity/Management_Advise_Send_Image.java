package mngt_activity;

import connections.Connection;
import android.app.Activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import aplication.start.main.R;

public class Management_Advise_Send_Image extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advise_send_image);
        String s="Photo sended successfully";
        
        try {
        	  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

              StrictMode.setThreadPolicy(policy); 

    		Connection a=new Connection();
			a.callWeServiceForSendImage(Management_Select_Image.bm,Management_Select_Image.id,Management_Select_Image.name);
    	} catch (Exception e1) {
    		// TODO Auto-generated catch block
    		//result="error en execute";    		
    		e1.printStackTrace();
    		s="Photo No sended";
    	}
        
        Button bt=(Button) findViewById(R.id.back_add_img);
        bt.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			
      			finish();
      			
      			
      		}});

        TextView tw=(TextView) findViewById(R.id.Text_Photos_Result);
        tw.setText(s);
        
        }
	

}
