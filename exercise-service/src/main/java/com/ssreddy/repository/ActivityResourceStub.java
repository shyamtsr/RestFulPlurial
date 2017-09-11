package com.ssreddy.repository;

import java.util.ArrayList;
import java.util.List;

import com.ssreddy.model.Activity;
import com.ssreddy.model.User;



public class ActivityResourceStub implements ActivityResourceStubInter {
	
	List<Activity> listactivity;
	
	public ActivityResourceStub() {
	
		listactivity=new ArrayList<>();
		Activity ac1=new Activity();
		ac1.setActivityId("20111");
		ac1.setDescription("Cricket");
		ac1.setDuration(120);
		
		Activity ac2=new Activity();
		ac2.setActivityId("20112");
		ac2.setDescription("Swimming");
		ac2.setDuration(60);
		
		Activity ac3=new Activity();
		ac3.setActivityId("20113");
		ac3.setDescription("Cycling");
		ac3.setDuration(70);
		
		listactivity.add(ac1);
		listactivity.add(ac2);
		listactivity.add(ac3);
	}
	
	/* (non-Javadoc)
	 * @see com.ssreddy.repository.ActivityResourceStubInter#findAllActivity()
	 */
	@Override
	public List<Activity> findAllActivity(){
		
		
		/*
		Activity ac1=new Activity();
		ac1.setDescription("Cricket");
		ac1.setDuration(120);
		
		Activity ac2=new Activity();
		ac2.setDescription("Swimming");
		ac2.setDuration(60);
		
		Activity ac3=new Activity();
		ac3.setDescription("Cycling");
		ac3.setDuration(70);
		
		listactivity.add(ac1);
		listactivity.add(ac2);
		listactivity.add(ac3);*/
		
//		listactivity.addAll(Collections.Lis)
		return listactivity;
	}
	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("7777")) {
			return null;
		}
		
		Activity ac1=new Activity();
		ac1.setActivityId("1234");
		ac1.setDescription("Cycling");
		ac1.setDuration(70);
		
		User user=new User();
		user.setUserId(205);
		user.setName("Shyam");
		
		ac1.setUser(user);
		return ac1;
	}
	
	@Override
	public void insertActivity(Activity ac1) {
	
		listactivity.add(ac1);
		
	}
	
	@Override
	public Activity updateActivity(Activity ac) {
		if(ac == null) {
			return null;
		}
		listactivity.add(ac);
		for(Activity a : listactivity) {
			if(a.getActivityId().equals(ac.getActivityId())) {
//				listactivity.set(a.getActivityId(), ac);
				listactivity.add(ac);
				System.out.println("Update data : Activity Id : "+a.getActivityId()+", Description : "+a.getDescription()+", Duration : "+a.getDuration());
			}else {
				listactivity.add(ac);
			}
		}
		return ac;
	}

}
