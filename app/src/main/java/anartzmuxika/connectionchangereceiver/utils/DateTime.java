package anartzmuxika.connectionchangereceiver.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/********************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 20/1/18.
 ********************************************************************************/

public class DateTime {


    public static String getCurrentData ()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());

    }

    public static Calendar getCurrentDataCalendar()
    {
        return  Calendar.getInstance();
    }


    public static String getCurrentDataTime ()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public static String getYesterdayData ()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return dateFormat.format(cal.getTime());
    }

    public static String [] getFirstDayNextYearAndLastDayBeforeYear ()
    {
        String [] datas = new String [2];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        datas [0] = dateFormat.format(cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.MONTH, 11);
        datas [1] = dateFormat.format(cal.getTime());
        return datas;
    }

    public static String getCurrentDataWithAddSetMonthValue (String first_data, int add_month)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        if (!first_data.equals("")) //add first_data in calendar object to correct asign in second data
        {
            int urtea = Integer.parseInt(first_data.substring(0, 4));
            int hilabetea = Integer.parseInt(first_data.substring(5,7))-1;
            int eguna = Integer.parseInt(first_data.substring(8,10));

            cal.set(urtea, hilabetea, eguna);
        }

        cal.add(Calendar.MONTH, add_month);  //Add two months to first data
        return dateFormat.format(cal.getTime());

    }

    public static String getCurrentDataWithAddSetBeforeDays (String first_data, int add_month)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        if (!first_data.equals("")) //add first_data in calendar object to correct asign in second data
        {
            int urtea = Integer.parseInt(first_data.substring(0, 4));
            int hilabetea = Integer.parseInt(first_data.substring(5,7))-1;
            int eguna = Integer.parseInt(first_data.substring(8,10));

            cal.set(urtea, hilabetea, eguna);
        }

        cal.add(Calendar.DAY_OF_WEEK, -(add_month));  //DownDays value to first data
        return dateFormat.format(cal.getTime());
    }

    public static Calendar getAllDataTimeCalendarObject (String date, String hour_string)
    {
        //Extract details data
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7))-1;
        int day = Integer.parseInt(date.substring(8,10));

        int [] hour_int = getHourMinutesSecondsInfo(hour_string);

        System.out.println(year+"/"+month+"/"+day+" "+hour_int[0]+":"+hour_int[1]+":"+hour_int[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour_int[0], hour_int[1], hour_int[2]);
        return calendar;
    }

    public static int [] getHourMinutesSecondsInfo (String hour_string)
    {
        String hour = hour_string.substring(0, 2);
        int hour_int;
        if (hour.charAt(0) == '0')
        {
            hour_int = Integer.parseInt(hour.substring(1));
        }
        else
        {
            hour_int = Integer.parseInt(hour);
        }

        int minute_int = Integer.parseInt(hour_string.substring(3, 5));
        return new int [] {hour_int,minute_int,0};
    }

    public static String [] setFormatData (int year, int monthOfYear, int dayOfMonth)
    {
        //year/month/day
        String [] format_data = new String [3];

        format_data[0] = String.valueOf(year);
        if (monthOfYear+1 < 10)
        {
            format_data [1] = "0"+String.valueOf(monthOfYear+1);
        }
        else
        {
            format_data [1] = String.valueOf(monthOfYear+1);
        }

        if (dayOfMonth<10)
        {
            format_data [2] = "0"+String.valueOf(dayOfMonth);
        }
        else
        {
            format_data [2] = String.valueOf(dayOfMonth);
        }
        return format_data;
    }
}
