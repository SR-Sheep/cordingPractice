package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 행렬제곱 {
	//https://www.acmicpc.net/problem/10830
	
	static int N;
	static final long DIV = 1000;
	//행렬 곱셈
	public static long[][] mutiplyMatrix(long[][] aMatrix,long[][] bMatrix){
		long[][] answer = new long[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					answer[i][j]+=((aMatrix[i][k]%DIV)*(bMatrix[k][j]%DIV))%DIV;
					answer[i][j]%=DIV;
				}
			}
		}
		return answer;
	}
	//분할 정복을 이용하여 제곱수 계산
	public static long[][] solution(long[][] board, long m){
		//1일 경우 그대로 리턴
		if(m==1) {
			return board;
		}
		//행렬의 m/2 승 계산
		long[][] muti = solution(board, m/2);
		//짝수일 경우 = a^(m/2) * a^(m/2)
		if(m%2==0) {
			return mutiplyMatrix(muti, muti);
		//홀수일 경우 = (a^(m/2) * a^(m/2)) * a	
		}else {
			return mutiplyMatrix(mutiplyMatrix(muti, muti), board);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //행렬의 길이
		long m=Long.parseLong(st.nextToken()); //거듭 제곱 수
		
		long[][] board = new long[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j]=(Long.parseLong(st.nextToken()))%DIV;
			}
		}
		//계산 결과 출력
		for(long[] arr:solution(board, m)) {
			for(long l:arr) {
				bw.append(l+" ");
			}
			bw.append("\n");
		}
		
		br.close();
		bw.close();
	}
}
