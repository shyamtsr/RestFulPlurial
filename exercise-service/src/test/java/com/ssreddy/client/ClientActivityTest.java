package com.ssreddy.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ssreddy.model.Activity;

public class ClientActivityTest {

	private ClientActivity client;
	@Before
	public void setup() {
		client=new ClientActivity();
	}
	
	@Test
	public void createActivityTest() {

		Activity ac=new Activity();
		ac.setDescription("Test Cricket");
		ac.setDuration(2400);
		
		ac = client.createActivity(ac);
		
	}
	
	@Test
	public void updateActivityTest() {

		Activity ac=new Activity();
		ac.setActivityId("3456");
		ac.setDescription("Test Cricket");
		ac.setDuration(2400);
		
		ac = client.updateActivity(ac);
		
	}
	
	@Test
	public void testGetActivity() {
		Activity ac=client.getActivity("1234");
		System.out.println(ac);
		assertNotNull(ac);
		//fail("Not yet implemented");
	}
	
	@Test
	public void getAllActivities() {
		List<Activity> ac=client.getAllActivities();
		for(Activity a:ac) {
			System.out.println(a);
		}
		
		assertNotNull(ac);
		
	}
	
	@Test(expected=RuntimeException.class)
	//@Test
	public void expected_Bad_Request_Exception() {
		client.getActivity("777");
		
	}
	
	@Test(expected=RuntimeException.class)
	//@Test
	public void expected_Not_Found_Exception() {
		client.getActivity("7777");
		
	}
	

}
