package Ansin.web.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class EditUtil {

//	/**
//	 * StringからBYTEの転換方法
//	 * @param string
//	 * @return byte[]
//	 */
//	public static byte[] byteUtil(String string) {
//
//		if(!StringUtils.isEmpty(string)) {
//			byte[] byte1 = new String(string).getBytes();
//
//			return byte1;
//		}
//		return null;
//	}
//
//	/**
//	 * BYTEからStringの転換方法
//	 * @param byte[]
//	 * @return string
//	 */
//	public static String byteUtil(byte[] byteS) {
//
//		if(byteS != null) {
//			String string = new String(byteS);
//
//			return string;
//		}
//		return null;
//	}

	/**
	 * StringからBigDecimalの転換方法
	 * @param string
	 * @return　BigDecimal
	 */
	public static BigDecimal bigDecimalUtil(String string){

		if(!StringUtils.isEmpty(string)) {
	        BigDecimal bd = new BigDecimal(string);

	        return bd;
		}
		return null;
	}

	/**
	 *BigDecimalからStringの転換方法
	 * @param BigDecimal
	 * @return　string
	 */
	public static String bigDecimalToStrUtil(BigDecimal bd){

		if(bd != null) {
			String string = bd.toString();

	        return string;
		}
		return null;
	}

	/**
	 * Stringからintの転換方法
	 * @param string
	 * @return int
	 */
	public static Integer intUtil(String string){

		if(!StringUtils.isEmpty(string)) {
			Integer i = Integer.parseInt(string);

	        return i;
		}
		return null;
	}

	/**
	 * intからStringの転換方法
	 * @param int
	 * @return String
	 */
	public static String intUtil(Integer num){

		if(num != null) {
	        String string = String.valueOf(num);

	        return string;
		}
		return null;
	}

	/**
	 * StringからDateの転換方法
	 * @param String
	 * @return Date
	 */
	public static Date dateUtil(String str) {
		try {
			if (!StringUtils.isEmpty(str)) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = simpleDateFormat.parse(str);
				return date;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	  }

	/**
	 * DateからStringの転換方法
	 * @param Date
	 * @return String
	 */
	public static String dateUtil(Date date){
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
			String str = simpleDateFormat.format(date);
			return str;
		}
		return null;
	}

	/**
	 * StringからTimestampの転換方法
	 * @param String
	 * @return Timestamp
	 */
	public static Timestamp timeStampUtil(String str) {
		if (!StringUtils.isEmpty(str)) {
			Timestamp timestamp = Timestamp.valueOf(str);
			return timestamp;
		}
		return null;
	  }

	/**
	 * TimestampからStringの転換方法
	 * @param Timestamp
	 * @return String
	 */
	public static String timeStampUtil(Timestamp timestamp){
		if (timestamp != null) {
			 String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
			return str;
		}
		return null;
	}
	/**
	 * StringからTimeの転換方法
	 * @param String
	 * @return Time
	 */
	public static Time timeUtil(String str) {
		if (!StringUtils.isEmpty(str)) {
			Time time = Time.valueOf(str);
			return time;
		}
		return null;
	  }

	/**
	 * TimeからStringの転換方法
	 * @param Time
	 * @return String
	 */
	public static String timeUtil(Time time){
		if (time != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");//注意月份是MM
			String str = simpleDateFormat.format(time);
			return str;
		}
		return null;
	}

	/**
	 * StringからDoubleの転換方法
	 * @param String
	 * @return Double
	 */
	public static Double doubleUtil(String str) {
		if (!StringUtils.isEmpty(str)) {
			Double dob = Double.valueOf(str);
			return dob;
		}
		return null;
	  }

	/**
	 * DoubleからStringの転換方法
	 * @param Double
	 * @return String
	 */
	public static String doubleUtil(Double dob){
		if (dob != null) {
			String str = String.valueOf(dob);
			return str;
		}
		return null;
	}



	/** 仕事年数を取得する。
	 *
	 * @param date
	 * @return
	 */
	public static Integer getYear(Integer date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Integer dateInteger = EditUtil.intUtil(sdf.format(new Date()));
			return dateInteger - date;
		}
		return null;
	}
	
	// 円から万円を転換する
	public static String changePrice(String price) {
        BigDecimal bigDecimal = new BigDecimal(price);
        // 万円を転換する
        BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
        // 小数点以下2桁を保留する
        DecimalFormat formater = new DecimalFormat("0.##");
        // 四捨五入する
        formater.setRoundingMode(RoundingMode.HALF_UP);
        // 結果を取得する
        String formatNum = formater.format(decimal);
        // 
        return formatNum;
	}

}
