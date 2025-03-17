package com.SalesAndInventorySystem.javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber() {
		Random ran=new Random();
		int num = ran.nextInt(50000);
		return num;
	}
	
	
	public String getSystemDate() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String formateddate = sdf.format(date);
		return formateddate;
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
		Date obj=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sim.getCalendar();
		
		String date=sim.format(obj);
		
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		
		return reqDate;
		
	}

}

