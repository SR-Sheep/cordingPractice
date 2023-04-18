package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
   //https://www.acmicpc.net/problem/2467
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] board = new int[n];
      for(int i=0;i<n;i++) {
         board[i]=Integer.parseInt(st.nextToken());
      }
      //투포인터
      int left = 0;
      int right = n-1;
      int sum = -1;
      
      int minSum = 2000000000; //최대값 (10억 + 10억)
      
      int leftIdx = left;
      int rightIdx = right;
      
      while(left<right) {
         sum = board[left]+board[right];
         //최소값
         if(Math.abs(sum)<Math.abs(minSum)) {
            minSum=sum;
            leftIdx = left;
            rightIdx = right;
         }
         //0이면 종료
         if(sum==0) {
            break;
         //음수면 최소값 증가
         } else if(sum<0) {
            left++;
         //양수면 최대값 감소
         }else {
            right--;
         }
      }
      System.out.println(board[leftIdx]+" "+board[rightIdx]);
      
      br.close();
   }
}