package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수6 {
	//https://www.acmicpc.net/problem/11444
	
	static final long DIV = 1000000007;
	//행렬 곱셈
	public static long[][] mutiplyMatrix(long[][] aMatrix,long[][] bMatrix){
		long[][] answer = new long[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					answer[i][j]+=((aMatrix[i][k]%DIV)*(bMatrix[k][j]%DIV))%DIV;
					answer[i][j]%=DIV;
				}
			}
		}
		return answer;
	}
	
	public static long[][] powMatrix(long[][] matrix, long n){
		if(n==1) return matrix;
		//행렬의 n/2 승 계산
		long[][] muti = powMatrix(matrix, n/2);
		//짝수일 경우 = a^(m/2) * a^(m/2)
		if(n%2==0) {
			return mutiplyMatrix(muti, muti);
			//홀수일 경우 = (a^(m/2) * a^(m/2)) * a	
		}else {
			return mutiplyMatrix(mutiplyMatrix(muti, muti), matrix);
		}
	}
	
	
	//분할 정복을 이용하여 제곱수 계산
	public static long solution(long n){
		//1일 경우 그대로 리턴
		if(n==1) {
			return 1;
		}
		long[][] matrix = {{0,1},{1,1}};
		//행렬 n-1승 처리
		n--;
		long[][] muti = powMatrix(matrix, n);
		//muti * {0,1} 의 [1]의 값 =muti[1][0]*0 + muti[1][1] = muti[1][1];
		return muti[1][1];
	}
	/*
	 * ( 0 1 ) (  Fn  )    ㅡ   ( Fn+1 )
	 * ( 1 1 ) ( Fn+1 )    ㅡ   ( Fn+2 )
	 */
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.println(solution(n));
		
	}
}
