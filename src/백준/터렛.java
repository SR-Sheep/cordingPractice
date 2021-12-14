package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 터렛 {
	//https://www.acmicpc.net/problem/1002
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int x1,x2,y1,y2,r1,r2;
		int answer = -1;
		for(int o=0;o<n;o++) {
			st=new StringTokenizer(br.readLine());
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			r1=Integer.parseInt(st.nextToken());
			
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			r2=Integer.parseInt(st.nextToken());
			
			int l = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2); //중점간의 거리 제곱
			int r = (r1+r2)*(r1+r2); //길이 합의 제곱
			int d = (r1-r2)*(r1-r2); //길이 차의 제곱
			if(l>0) {
				//반지름 합 길이가 중점 거리보다 작으면 답 없음
				if(l>r) answer=0;
				//반지름 차 길이가 중점 거리보다 크면 답 없음
				else if(l<d) answer = 0;
				//반지름의 합 길이와 줌점 거리 길이가 같을 때(외접)
				else if(r==l) answer = 1;
				//반지름의 차 길이와 중점 거리 길이가 같을 때(내접)
				else if(d==l) answer = 1;
				//나머지는 2개씩
				else answer = 2;
			}else if(r1==r2){ //중점이 같고, 반지름도 같으면 무한대
				answer=-1;
			}else {
				//중점이 같으나 반지름이 다르면 0
				answer = 0;
			}
			bw.append(answer+"\n");
		}
		br.close();
		bw.close();
	}
}
