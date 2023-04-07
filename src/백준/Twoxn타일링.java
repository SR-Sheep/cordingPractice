package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Twoxn타일링 {
	//https://www.acmicpc.net/problem/11726
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] board = new int[n+1];
      final int DIV = 10007;
      board[1]=1;
      if(n>1) board[2]=2;
      for(int i=3;i<=n;i++) {
         board[i] = (board[i-1]+board[i-2])%DIV;
      }
      System.out.println(board[n]);
      br.close();
   }
}