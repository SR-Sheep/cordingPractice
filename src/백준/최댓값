package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최댓값 {
	//https://www.acmicpc.net/problem/2566
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = -1; //최대값
		int[] answer = new int[2];
		for(int i=0;i<9;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int n=Integer.parseInt(st.nextToken()); //숫자
				//최대값이면
				if(n>max) {
					max = n; //최대값 업데이트
					answer[0]=i; //행 값
					answer[1]=j; //열 값
				}
			}
		}
		System.out.println(max); //최대값 출력
		//행 열 값 출력, 0부터 시작함으로 1을 더하여 보정
		System.out.println(++answer[0]+" "+ ++answer[1]);
		//출력
		br.close();
	}
}
