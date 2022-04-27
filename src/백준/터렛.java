package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 터렛 {
	//https://www.acmicpc.net/problem/1002
	//원 2개의 접점을 구하는 문제
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
			
			int l = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2); //두 원의 중심간의 거리 제곱
			int r = (r1+r2)*(r1+r2); //두 원의 반지름의 합 제곱
			int d = (r1-r2)*(r1-r2); //두 원의 반지름 차의 제곱
			//두 중심이 떨어져 있다면
			if(l>0) {
				//거리가 합보다 큰 경우, 접점 없음
				if(l>r) answer=0;
				//거리가 차보다 작은 경우, 만나지 않고 내부에 원이 있음
				else if(l<d) answer = 0;
				//거리와 합이 같은 경우 외접
				else if(r==l) answer = 1;
				//거리와 차가 같은 경우 내접
				else if(d==l) answer = 1;
				//나머지의 경우 원이 두개의 접점을 가짐
				else answer = 2;
			//두 중심이 같고, 반지름도 같다면 모든점이 겹침	
			}else if(r1==r2){ 
				answer=-1;
			//두 중심이 같고, 반지름이 다르면 접점 없음
			}else {
				answer = 0;
			}
			bw.append(answer+"\n");
		}
		br.close();
		bw.close();
	}
}
