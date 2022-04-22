package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진짜공간 {
	//https://www.acmicpc.net/problem/1350
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] files = new int[t];
		//파일의 크기
		for(int i=0;i<t;i++) {
			files[i]=Integer.parseInt(st.nextToken());
		}
		//클러스터 크기
		int cluster = Integer.parseInt(br.readLine());
		//실행 횟수 누적
		long sum = 0;
		for(int f:files) {
			//(파일크기/클러스터용량)을 올림한 누적값 
			sum+=(long)Math.ceil((double)f/(double)cluster);
		}
		//클러스터 실행 횟수 * 클러스터 용량
		sum*=cluster;
		//출력
		System.out.println(sum);
		br.close();
	}
}
