package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 달팽이는올라가고싶다 {
	
	//https://www.acmicpc.net/problem/2869
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int up = Integer.parseInt(st.nextToken()); //올라감
		int down = Integer.parseInt(st.nextToken()); //떨어짐
		int length = Integer.parseInt(st.nextToken()); //막대기 길이
		length-=up; //일단 한번 올라가고 남은 거리
		int diff = up-down; //차이
		int answer = (int)Math.ceil((double)length/(double)diff)+1; // (남은 길이 / 차이)를 올림한 값 +1
		
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}

}
