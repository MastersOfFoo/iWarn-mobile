package mngt_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import aplication.start.main.R;
import aplication.start.main.R.id;
import aplication.start.main.R.layout;

public class ManagementDescriptionType extends Activity{
	private static String description="";
	private static String type="";
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_type);
        
        if(type!=""){
        	int pos=0;
        	if(type.equals("multiple")){
        		pos=1;
        	}
        	if(type.equals("runover")){
        		pos=2;
        	}
        	
        Spinner s=(Spinner) findViewById(R.id.spinner1);
			s.setSelection(pos,true);
        }
        if(description!=""){
        	TextView tx=(TextView) findViewById(R.id.description_box);
        	tx.setText(description);
        	
        }
        
		  Button b1 = (Button) findViewById(R.id.bnt_next_DT);
	      	b1.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      			
	      			
	      			description=(((TextView) findViewById(R.id.description_box)).getText()).toString();
	      			type =(((Spinner) findViewById(R.id.spinner1)).getSelectedItem()).toString();
	      			
	      			finish();
	      			Intent intent=new Intent();
	      			intent.setClass(view.getContext(),ManagementsAndroidMapas.class);
	      	      	startActivity(intent);
	      	      	
	      			 
	      			
	      			}
	      		});
	      	
	      	
	      	
	      	
	      	Button b2 = (Button) findViewById(R.id.bnt_back_DT);
	      	b2.setOnClickListener(new View.OnClickListener(){
	      		public void onClick(View view){
	      	
	      	      	finish();
	      			 
	      			
	      			}
	      		});
	      	
	      	
	      	
	      		
	      	}
    
public static String getDescription(){
	return description;
}
    
public static String getType(){
	return type;
}


public static void clear(){
	description="";
	type="";
}


        
    }
	
	


