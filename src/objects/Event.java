package objects;

import java.util.Calendar;

public class Event {
	public String description;
	public double latitude;
	public double longitude;
	public String state;
	public String type;
	public String created_at;
	public String id;
	
	
	public Event(String description,double latitude,double longitude,String type){
		this.description=description;
		this.latitude=latitude;
		this.longitude=longitude;
		this.state="registered";
		this.type=type;		

		
	}
// gets	
	
	public String getDescription(){
		return description;		
	}
	public double getLatitude(){
		return latitude;
	}
	public double getLongitude(){
		return longitude;
	}	
	public String getState(){
		return state;		
	}
	public String getType(){
		return type;		
	}
	public String getCreated(){
		return created_at;		
	}
	public String getId(){
		return id;		
	}
	

	
// sets	
	public void setDescription(String description){
		this.description=description;		
	}
	public void setLalitude(double latitude){
		this.latitude=latitude;
	}
	public void setLongitude(double longitude){
		this.longitude=longitude;
	}	
	public void setState(String state){
		this.state=state;		
	}
	public void setType(String type){
		this.type=type;		
	}
	public void setCreated(String created_at){
		this.created_at=created_at;		
	}
	
	public void createDate(){
		
		Calendar cal=Calendar.getInstance();
		
		 String fec[]=created_at.split(" ");
		 // year - month -day
		 String date[]=fec[0].split("-");
		 // hour - minuts - seconds
		 String hour[]=fec[1].split(":");
		 
		 //set(int year, int month, int date, int hour, int minute, int second)
		 
		 cal.set(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]),Integer.parseInt(hour[0]),Integer.parseInt(hour[1]),Integer.parseInt(hour[2]));
		// cal.set(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
		 cal.add(Calendar.HOUR, -5);
		 created_at=cal.getTime().toString();
		 
		
	}


}
