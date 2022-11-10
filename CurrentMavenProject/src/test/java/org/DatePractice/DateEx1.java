package org.DatePractice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx1 {
	public static void main(String[] args) {
		Date dt= new Date();
		SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String newDate=date.format(dt);
		String uniqueID= newDate.replace("-", "").replace(" ", "_").replace(":", "");
		System.out.println("IMG_"+uniqueID);
	}
}
