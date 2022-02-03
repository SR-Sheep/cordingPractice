package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 또전자레인지야 {
	//https://www.acmicpc.net/problem/24390
	//시간을 초로 전환
	public static int timeTosec(String t) {
		String[] tmp = t.split(":");
		return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
	}
	
	
	public static int pushButton(int sec) {
		boolean isStart =false;
		int answer = 0;
		//10분, 1분, 30초, 10초 -> 그리디 알고리즘
		//10분
		answer+=sec/600;
		sec%=600;
		//1분
		answer+=sec/60;
		sec%=60;
		//30초, 스타트 버튼임으로 해당 버튼을 꼭 눌러야 함
		if(sec/30!=0) {
			answer+=sec/30;
			isStart=true;
		}
		sec%=30;
		//10초
		answer+=sec/10;
		//리턴, 시작버튼을 누르면 그대로 출력, 아닌 경우에는 스타트 버튼 누르기(1회 추가)
		return isStart?answer:++answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sec = timeTosec(br.readLine());
		System.out.println(pushButton(sec));
		br.close();
	}
}
