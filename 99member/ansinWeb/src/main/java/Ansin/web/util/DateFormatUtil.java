package Ansin.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateFormatUtil {

	// 年齢から生年月日を転換する（int　→　Date）
	public static String getDate(int ageYear){
		Calendar c = Calendar.getInstance();
	    c.add(Calendar.YEAR, -ageYear);
	    return String.format("%tF", c.getTime());
    }

	// 年齢から生年月日を転換する（String　→　Date）
	public static String convertDate(Integer age){
		if (StringUtils.isEmpty(age)) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, - age);
		return String.format("%tF", cal.getTime());

    }


	// 生年月日から年齢を転換する（Date　→　int）
	public static int getAge(Date birthDay){
        Calendar cal = Calendar.getInstance();

        Date date=new Date();
        
        int age = 0;

        if(date.getTime()<birthDay.getTime()){
            return age;
        }else{
        	int yearNow = cal.get(Calendar.YEAR);
        	int monthNow = cal.get(Calendar.MONTH);
        	int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        	cal.setTime(birthDay);
        	
        	int yearBirth = cal.get(Calendar.YEAR);
        	int monthBirth = cal.get(Calendar.MONTH);
        	int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        	
        	age = yearNow - yearBirth;
        	
        	if(age == 0) {
        		return age;
        	}
        	
        	if (monthNow <= monthBirth){
        		if (monthNow == monthBirth){
        			if (dayOfMonthNow < dayOfMonthBirth) {
        				age--;
        			}else{
        				age--;
        			}
        		}
        	}
        	return age;
        }
    }


	// StringからDateを転換する（String　→　Date）
	public static Date stringToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date a = new Date();
		try {
			a = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return a;
    }

	// StringからDateを転換する（Date → String）
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(date);
		return dateString;
	}

}
