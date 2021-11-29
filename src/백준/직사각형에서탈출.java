package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 직사각형에서탈출 {
	
	//https://www.acmicpc.net/problem/1085
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int answer = Math.min(x, y); //x y 중 작은것을 취함(점의 왼쪽, 아래쪽 값)
		answer=Math.min(answer, w-x); //w-x와 비교(점의 오른쪽 비교)
		answer=Math.min(answer, h-y); //h-y와 비교(점의 위쪽 비교)
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
