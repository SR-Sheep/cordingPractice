package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/16565
public class N포커 {
   
   static final int MOD = 10007;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      //파스칼 삼각형 생성
      int[][] dp = new int[53][53];
      for(int i=0;i<=52;i++) {
         for(int j=0;j<=i;j++) {
            dp[i][j]=(j==0||j==i)?1:(dp[i-1][j-1]+dp[i-1][j])%MOD;
         }
      }
      
      for(int j=1;j<53;j++) {
         int answer = 0;
         int times = 1;
         n=j;
         //1) n장 카드 중 4장을 뽑을 숫자 = 13C(n/4)
         //2) 나머지 카드 중 뽑을 숫자 (52-(n/4)*4)C(n%4);
         //3) 결론 = 13C(n/4) * (52 - (n/4) * 4)C(n%4);
         //4) 상호배제 : 1장 -2장 + 3장 ...
         for(int i=4;i<=n;i+=4) {
            answer += (dp[13][i/4]*dp[52-i][n-i])*times;
            times*=-1;
            while(answer<0) answer+=MOD; //음수 보정
            answer%=MOD;
         }
         System.out.println(n+" : "+answer);
      }
      br.close();
   }
}