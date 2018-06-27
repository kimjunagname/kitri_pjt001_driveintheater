package datetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {

	public static void main(String[] args) {
		String start = "2017-05-05 00:00:00";
		String end = "2015-05-10 00:00:00";
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			Date startDate = sdf.parse(start);
			Date endDate = sdf.parse(end);
			cal.setTime(startDate);
//			int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			long diff = endDate.getTime()-startDate.getTime();
			long diffDays = diff / (24*60*60*1000);

			for (int i = 0; i < (int)diffDays; i++) {
				cal.add(Calendar.DAY_OF_YEAR, 1);
				System.out.println(sdf.format(cal.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
