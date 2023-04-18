package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2473
public class 세용액 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      long[] board = new long[n];
      for(int i=0;i<n;i++) {
         board[i]=Long.parseLong(st.nextToken());
      }
      Arrays.sort(board); //정렬
      //투포인터
      int left = 0;
      int right = n-1;
      long sum = -1;
      long minSum = 3000000000l; //최대값 (10억 + 10억 + 10억)
      long min =0, mid=0, max =0;
      //가장 왼쪽 고정
      for(int i=0;i<n-2;i++) {
    	  left = i+1;
    	  right = n-1;
    	  if(minSum==0) break;
    	  while(left<right) {
	         sum = board[left]+board[right]+board[i];
	         //최소값
	         if(Math.abs(sum)<Math.abs(minSum)) {
	            minSum=sum;
	            min = board[i];
	            mid = board[left];
	            max = board[right];
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
      }
      System.out.println(min+" "+mid+" "+max);
      br.close();
   }
}