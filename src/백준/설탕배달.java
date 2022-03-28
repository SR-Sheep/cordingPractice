package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 설탕배달 {
	
	//https://www.acmicpc.net/problem/2839
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		answer=n/5; //5키로 봉지 사용
		n%=5; //5키로 봉지를 쓰고 남은 값
		boolean can = false;
		while(answer>=0) {
			if(n%3==0) { //3키로 봉지로 나눠 떨어진다면 답
				can=true;
				answer+=n/3; //답에 3키로 봉지 개수 더하기
				break; //종료
			}
			answer--; //5키로 1봉지 감소
			n+=5; //무게 5키로 증가
		}
//		for(int i=0;i<7;i++) {
//			if(answer<0) break; //답이 0보다 작다면 종료
//			if(n%3==0) { //3키로 봉지로 나눠 떨어진다면 답
//				can=true;
//				answer+=n/3; //답에 3키로 봉지 개수 더하기
//				break; //종료
//			}
//			answer--; //5키로 1봉지 감소
//			n+=5; //무게 5키로 증가
//		}
		if(!can) bw.append(-1+"\n");
		else bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
