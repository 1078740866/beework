package Ansin.web.util;

public class AutoNumber {
	
	/**
	 * ID自增方法
	 * @param id
	 * @return strId
	 */
	public static String autoNumber(String id) {
		
		int idInt = Integer.parseInt(id)+1;
		
		String strId = String.valueOf(idInt);
		
		return strId;
	}
	
	

}
