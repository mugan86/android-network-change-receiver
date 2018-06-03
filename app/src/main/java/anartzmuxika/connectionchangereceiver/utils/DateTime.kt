package anartzmuxika.connectionchangereceiver.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/***********************************************
 * Created by Anartz Mugika on 22/3/14.
 * Updated in Kotlin: 20/01/2018
 ***********************************************/

object DateTime {


    val currentData: String
        get() {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val cal = Calendar.getInstance()
            return dateFormat.format(cal.time)

        }

    val currentDataCalendar: Calendar
        get() = Calendar.getInstance()


    val currentDataTime: String
        @SuppressLint("SimpleDateFormat")
        get() {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return dateFormat.format(Date())
        }

    val yesterdayData: String
        get() {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val cal = Calendar.getInstance()
            cal.add(Calendar.DAY_OF_YEAR, -1)
            return dateFormat.format(cal.time)
        }

    val firstDayNextYearAndLastDayBeforeYear: Array<String?>
        get() {
            val datas = arrayOfNulls<String>(2)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            var cal = Calendar.getInstance()
            cal.add(Calendar.YEAR, 1)
            cal.set(Calendar.DAY_OF_MONTH, 1)
            cal.set(Calendar.MONTH, 0)
            datas[0] = dateFormat.format(cal.time)
            cal = Calendar.getInstance()
            cal.add(Calendar.YEAR, -1)
            cal.set(Calendar.DAY_OF_MONTH, 31)
            cal.set(Calendar.MONTH, 11)
            datas[1] = dateFormat.format(cal.time)
            return datas
        }

    fun getCurrentDataWithAddSetMonthValue(first_data: String, add_month: Int): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val cal = Calendar.getInstance()
        if (first_data != "")
        //add first_data in calendar object to correct asign in second data
        {
            cal.set(Integer.parseInt(first_data.substring(0, 4)),
                    Integer.parseInt(first_data.substring(5, 7)) - 1,
                    Integer.parseInt(first_data.substring(8, 10)))
        }

        cal.add(Calendar.MONTH, add_month)  //Add two months to first data
        return dateFormat.format(cal.time)

    }

    fun getCurrentDataWithAddSetBeforeDays(first_data: String, addDays: Int): String {
        val cal = Calendar.getInstance()
        if (first_data != "")
        //add first_data in calendar object to correct asign in second data
        {

            cal.set(Integer.parseInt(first_data.substring(0, 4)),
                    Integer.parseInt(first_data.substring(5, 7)) - 1,
                    Integer.parseInt(first_data.substring(8, 10)))
        }

        cal.add(Calendar.DAY_OF_WEEK, -addDays)  //DownDays value to first data
        return SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(cal.time)
    }

    fun getAllDataTimeCalendarObject(date: String, hour_string: String): Calendar {
        //Extract details data
        val year = Integer.parseInt(date.substring(0, 4))
        val month = Integer.parseInt(date.substring(5, 7)) - 1
        val day = Integer.parseInt(date.substring(8, 10))

        val hour_int = getHourMinutesSecondsInfo(hour_string)

        println(year.toString() + "/" + month + "/" + day + " " + hour_int[0] + ":" + hour_int[1] + ":" + hour_int[2])
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour_int[0], hour_int[1], hour_int[2])
        return calendar
    }

    fun getHourMinutesSecondsInfo(hour_string: String): IntArray {
        val hour = hour_string.substring(0, 2)
        val hourInt: Int
        if (hour[0] == '0') {
            hourInt = Integer.parseInt(hour.substring(1))
        } else {
            hourInt = Integer.parseInt(hour)
        }

        val minInt = Integer.parseInt(hour_string.substring(3, 5))
        return intArrayOf(hourInt, minInt, 0)
    }

    fun setFormatData(year: Int, monthOfYear: Int, dayOfMonth: Int): Array<String?> {
        //year/month/day
        val formatData = arrayOfNulls<String>(3)

        formatData[0] = year.toString()
        if (monthOfYear + 1 < 10) {
            formatData[1] = "0" + (monthOfYear + 1).toString()
        } else {
            formatData[1] = (monthOfYear + 1).toString()
        }

        if (dayOfMonth < 10) {
            formatData[2] = "0" + dayOfMonth.toString()
        } else {
            formatData[2] = dayOfMonth.toString()
        }
        return formatData
    }
}
