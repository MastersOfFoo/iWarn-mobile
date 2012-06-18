package mngt_activity;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import objects.Photo;

import com.google.gson.Gson;

import connections.Connection;

import location.MyLocationListener;
import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import aplication.start.main.R;

public class Management_Select_Image extends Activity{
	int numphotos=0;
	public final int SELECT_PHOTO = 100;
	public static Bitmap bm=null;
	public static String id=null;
	public static String name="";
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.select_image);
        
        Button bt=(Button) findViewById(R.id.Load_Image );
        bt.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			
      	      Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      	     int SELECT_PHOTO = 100;
      	     startActivityForResult(i,SELECT_PHOTO);
      	     
      	     

      	       			 	      			
      			}
      		});
        
        Button bt2=(Button) findViewById(R.id.btn_add_image);
        bt2.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			
      			Intent intent2=new Intent();
      	      	 intent2.setClass(view.getContext(),Management_Advise_Send_Image.class);      	      	       	
      	      	 startActivity(intent2);                
      		}});
        
        Button bt3=(Button) findViewById(R.id.btn_back_photo_to_event);
        bt3.setOnClickListener(new View.OnClickListener(){
      		public void onClick(View view){
      			
      			finish();
      		}});
  
	
    Button bt4=(Button) findViewById(R.id.btn_view_photos);
    bt4.setOnClickListener(new View.OnClickListener(){
  		public void onClick(View view){
  			
  			 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

  	        StrictMode.setThreadPolicy(policy);

			  
			  

			  
			  Gson gs=new Gson();
				Connection a=new Connection();								
				a.callWebServiceForGetAllPhotosOfevent(id);
				Photo obj[] = gs.fromJson(a.result,  Photo[].class);
				if(obj!=null ){
				Management_View_Image.setAllPhotos(obj);
				}
				
  			Intent intent2=new Intent();
 	      	 intent2.setClass(view.getContext(),Management_View_Image.class);      	      	       	
 	      	 startActivity(intent2);    
  			
  		}});

	
	
	
	//btn_view_photos
}
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

        switch(requestCode) { 
        case SELECT_PHOTO:
            if(resultCode == RESULT_OK){  
                Uri selectedImage = imageReturnedIntent.getData();
                name=selectedImage.getEncodedSchemeSpecificPart();
                
                //t_query1.setText(selectedImage.getPath());
                InputStream imageStream;
				try {
					imageStream = getContentResolver().openInputStream(selectedImage);
					Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
					bm=yourSelectedImage;
					name=getRealPathFromURI(selectedImage);					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
                
            }
        }
    }
    
    

    void downloadFile(String imageHttpAddress,ImageView imageView) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            Bitmap loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
            imageView.setImageBitmap(loadedImage);
        } catch (IOException e) {
        	
            Toast.makeText(getApplicationContext(), "Error cargando la imagen: "+e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


	private static void copy(InputStream in, BufferedOutputStream out) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	public String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String c= cursor.getString(column_index);
        String au[]=c.split("/");
        
        return au[au.length-1];
    }
	
	

}
