package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가지교배 {
   //https://www.acmicpc.net/problem/27939
   /*
    * 조교가 준 가지 중 한개라도 흰 가지가 있다면 흰가지 조합 가능 
    * 조교의 교배는 한개라도 보라가지가 있다면 최종적으로 보라가지가 생성
    * 따라서 분배된 조교의 가지가 모두 흰색인 경우가 있다면 흰가지 조합 가능
    */
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      boolean[] plants = new boolean[n+1]; //가지 품종 배열
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=1;i<=n;i++) {
         if('W'==st.nextToken().charAt(0)) {
            plants[i]=true; //흰색이면 true
         };
      }
      boolean answer = false;
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken()); //조교 수
      int k = Integer.parseInt(st.nextToken()); //조교에게 할당된 가지 수
      for(int i=0;i<m;i++) {
         st = new StringTokenizer(br.readLine());
         boolean allWhite = true; //조교에게 준 가지가 모두 흰색인지 판별
         for(int j=0;j<k;j++) {
            int idx = Integer.parseInt(st.nextToken());
            allWhite&=plants[idx]; //주어진 가지가 모두 W라면 true
         }
         //모두 흰가지라면 가능, 반복문 종료
         if(allWhite) {
            answer = true;
            break;
         }
      }
      System.out.println(answer?"W":"P");
      br.close();
   }
}