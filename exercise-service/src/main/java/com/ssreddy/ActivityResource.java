package com.ssreddy;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ssreddy.model.Activity;
import com.ssreddy.model.User;
import com.ssreddy.repository.ActivityResourceStub;
import com.ssreddy.repository.ActivityResourceStubInter;

@Path("/activities")
public class ActivityResource {

	private ActivityResourceStubInter activity=new ActivityResourceStub();
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivity(Activity ac) {
		
		System.out.println(ac.getDescription());
		System.out.println(ac.getDuration());
		activity.insertActivity(ac);
		return ac;
	}
		
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Activity createActivityParam(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity ac1=new Activity();
		ac1.setDescription(formParams.getFirst("description"));
		ac1.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		activity.insertActivity(ac1);
		return ac1;
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return activity.findAllActivity();
	}
	
	@Path("{activityid}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getActivity(@PathParam("activityid") String activityId){
		
			if(activityId == null || activityId.length() < 4) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			
			Activity ac = activity.findActivity(activityId);
			
			if(ac == null) {
				return Response.status(Status.NOT_FOUND).build();
			}
		
			System.out.println("Activity Id : "+activityId);
		return Response.ok().entity(ac).build(); 
	}
	
	@Path("{activityid}/user")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User getUserActivity(@PathParam("activityid") String activityId){
		
		Activity ac=activity.findActivity(activityId);
		User user=ac.getUser();
		return user;
//		return activity.findActivity(activityId).getUser();
	}
	
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateActivity(Activity ac) {
		
		System.out.println(ac.getActivityId());
//		System.out.println(ac.getDuration());
		ac = activity.updateActivity(ac);
		return Response.ok().build();
	}
	
	
}
