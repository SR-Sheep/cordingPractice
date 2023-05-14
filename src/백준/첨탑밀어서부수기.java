package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/28014
public class 첨탑밀어서부수기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int curr = -1;
		int answer =0;
		for(int i=0;i<t;i++) {
			int next=Integer.parseInt(st.nextToken());
			if(curr<=next) answer++; //이전보다 작지 않으면 미는 횟수 증가
			curr = next;
		}
		System.out.println(answer);
		br.close();
	}
}
