package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/28017
public class 게임을클리어하자 {

   static final int INF = 10001;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); //회차수
      int m = Integer.parseInt(st.nextToken()); //무기수
      int[][] board = new int[n+1][m];
      
      int sum1 = 0;
      int sum2 = 0;
      int sumIdx1 = -1;
      int sumIdx2 = -1;
      
      for(int i=1;i<=n;i++) {
         st = new StringTokenizer(br.readLine());
         int min1 = INF; //최소
         int min2 = INF; //차소
         int minIdx1 = -1; //최소 idx
         int minIdx2 = -1; //차소 idx
         for(int j=0;j<m;j++) {
            int time =Integer.parseInt(st.nextToken()); //무기수
            board[i][j] = time;
            if(min1>time) {
               min2 = min1;
               min1 = time;
               minIdx2 = minIdx1;
               minIdx1 = j;
            }else if(min2>time) {
               min2 = time;
               minIdx2 = j;
            }
         }
         int tmpSum1 = 0;
         int tmpSum2 = 0;
         if(sumIdx1!=minIdx1&&sumIdx2!=minIdx1) {
            tmpSum1 = Math.min(sum1, sum2);
         }else if(sumIdx1==minIdx1) {
            tmpSum1 = sum2;
         }else {
            tmpSum1 = sum1;
         }
         tmpSum1 +=min1;
         
         if(sumIdx1!=minIdx2&&sumIdx2!=minIdx2) {
            tmpSum2 = Math.min(sum1, sum2);
         }else if(sumIdx1==minIdx2) {
            tmpSum2 = sum2;
         }else {
            tmpSum2 = sum1;
         }
         tmpSum2 +=min2;
         
         sum1=tmpSum1;
         sumIdx1 = minIdx1;
         sum2=tmpSum2;
         sumIdx2 = minIdx2;
      }
      
      System.out.println((int)Math.min(sum1, sum2));
      
      br.close();
   }
}