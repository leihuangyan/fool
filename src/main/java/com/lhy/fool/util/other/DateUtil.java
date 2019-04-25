package com.lhy.fool.util.other;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *@author 98403
* @描述: [DateUtil]日期工具类
 */
public class DateUtil {

	/**
	 * 
	 * @param date
	 * @param mth
	 * @return
	 */
	public static String monthAdd(Date date, int mth) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		// 设置当前日期
		calendar.setTime(date);
		// 月份+
		calendar.add(Calendar.MONTH, mth);
		// 输出格式化的日期
		return sdf.format(calendar.getTime());

	}

	/**
	 *
	 * @param date
	 * @param mth
	 * @return
	 */
	public static Date monthAddDate(Date date, int mth) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		// 设置当前日期
		calendar.setTime(date);
		// 月份+
		calendar.add(Calendar.MONTH, mth);
		// 输出格式化的日期
		return calendar.getTime();

	}

	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static String dayAdd(Date date, int days) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		// 设置当前日期
		calendar.setTime(date);
		// 天数+
		calendar.add(Calendar.DAY_OF_MONTH, days);
		// 输出格式化的日期
		return sdf.format(calendar.getTime());

	}

	/**
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date dayAddDate(Date date, int days) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		// 设置当前日期
		calendar.setTime(date);
		// 天数+
		calendar.add(Calendar.DAY_OF_MONTH, days);
		// 输出格式化的日期
		return calendar.getTime();

	}

	/**
	 * @param date
	 * @return
	 */
	public static Date dayAddMin(Date date, int min) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		// 设置当前日期
		calendar.setTime(date);
		// 天数+
		calendar.add(Calendar.MINUTE, min);
		// 输出格式化的日期
		return calendar.getTime();
	}

	/**
	 * @param sDate
	 * @param days
	 * @return
	 */
	public static String dayAdd(String sDate, int days) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		try {
			// 设置当前日期
			calendar.setTime(sdf.parse(sDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 天数+
		calendar.add(Calendar.DAY_OF_MONTH, days);
		// 输出格式化的日期
		return sdf.format(calendar.getTime());

	}

	/**
	 * 日期加减操作（年）正数为加，负数为减
	 * 
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date yearUpdateDate(Date date, int year) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		// 设置当前日期
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		// 输出格式化的日期
		return calendar.getTime();

	}

	/**
	 * 设置时间为：23：59:59，日期不变
	 * 
	 * @param date
	 * @return
	 */
	public static Date setEndTime(Date date) {
		// 日历对象
		Calendar calendar = Calendar.getInstance();
		// 设置时间
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		// 输出格式化的日期
		return calendar.getTime();

	}

	/**
	 * 格式化时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDate(Date date) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date forMatDate = null;
		try {
			forMatDate = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return forMatDate;
	}

	public static String parseString(Date date) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String forMatDate = "";
		try {
			forMatDate = sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return forMatDate;
	}

	public static String parseStringMM(Date date) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String forMatDate = "";
		try {
			forMatDate = sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return forMatDate;
	}

	public static String parseStringMMdd(Date date) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String forMatDate = "";
		try {
			forMatDate = sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return forMatDate;
	}

	public static String parseStringHHMMSS(Date date) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String forMatDate = "";
		try {
			forMatDate = sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return forMatDate;
	}
	/**
	 * 支持自定义格式的格式化时间
	 */
	public static String parseString(Date date,String formate) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		String forMatDate = "";
		try {
				forMatDate = sdf.format(date);
		} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
		}
		return forMatDate;
    }

	/**
	 * 格式化时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseDate(String str) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date forMatDate = null;
		try {
			forMatDate = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return forMatDate;
	}

	/**
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date parseDate(String str, String format) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date forMatDate = null;
		try {
			forMatDate = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return forMatDate;
	}

	/**
	 * 格式化时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseDateHour(String str) {
		// 格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date forMatDate = null;
		try {
			forMatDate = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return forMatDate;
	}

	/**
	 * 根据起始 日期计算 间隔年 数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int calculateYears(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		long lstart = startDate.getTime();
		long lend = endDate.getTime();
		int days = (int) ((lend - lstart) / (1000 * 60 * 60 * 24));
		int year = days / 365;
		return year;

	}

	/**
	 * 计算日期间隔天数
	 * 
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算日期间隔天数
	 * 
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(String smdate, String bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(smdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time1 = cal.getTimeInMillis();
		try {
			cal.setTime(sdf.parse(bdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 截取小数点后2位
	 * 
	 * @param num
	 * @return
	 */
	public static double subLastTwo(double num) {
		BigDecimal b = new BigDecimal(num);
		double newNum = b.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
		return newNum;
	}

	/**
	 * 获取当月第一天
	 * 
	 * @return
	 */
	public static Date getMonthFirstDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// 获取前月的第一天
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();

	}

	/**
	 * 获取当月最后一天
	 * 
	 * @return
	 */
	public static Date getMonthLastDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// 获取前月的最后一天
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		return c.getTime();
	}

	/**
	 * 获取本周月最后一天
	 * 
	 * @return
	 */
	public static String getWeekFirstDay() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 获取本周的第一天
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return format.format(c.getTime());
	}

	/**
	 * 查询日期间隔 描述
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static Integer getDateBetweenSeconds(Date begin, Date end) {
		Long milliSeconds = end.getTime() - begin.getTime();
		Long seconds = milliSeconds / 1000;
		return seconds.intValue();
	}

	/**
	 * 获取一年毫秒数
	 * 
	 * @return
	 */
	public static Long getOneYearMilliseconds() {
		Long l = 60 * 60 * 24 * 365 * 1000L;
		return l;
	}

	/**
	 *时间加一年，再减一天
	 * @param time
	 * @return
	 */
	public static Date getPaulEndDate(Date time) {
		Date date = dayAddDate(DateUtil.monthAddDate(time, 12), -1);
		return date;
	}

	public static String getPaulEndDateString(Date time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dayAddDate(DateUtil.monthAddDate(time, 12), -1);
		return format.format(date);
	}

	/**
	 * 时间比较函数 (返回最小的时间)
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Date compareDate(Date date1, Date date2) {
		Calendar ca1 = Calendar.getInstance();
		Calendar ca2 = Calendar.getInstance();
		ca1.setTime(date1);
		ca1.setTime(date2);
		int result = ca1.compareTo(ca2);
		// c1相等c2
		if (result == 0) {
			return date1;
			// c1小于c2
		} else if (result < 0) {
			return date1;
		} else {// c1大于c2
			return date2;
		}
	}
	/**
         * 获取上一周是今年多少周
         * @return
         */
	public static String getLastWeekOfYear(){
		Calendar c=Calendar.getInstance(Locale.CHINA);
		//获取当天是多少周
		int i = c.get(Calendar.WEEK_OF_YEAR);
		//获取上一周
		Calendar b=Calendar.getInstance(Locale.CHINA);
		b.set(Calendar.WEEK_OF_YEAR,i-1);
		return b.get(Calendar.YEAR)+"-"+b.get(Calendar.WEEK_OF_YEAR);
	}
	/**
	 * 获取上一周 周日
	 * @return
	 */
	public static Date getLastWeekSunday(){
		Calendar c=Calendar.getInstance(Locale.CHINA);
		//获取当天是多少周
		int i = c.get(Calendar.WEEK_OF_YEAR);
		Calendar b=Calendar.getInstance(Locale.CHINA);
		//获取上一周
		b.set(Calendar.WEEK_OF_YEAR,i-1);
		//获取上一周周一
		b.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		//日期+7 获取上一周周日
		b.set(Calendar.DAY_OF_MONTH, b.get(Calendar.DAY_OF_MONTH)+6);
		b.set(Calendar.HOUR_OF_DAY, 23);
		b.set(Calendar.MINUTE, 59);
		b.set(Calendar.SECOND, 59);
		return b.getTime();
	}
	 /**
	 * 获取上一周 周一
	 * @return
	 */
	public static Date getLastWeekMonday(){
		Calendar c=Calendar.getInstance(Locale.CHINA);
		//获取当天是多少周
		int i = c.get(Calendar.WEEK_OF_YEAR);
		Calendar b=Calendar.getInstance(Locale.CHINA);
		//获取上一周
		b.set(Calendar.WEEK_OF_YEAR,i-1);
		//获取上一周周一
		b.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		b.set(Calendar.HOUR_OF_DAY, 0);
		b.set(Calendar.MINUTE, 0);
		b.set(Calendar.SECOND, 0);
		return b.getTime();
	}


	/**
	 * 本地时间转毫秒
	 * @param date localDateTime
	 * @return 毫秒
	 */
	public static Long localDateTimeToLong(LocalDateTime date){
		return date.toInstant(ZoneOffset.of("+8")).toEpochMilli();
	}

	/**
	 * 将java.util.Date 转换为java8 的java.time.LocalDateTime,默认时区为东8区
	 * @param date date
	 * @return localDateTime
	 */
	public static LocalDateTime dateConvertToLocalDateTime(Date date) {
		return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
	}


	/**
	 * 将java8 的 java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
	 * @param localDateTime localDateTime
	 * @return date
	 */
	public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
	}


	 
	
}
