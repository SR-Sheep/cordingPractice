package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치함수 {
	//https://www.acmicpc.net/problem/1003
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //테스트 케이스 수
		int[] cases = new int[n]; //테스트 케이스 값 저장
		//테스트케이스 중 최대값
		int max = 0;
		for(int i=0;i<n;i++) {
			cases[i]=Integer.parseInt(br.readLine());
			max=Math.max(max, cases[i]);
		}
		//최대값만큼 피보나치 배열 생성, {0 호출 수, 1 호출수}
		int[][] fibonacci = new int[max+1][2];
		//0일때 0 한번 호출
		fibonacci[0][0] = 1;
		//1일때 1 한번 호출
		fibonacci[1][1] = 1;
		for(int i=2;i<max+1;i++) {
			//0과 1 모두 업데이트
			for(int j=0;j<2;j++) {
				//피보나치 정의 = 이전 피보나치 + 이전전 피보나치
				fibonacci[i][j]=fibonacci[i-1][j]+fibonacci[i-2][j];
			}
		}
		//각 케이스의 0과 1의 호출수 출력
		for(int i:cases) {
			bw.append(fibonacci[i][0]+" "+fibonacci[i][1]+"\n");
		}
		
		br.close();
		bw.close();
	}
}
