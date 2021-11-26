package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 달팽이는올라가고싶다 {
	
	//https://www.acmicpc.net/problem/2869
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int up = Integer.parseInt(st.nextToken()); //올라가기
		int down = Integer.parseInt(st.nextToken()); //미끄러지기
		int length = Integer.parseInt(st.nextToken()); //올라가야 하는 거리
		length-=up; //마지막 올라가기 빼기, 답 1 증가
		int diff = up-down; //차이
		int answer = (int)Math.ceil((double)length/(double)diff)+1; //길이 / 차이 + 1
		
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}

}
