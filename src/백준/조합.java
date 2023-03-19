package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 조합 {
	//https://www.acmicpc.net/problem/2407
	static BigInteger[][] Board;
	//파스칼 삼각형 세팅, 매우 큰 수이기에 bigInteger 이용
	public static void setCombination(int n) {
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j||j==0) {
					Board[i][j] = new BigInteger("1");
				}else {
					Board[i][j]=Board[i-1][j].add(Board[i-1][j-1]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//파스칼 삼각형 세팅
		Board = new BigInteger[101][101];
		setCombination(n);
		//출력
		System.out.println(Board[n][m]);
		br.close();
	}
}
