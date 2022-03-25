package 백준;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 오늘날짜 {
	//https://www.acmicpc.net/problem/10699
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 9); //UTC +09:00
		System.out.println(cal.getTimeZone());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(cal.getTime()));
	}
}
