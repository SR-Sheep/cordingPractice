package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 에어컨 {
	//https://www.acmicpc.net/problem/25044
	
	//분을 hh:mm 형태로 변환하는 클래스
	static class AirTime{
		int min;
		public AirTime(int min) {
			this.min=min;
		}
		
		public String getHourAndMin() {
			return String.format("%02d:%02d",(min/60)%24,min%60);
		}
	}
	//일 -> 분
	public static int dayToMin(int day) {
		return day*24*60;
	}
	//분 -> 시
	public static int getHour(int min) {
		return min/60;
	}
	//분 -> min 단위만 가져옴
	public static int getMin(int min) {
		return min%60;
	}
	//문제 해결
	public static List<AirTime> airTimes(int day, int stopMin) {
		//종료 시간까지의 텀
		int[] stopTerms = {3*60, 3*60, 18*60 };
		List<AirTime> list = new ArrayList<>();
		//종료된 횟수 -1
		int count = 0;
		//첫 종료 시간, 0일 15:00
		int min = 15*60;
		//오늘의 날짜
		int today = dayToMin(day);
		//내일의 날짜
		int tomorrow = dayToMin(day+1);
		//종료 시간이 내일보다 작으면
		while(min<tomorrow) {
			//오늘의 종료시간이라면 추가
			if(min>=today) {
				list.add(new AirTime(min));
			}
			//다음 종료시간
			min+=stopTerms[count%3];
			//3번째 종료시간이라면 정지 시간 추가
			if(count%3==2) min+=stopMin;
			//횟수 증가
			count++;
		}
		//list 반환
		return list;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //일
		int k=Integer.parseInt(st.nextToken()); //시계가 멈춘 분
		//답 리스트
		List<AirTime> list = airTimes(n, k);
		//리스트 크기 = 답의 개수 
		bw.append(list.size()+"\n");
		//hh:mm 형태로 출력
		for(AirTime airTime : list) {
			bw.append(airTime.getHourAndMin()+"\n");
		}
		bw.close();
		br.close();
	}
}
