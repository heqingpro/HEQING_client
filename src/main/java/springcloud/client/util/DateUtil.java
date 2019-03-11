package springcloud.client.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @program: HEQING_client
 * @description:
 * @author: hezy
 * @create: 2019-03-11 16:33
 **/
public class DateUtil {

	private final static String TAG = DateUtil.class.getName();

	public static final String PATTERN1 = "yyyy-MM-dd";

	public static final Integer UTC_LENGTH = 10;



	/**
	 * 10-13位utc时间转换为日期（字符串）
	 * 
	 * @param utcTime
	 * @param pattern
	 * @return
	 */
	public static String utc2DateString(String utcTime, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 为10位时间戳时
		if (utcTime.trim().length() == UTC_LENGTH) {
			utcTime += "000";
		}
		long l1 = new Long(utcTime);
		Date date = new Date(l1);
		return sdf.format(date);
	}

	/**
	 * Date 2 String
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String date2String(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	/**
	 * 获取一个月的实际天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getActualDaysOfMonth(Integer year, Integer month) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);

		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取当前日期是星期几,周日--周六：0-6
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return w;

	}
	/**
	 * 获取当前时间

	 * @return
	 */
	public static String getFormatCurrentTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	public static String getStandardFormatCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	/**获取相应年份相应季度的开始时间
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static String getQuarterStartTime(int year, int quarter){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
	    int month = 0;
        switch (quarter) {
	        case 1:
	            month = 1-1;
	            break;
	        case 2:
	            month = 4-1;
	            break;
	        case 3:
	            month = 7-1;
	            break;
	        case 4:
	            month = 10-1;
	            break;
	        default:
	            month = c.get(Calendar.MONTH);
	            break;
        }
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DATE, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(c.getTime());
	}
	/**获取相应年份相应季度的结束时间
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static String getQuarterEndTime(int year, int quarter){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
	    int month = 0;
        switch (quarter) {
	        case 1:
	            month = 3-1;
	            break;
	        case 2:
	            month = 6-1;
	            break;
	        case 3:
	            month = 9-1;
	            break;
	        case 4:
	            month = 12-1;
	            break;
	        default:
	            month = c.get(Calendar.MONTH);
	            break;
        }
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DATE, 1);
        c.roll(Calendar.DATE, -1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(c.getTime());
	}
}
