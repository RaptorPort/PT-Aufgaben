package PT_2;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class monthSummary {

	public static void main(String[] args) {
		 

		 // create a GregorianCalendar with current time zone
		 // and the current date and time
		 Locale aLocale = new Locale("USA");
		 Calendar calendar = new GregorianCalendar(TimeZone.getDefault(), aLocale );
		 Date trialTime = new Date();
		 calendar.setTime(trialTime);
		 //calendar.set(2016, 13 , 2);
		
		 System.out.println("MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		 System.out.println("DAYS_IN_MONTH " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		 
		 //System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		 //System.out.println("WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		 //System.out.println("FIRST_DAY_OF_WEEK: " + calendar.getFirstDayOfWeek());
		 /*
		 System.out.println("DAY_OF_MONDAY: " + Calendar.MONDAY);
		 System.out.println("DAY_OF_TUESDAY: " + Calendar.TUESDAY);
		 System.out.println("DAY_OF_WEDNESDAY: " + Calendar.WEDNESDAY);
		 System.out.println("DAY_OF_THURSDAY: " + Calendar.THURSDAY);
		 System.out.println("DAY_OF_FRIDAY: " + Calendar.FRIDAY);
		 System.out.println("DAY_OF_SATURDAY: " + Calendar.SATURDAY);
		 System.out.println("DAY_OF_SUNDAY: " + Calendar.SUNDAY);
		 */
		 
		 for (int w = 1, t = 2 - calendar.get(Calendar.DAY_OF_WEEK) + calendar.getFirstDayOfWeek(); t <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); w++) {
			 for (int i = 1; i <= 7; i++, t++) {
				 if (calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek() <= i || w != 1) {
					 if (t <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH) )
						 if (calendar.get(Calendar.DAY_OF_MONTH) == t)
							 System.out.print(t + "*\t");
						 else
							 System.out.print(t + "\t");
			 	} else {
			 		System.out.print("\t");
			 	}
			 }
			 System.out.println(); 
		 }
		 
	}

}
