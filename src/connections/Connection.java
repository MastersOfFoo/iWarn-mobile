package connections;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.NameValuePair;




//import com.google.gson.Gson;

public class Connection {

	String URL = "http://iwarn-staging.herokuapp.com/";
	//String URL = "http://192.168.0.17:9292/";
	
	
	public String result = "";
	String deviceId = "xxxxx" ;
	final String tag = "Your Logcat tag: ";

	/** Called when the activity is first created. */
    
    public void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
      //  setContentView(R.layout.main);

/*        final EditText txtSearch = (EditText)findViewById(R.id.editText2);
        txtSearch.setOnClickListener(new EditText.OnClickListener(){
        	public void onClick(View v){txtSearch.setText("");}
    	});

        final Button btnSearch = (Button)findViewById(R.id.editText2);
        btnSearch.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				String query = txtSearch.getText().toString();
				callWebService(query);

			}
        }); */

    } // end onCreate()

    public void callWebService(String q){
    	HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL + q);
		request.addHeader("deviceId", deviceId);
		ResponseHandler<String> handler = new BasicResponseHandler();
		try {
			result = httpclient.execute(request, handler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpclient.getConnectionManager().shutdown();
		Log.i(tag, result);
    } // end callWebService()
 
    public void callWebServiceForGetData(String id){
    	HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL +"events/"+id+".json");
		request.addHeader("deviceId", deviceId);
		ResponseHandler<String> handler = new BasicResponseHandler();
		try {
			result = httpclient.execute(request, handler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpclient.getConnectionManager().shutdown();
		Log.i(tag, result);
    } // end callWebService()

    
    public void callWebServiceForGetAllData(){
    	HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL +"events.json");
		request.addHeader("deviceId", deviceId);
		ResponseHandler<String> handler = new BasicResponseHandler();
		try {
			result = httpclient.execute(request, handler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpclient.getConnectionManager().shutdown();
		Log.i(tag, result);
    } // end callWebService()
    
    
    
    
    
    
    /*
    
    public void callWebServiceForSendData(String jsonData){
    	HttpClient httpclient = new DefaultHttpClient();
    	HttpPost sender= new HttpPost(URL+"events.json");
    	
		//HttpGet request = new HttpGet(URL + q);
		
		HttpParams p=new BasicHttpParams();
		//p.setParameter("Method:", "POST");
	//	p.setParameter("Accept:"," application/json");
	//	p.setParameter("Content-Type:", "application/json");
	//	 //Body: {"event": {"description": null, "latitude": 70.1, "longitude": 11.0, "state": "registered", "type": "simple"}}
	//	p.setParameter("Body:",jsonData);
		
	//	sender.setParams(p);
		
		sender.addHeader("deviceId", deviceId);

		sender.addHeader("Method:", "POST");
		sender.addHeader("Accept:"," application/json");
		sender.addHeader("Content-Type:", "application/json");
		 //Body: {"event": {"description": null, "latitude": 70.1, "longitude": 11.0, "state": "registered", "type": "simple"}}
		sender.addHeader("Body:",jsonData);
		
		ResponseHandler<String> handler = new BasicResponseHandler();
		
		
		try {
			//result = httpclient.execute(sender, handler);
			HttpResponse responset = httpclient.execute(sender);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result=e.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
			result=e.toString();
		}
		httpclient.getConnectionManager().shutdown();
		Log.i(tag, result);
    } // end callWebService()
*/
    
    
    public void callWebServiceForSendData(String jsonData){
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost sender = new HttpPost(URL+"events.json");

        sender.addHeader("Accept"," application/json");
        sender.addHeader("Content-Type", "application/json");
        //Body: {"event": {"description": null, "latitude": 70.1, "longitude": 11.0, "state": "registered", "type": "simple"}}

        sender.addHeader("deviceId", deviceId);
        try {
			sender.setEntity(new StringEntity(jsonData));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //ResponseHandler<String> handler = new BasicResponseHandler();


        try {
            //result = httpclient.execute(sender, handler);
            HttpResponse response = httpclient.execute(sender);
            //HttpEntity entity = response.getEntity();
            //InputStream is = entity.getContent();
            //result=convertStreamToString(is);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            result = e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            result = e.toString();
        }
        httpclient.getConnectionManager().shutdown();
        Log.i(tag, result);
     } // 

    public void callWebServiceForUpadateState(String id,String Data){
        HttpClient httpclient = new DefaultHttpClient();
        HttpPut sender = new HttpPut(URL+"events/"+id+".json");
        
        ///events/1.json


        //sender.addHeader("Accept"," application/json");
        sender.addHeader("Content-Type", "application/json");


        sender.addHeader("deviceId", deviceId);
        
   
        
                
        try {
			sender.setEntity(new StringEntity(Data));
        	//sender.setEntity(new UrlEncodedFormEntity(pairs));
        	
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			result="excepcion en try sender ";
		}
        


        try {
        	//ResponseHandler<String> handler = new BasicResponseHandler();
            //result = httpclient.execute(sender, handler);
            HttpResponse response = httpclient.execute(sender);
            
            
            
            //String x="";
            
            
            
            
            
            //StatusLine l=response.getStatusLine() ;
            //String ex=l.getReasonPhrase()+l.getStatusCode(); 
            
            HttpEntity entity = response.getEntity();
                    	 

            //InputStream is = entity.getContent();
            
            //result=ex;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            result ="E:"+ e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            result ="E:"+ e.toString();
        }
        httpclient.getConnectionManager().shutdown();
        Log.i(tag, result);
     } // 

    
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append((line + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    

public static String getResponseBody(HttpResponse response) {

String response_text = null;

HttpEntity entity = null;

try {

entity = response.getEntity();

response_text = _getResponseBody(entity);

} catch (ParseException e) {

e.printStackTrace();

} catch (IOException e) {

if (entity != null) {

try {

entity.consumeContent();

} catch (IOException e1) {

}

}

}

return response_text;

}




public static String _getResponseBody(final HttpEntity entity) throws IOException, ParseException {

if (entity == null) { throw new IllegalArgumentException("HTTP entity may not be null"); }

InputStream instream = entity.getContent();

if (instream == null) { return ""; }

if (entity.getContentLength() > Integer.MAX_VALUE) { throw new IllegalArgumentException(

"HTTP entity too large to be buffered in memory"); }

String charset = getContentCharSet(entity);

if (charset == null) {

charset = HTTP.DEFAULT_CONTENT_CHARSET;

}

Reader reader = new InputStreamReader(instream, charset);

StringBuilder buffer = new StringBuilder();

try {

char[] tmp = new char[1024];

int l;

while ((l = reader.read(tmp)) != -1) {

buffer.append(tmp, 0, l);

}

} finally {

reader.close();

}

return buffer.toString();

}

public static String getContentCharSet(final HttpEntity entity) throws ParseException {

if (entity == null) { throw new IllegalArgumentException("HTTP entity may not be null"); }

String charset = null;

if (entity.getContentType() != null) {

HeaderElement values[] = entity.getContentType().getElements();

if (values.length > 0) {

NameValuePair param = values[0].getParameterByName("charset");

if (param != null) {

charset = param.getValue();

}

}

}

return charset;

}





}