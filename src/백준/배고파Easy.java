package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/28239
public class 배고파Easy {
   
   static long[] PowBoard;
   
   public static void setPowBoard() {
      PowBoard = new long[61];
      PowBoard[0]=1;
      PowBoard[1]=2;
      for(int i=2;i<61;i++) {
         //짝수
         if(i%2==0) {
            PowBoard[i]=PowBoard[i/2]*PowBoard[i/2];
         //홀수
         }else {
            PowBoard[i]=PowBoard[i/2 + 1]*PowBoard[i/2];
         }
      }
   }
   
   public static long[] findAnswer(long m) {
      int idx = 0;
      long remainder = -1;
      
      //이분탐색
      int left = 0;
      int right = 60;
      int mid = -1;
      
      while(left<=right) {
         mid = (left + right)/2;
         if(m >= PowBoard[mid]) {
            idx = mid;
            left = mid+1;
         }else {
            right = mid -1;
         }
      }
      remainder = m - PowBoard[idx];
      return new long[] {idx, remainder};
   }
   
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      setPowBoard();
      
      int n = Integer.parseInt(br.readLine());
      while(n-- >0) {
         long m = Long.parseLong(br.readLine());
         long[] fristArr = findAnswer(m);
         //나머지가 0인 경우 보정
         if(fristArr[1]==0) {
            bw.append((fristArr[0] -1)+" "+(fristArr[0] -1)+"\n");
         }else {
            long[] secondArr = findAnswer(fristArr[1]);
            bw.append(secondArr[0]+" "+fristArr[0]+"\n");
         }
         
      }
      br.close();
      bw.close();
   }
}