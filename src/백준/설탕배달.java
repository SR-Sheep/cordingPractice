package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 설탕배달 {
	
	//https://www.acmicpc.net/problem/2839
	//5, 3 용량의 봉지 최소한 갯수로 가져가기
	//봉지가 꽉 찰 수 없는 경우 -1 리턴
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		answer=n/5; //5개들이 봉지 이용
		n%=5; //나머지
		boolean can = false;
		for(int i=0;i<7;i++) {
			if(answer<0) break; //음수일시 중지
			if(n%3==0) { //3으로 나눠지면
				can=true;
				answer+=n/3; //몫만큼 답 증가
				break;
			}
			answer--; //5봉지를 깨서 나머지에 추가
			n+=5;
		}
		if(!can) bw.append(-1+"\n");
		else bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
