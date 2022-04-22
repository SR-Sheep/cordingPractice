package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 직사각형에서탈출 {
	
	//https://www.acmicpc.net/problem/1085
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); //한수의 x좌표
		int y = Integer.parseInt(st.nextToken()); //한수의 y좌표
		int w = Integer.parseInt(st.nextToken()); //직사각형 너비
		int h = Integer.parseInt(st.nextToken()); //직사각형 높이
		// 점 기준 3,6,9,12시 방향 비교
		int answer = Math.min(x, y); //x y 중 작은 값, (점 기준 9시, 6시 거리)
		answer=Math.min(answer, w-x); //w-x 와 비교 (3시 거리)
		answer=Math.min(answer, h-y); //h-y 와 비교 (12시 거리)
		//출력
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
