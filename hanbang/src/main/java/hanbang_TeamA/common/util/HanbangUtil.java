package hanbang_TeamA.common.util;

import java.util.Calendar;

public class HanbangUtil {
	public static String getDateTime()
    {
    	Calendar oCalendar = Calendar.getInstance( );  

        return "" + oCalendar.get(Calendar.YEAR) + "."
        + (oCalendar.get(Calendar.MONTH) + 1) + "."
        + oCalendar.get(Calendar.DAY_OF_MONTH) + " "
        + oCalendar.get(Calendar.HOUR_OF_DAY) + ":"
        + oCalendar.get(Calendar.MINUTE) + ":"
        + oCalendar.get(Calendar.SECOND);
    }

}
