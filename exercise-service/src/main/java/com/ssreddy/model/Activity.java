package com.ssreddy.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {
	
	
	private String description;
	private int duration;
	private String activityId;
	private User user;
	
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}
	
	public String getActivityId() {
		return activityId;
	}
	
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
