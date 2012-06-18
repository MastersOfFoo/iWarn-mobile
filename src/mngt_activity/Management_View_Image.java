package mngt_activity;

import objects.Photo;
import connections.Connection;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import aplication.start.main.IWarn_androidActivity;
import aplication.start.main.R;

public class Management_View_Image extends Activity{
	public int img_actual=0;
	public static Photo Photos[];
	public ImageView iv;
	@Override    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.show_image);
        
        
        iv=(ImageView)findViewById(R.id.View_Complete_Image);
        TextView t1 = (TextView) findViewById(R.id.txt_image_number);

        String sh="No photos to view";
        if(Photos!=null && Photos.length>0){
			loadImage();
			sh="Showing photo "+(img_actual+1)+" of "+Photos.length+" photos";
        }
	    	
	    	t1.setText(sh);     				      			 	      			


        
        
        
        Button b1 = (Button) findViewById(R.id.btn_next_image);
      	b1.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			if(Photos!=null && Photos.length>0 && img_actual+1<Photos.length ){
      				img_actual=img_actual+1;
      				loadImage();
      				
      				TextView t1 = (TextView) findViewById(R.id.txt_image_number);
          	    	
          	    	
          	    	
          	    	t1.setText("Showing photo "+(img_actual+1)+" of "+Photos.length+" photos" );
      			}
      	    	     				      			 	      			
      			}
      		});
        Button b2 = (Button) findViewById(R.id.btn_back_image);
      	b2.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			if(Photos!=null && Photos.length>0 && img_actual-1>=0){
      				img_actual=img_actual-1;
      				loadImage();
      			}
      			TextView t1 = (TextView) findViewById(R.id.txt_image_number);
      	    	
      	    	
      	    	
      	    	t1.setText("Showing photo "+(img_actual+1)+" of "+Photos.length+" photos" );         				      			 	      			
      			}
      		});
      	
      	
        Button b3 = (Button) findViewById(R.id.btn_back_to_photo);
      	b3.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			finish();
      			}
      		});
      	
      	
        
	}
	
	public void loadImage(){
		Connection a=new Connection();
		//(String regex, String replacement)
		String url=Photos[img_actual].url;
		url=url.replaceAll(" ","%20");
		a.LoadImageFromUrl(url,iv);
		
	}
	
	public static void setAllPhotos(Photo photos[]){
		Photos=photos;
	}
	
	
}
