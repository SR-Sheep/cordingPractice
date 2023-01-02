package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개수세기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] countArr = new int[201]; //-100 ~ 100 까지, 숫자 보정
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			num+=100; //-100을 0으로 보정
			countArr[num]++; //보정된 숫자 증가
		}
		int v = Integer.parseInt(br.readLine()); //문제
		System.out.println(countArr[v+100]); //문제 숫자 횟수 출력
	}
}
