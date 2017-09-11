package com.ssreddy.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ssreddy.model.Activity;

public class ClientActivity {

	private Client client;
	
	private static String url="http://localhost:8484/exercise-service/webapi/"; 
	private static String error=" : there was an error in server, Please check it.....Thank u";
	
	
	public ClientActivity() {
		client=ClientBuilder.newClient();
	}
	
	public Activity getActivity(String id) {
		
		WebTarget target=client.target(url);
		
		Response response=target.path("activities/"+id).request().get(Response.class);
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus()+error);
		}
		
		//Activity response=target.path("activities/"+id).request().get(Activity.class);
		//String data=target.path("activities/"+id).request(MediaType.APPLICATION_XML).get(String.class);
		//System.out.println(data);
		//return null;
		return response.readEntity(Activity.class);
	}
	
	public List<Activity> getAllActivities(){
		
		WebTarget targer=client.target(url);
		//List<Activity> list=targer.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		return targer.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		
	}

	public Activity createActivity(Activity ac) {
		
		WebTarget target=client.target(url);
		Response response=target.path("activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(ac, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus()+error);
		}
		
		//Activity response=target.path("activities/"+id).request().get(Activity.class);
		//String data=target.path("activities/"+id).request(MediaType.APPLICATION_XML).get(String.class);
		//System.out.println(data);
		//return null;
		return response.readEntity(Activity.class);
		
	}

	public Activity updateActivity(Activity ac) {
		
		WebTarget target=client.target(url);
		Response response=target.path("activities/"+ac.getActivityId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(ac, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus()+error);
		}
		
		//Activity response=target.path("activities/"+id).request().get(Activity.class);
		//String data=target.path("activities/"+id).request(MediaType.APPLICATION_XML).get(String.class);
		//System.out.println(data);
		//return null;
		return response.readEntity(Activity.class);
		
	}
}
