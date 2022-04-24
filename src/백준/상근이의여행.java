package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 상근이의여행 {
	//https://www.acmicpc.net/problem/9372
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int n = -1; //국가 수
		int m = -1; //비행기 종류 수
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken()); //국가수
			m=Integer.parseInt(st.nextToken()); //테스트케이스 수
			
			//연결 리스트 정보는 필요없음으로 패쓰한다.
			while(m-->0) {
				br.readLine();
			};
			
			//연결 그래프의 최소 간선 수
			// = 트리의 간선 수
			// = n-1 
			bw.append((n-1) + "\n");
		}
		bw.close();
		br.close();
	}
}
