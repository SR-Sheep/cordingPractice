package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2239
public class 스도쿠2 {
   static int[][] Board;
   static boolean isAnswer = false;
   static StringBuilder Sb = new StringBuilder();
   
   //r, c의 값 찾기
   public static boolean isSudokuNumber(int r, int c) {
      int[] w = new int[10]; //0-9 가로 (width)
      int[] h = new int[10]; //0-9 세로 (height)
      int[] s = new int[10]; //0-9 네모 (square)
      int idx = -1;
      //1 가로줄
      for(int i=0;i<9;i++) {
         idx = Board[r][i];
         if(idx!=0&&++w[idx]>1) return false;
      }
      //2 세로줄
      for(int i=0;i<9;i++) {
         idx = Board[i][c];
         if(idx!=0&&++h[idx]>1) return false;
      }
      //3 사각형
      int startR = r/3 * 3;
      int startC = c/3 * 3;
      for(int i=0;i<3;i++) {
         for(int j=0;j<3;j++) {
            idx = Board[startR+i][startC+j];
            if(idx!=0&&++s[idx]>1) return false;
         }
      }
      return true;
   }
   
   public static void setSudoku(int r, int c) {
      if(isAnswer) return;
      if(c>8) {
         r++;
         c=0;
      }
      if(r>8) {
         isAnswer = true;
         Sb.append(printBoard());
         return;
      }
      int num=Board[r][c];
      if(num==0) {
         for(int i=1;i<=9;i++) {
            Board[r][c]=i;
            if(isSudokuNumber(r, c)) {
               setSudoku(r, c+1);
            }
            if(isAnswer) return;
            Board[r][c]=0;
         }
      }else {
         setSudoku(r, c+1);
      }
   }
   
   public static String printBoard() {
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<9;i++) {
         for(int j=0;j<9;j++) {
            sb.append(Board[i][j]);
         }
         sb.append("\n");
      }
      return sb.toString();
   }
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Board = new int[9][9];
      for(int i=0;i<9;i++) {
         char[] line = br.readLine().toCharArray();
         for(int j=0;j<9;j++) {
            Board[i][j]= Integer.parseInt(line[j]+"");
         }
      }
      setSudoku(0,0);
      System.out.println(Sb.toString());
      br.close();
   }
}