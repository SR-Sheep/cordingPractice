package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 이항계수2 {
	//https://www.acmicpc.net/problem/11051
	public static long comb(int a, int b) {
		//이항계수 사다리를 이용 nCm = (n-1)Cm + (n-1)C(m-1)
		long[][] dp = new long[a+1][a+1];
		for(int i=1;i<=a;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0||j==i) dp[i][j]=1; //0Cx or xCx = 1
				else dp[i][j]=(dp[i-1][j]+dp[i-1][j-1])%10007;
			}
		}
		return dp[a][b];
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		//큰 수임으로 dp를 이용하여 해결
		bw.append(comb(a,b)+"\n");
		br.close();
		bw.close();
	}
}
