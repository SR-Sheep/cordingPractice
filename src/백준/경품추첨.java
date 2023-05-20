package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/28016
public class 경품추첨 {
   static int N,M;
   static int[][] Board;
   
   public static int dp(int r, int c) {
      double[][] dp = new double[N+1][M+2];
      double max = -1d;
      dp[r][c]=1d;
      //처음 행 패쓰(1부터 시작)
      for(int i=2;i<=N;i++) {
         for(int j=1;j<=M;j++) {
            //내 위치가 0 이고, 윗쪽이 1이 아니라면
            if(Board[i][j]==0&&Board[i-1][j]!=1) {
               dp[i][j]+=dp[i-1][j]; //100% 확률로 위에서 내려옴
               //왼쪽이 못이고, 왼쪽 위가 못이 아니라면
               if(Board[i][j-1]==1&&Board[i-1][j-1]!=1) dp[i][j]+=dp[i-1][j-1]/2; //50% 확률로 왼쪽
               //오른쪽이 못이고, 오른쪽 위가 못이 아니라면
               if(Board[i][j+1]==1&&Board[i-1][j+1]!=1) dp[i][j]+=dp[i-1][j+1]/2; //50% 확률로 오른쪽
            }
            //마지막 행이라면 최대값 추출
            if(i==N) max = Math.max(max,dp[i][j]);
         }
      }
      int answer = -1;
      if(max>0) {
         //적은 숫자부터 탐색
         for(int i=1;i<=M;i++) {
            //최대값과 동일하다면
            if(max==dp[N][i]) {
               answer = i-1; //답선택, 0부터 시작함으로 1을 빼서 보정
               break;
            }
         }
      }
      return answer;
   }
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      Board = new int[N+1][M+2];
      int r=-1, c=-1;
      for(int i=1;i<=N;i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=1;j<=M;j++) {
            Board[i][j]=Integer.parseInt(st.nextToken());
            if(Board[i][j]==2) {
               r=i;
               c=j;
            }
         }
      }
      System.out.println(dp(r, c));
      br.close();
   }
}