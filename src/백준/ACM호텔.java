package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ACM호텔 {
	public static void main(String[] args) throws IOException {
		
		//https://www.acmicpc.net/problem/10250
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //올라가기
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken()); //층
			int width = Integer.parseInt(st.nextToken()); //방 수
			int num = Integer.parseInt(st.nextToken()); //번째
			
			int floor = num%height; //층수
			if(floor==0) floor = height; //나머지가 0이면 최상층
			bw.append(floor+"");
			bw.append(String.format("%02d", (int)Math.ceil((double)num/(double)height))+"\n");
		}
		br.close();
		bw.close();
	}
}
