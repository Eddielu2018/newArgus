package cn.htd.argus.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间工具类
 *
 */
public class DateUtil {
	public static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
	public static final String FORMAT_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DD = "yyyy-MM-dd";

	/**
	 * 获取当前时间
	 *
	 * @return
	 */
	public static Date getCurDate() {
		return new Date();
	}

	/**
	 * 获取当前时间
	 *
	 * @return
	 */
	public static String getCurDateStr(String pattern) {
		String strDate = null;
		try {
			Random random = new Random();
			int ran = random.nextInt(9999-1000+1)+1000;
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			strDate = format.format(getCurDate());
			strDate =  strDate + ran;
		} catch (Exception e) {
			logger.error("Method getCurDateStr arises the error,parameters ---> pattern=" + pattern);
			logger.error(e.toString(), e);
		}
		return strDate;
	}

	/**
	 * 获取当前时间
	 *
	 * @return
	 */
	public static String getCurDateStr1(String pattern) {
		String strDate = null;
		try {
			Random random = new Random();
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			strDate = format.format(getCurDate());
		} catch (Exception e) {
			logger.error("Method getCurDateStr arises the error,parameters ---> pattern=" + pattern);
			logger.error(e.toString(), e);
		}
		return strDate;
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		String strDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			strDate = format.format(date);
		} catch (Exception e) {
			logger.error("Method formatDate arises the error,parameters --->date=" + date + "pattern=" + pattern);
		}
		return strDate;
	}

	/**
	 * 日期转换
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date) {
		if (date != null && date.trim().length() > 0) {
			try {
				SimpleDateFormat format = new SimpleDateFormat();
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 根据给定日期字符串和日期格式 创建日期
	 *
	 * @param dateString
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date createDate(String dateString, String pattern) throws ParseException {
		Date date = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			date = format.parse(dateString);
		} catch (Exception e) {
			logger.error(
					"Method createDate arises the error,parameters --->date=" + dateString + ",pattern=" + pattern);
			logger.error(e.toString(), e);
		}
		return date;
	}

	/**
	 * 比较开始时间和结束时间
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int compareDate(String beginDate, String endDate) {
		DateFormat df = new SimpleDateFormat(FORMAT_SS);// "yyyy-MM-dd"
		try {
			Date dateBegin = df.parse(beginDate);
			Date dateEnd = df.parse(endDate);

			if (dateBegin.getTime() > dateEnd.getTime()) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			logger.error(
					"Method compareDate arises the error,parameters --->begindate" + beginDate + ",enddate=" + endDate);
			return -1;
		}
	}

	/**
	 * 检查开始时间，结束时间
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static boolean isCheckDate(String beginDate, String endDate) {
		String strCurrent = DateUtil.getCurDateStr(FORMAT_DD);// "yyyy-MM-dd"

		int check = compareDate(beginDate, endDate);
		if (check == 1) {
			logger.error("开始时间不能晚于结束时间,请检查！");
			return false;
		} else if (check == -1) {
			logger.error("时间格式不正确,请检查！");
			return false;
		} else {
			int checkAagin = compareDate(endDate, strCurrent);
			if (checkAagin == 1) {
				logger.error("结束时间不能晚于当前时间,请检查！");
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 获取指定天数后日期
	 *
	 * @param date
	 * @param days
	 * @return
	 */
	public static String getAfterDate(Date date, int days) {
		String result = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat(FORMAT_DD);// "yyyy-MM-dd"
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + days);
			result = df.format(calendar.getTime());
		} catch (Exception e) {
			logger.error("Method getAfterDate arises the error,parameters --->date" + date + "days" + days);
			logger.error(e.toString(), e);
		}
		return result;
	}

	/**
	 * 描述：给指点日期加天数
	 *
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDay(Date date, int days) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + days);
			date = calendar.getTime();
		} catch (Exception e) {
			logger.error("Method getAfterDate arises the error,parameters --->date" + date + "days" + days);
			logger.error(e.toString(), e);
		}
		return date;
	}

	/**
	 * 描述：给指点日期加小时
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addHour(Date date, int hour) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(FORMAT_SS);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + hour);
			date = calendar.getTime();
		} catch (Exception e) {
			logger.error("Method getAfterDate arises the error,parameters --->date:" + date + "hour:" + hour);
			logger.error(e.toString(), e);
		}
		return date;
	}

	/**
	 * 描述：给指点日期加分钟
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addMinute(Date date, int minute) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
			date = calendar.getTime();
		} catch (Exception e) {
			logger.error("Method getAfterDate arises the error,parameters --->date:" + date + "minute:" + minute);
			logger.error(e.toString(), e);
		}
		return date;
	}

	/**
	 * 描述：计算时间差(给定时间与时间差之和是否大于当前时间)
	 *
	 * 返回值：true：当前时间-表示开始时间>=时间差；false：当前时间 - 表示开始时间<时间差 ；
	 *
	 */
	public static boolean compareTime(String startTime, String days) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(startTime);
			long time1 = date.getTime();
			long time2 = new Date().getTime();
			long day = Long.valueOf(days);
			long time3 = day * 24 * 60 * 60 * 1000;

			long disTime = time2 - time1;

			if (disTime >= time3) {

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public static void main(String[] args) {
//		System.out.println(addDay(new Date(), 20));
		Random random = new Random();
		int ran = random.nextInt(9999-1000+1)+1000;
		System.out.println(ran);
	}
}
