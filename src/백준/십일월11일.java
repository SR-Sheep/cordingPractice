package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class 십일월11일 {
	//https://www.acmicpc.net/problem/25286
	
	public static String getDateBeforeMDay(int year, int m) {
		LocalDate ld = LocalDate.of(year, m, m);
		LocalDate day=ld.minusDays(m);
		return day.getYear()+" "+day.getMonthValue()+" "+day.getDayOfMonth();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int year=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			bw.append(getDateBeforeMDay(year, m)+"\n");
		}
		bw.close();
		br.close();
	}
}
