package com.ssreddy.repository;

import java.util.List;

import com.ssreddy.model.Activity;

public interface ActivityResourceStubInter {

	public abstract List<Activity> findAllActivity();

	public abstract Activity findActivity(String activityId);

	public abstract void insertActivity(Activity ac1);

	public abstract Activity updateActivity(Activity ac);

}