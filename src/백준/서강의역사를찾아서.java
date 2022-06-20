package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서강의역사를찾아서 {
	//https://www.acmicpc.net/problem/25177
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //현재 시설 수
		int m=Integer.parseInt(st.nextToken()); //과거 시설 수
		
		int max = Math.max(n,m); //둘 중 최대값
		
		int[] befores = new int[max]; //과거 건물 점수 배열
		int[] nows = new int[max]; //현재 건물 점수 배열
		//현재 건물 점수 입력
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			nows[i]=Integer.parseInt(st.nextToken());
		}
		//과거 건물 점수 입력
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			befores[i]=Integer.parseInt(st.nextToken());
		}
		//점수 차 최대값 출력
		int answer = 0;
		for(int i=0;i<max;i++) {
			answer=Math.max(answer, befores[i]-nows[i]);
		}
		System.out.println(answer);
		br.close();
	}
}
