package cn.edu.qtech.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String formatDate2yyymmdd(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formatStr = simpleDateFormat.format(date);
		return formatStr;
	}

}
