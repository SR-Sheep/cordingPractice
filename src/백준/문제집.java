package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1766
public class 문제집 {
   
   static int N; //문제 개수
   static List<Integer>[] Quesetions; // [x].{뒤에 존재해야하는 문제들}
   static int[] Degrees; //위상 정보 추가
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      Quesetions = new List[N+1];
      
      for(int i=1;i<=N;i++) {
         Quesetions[i] = new ArrayList<Integer>();
      }
      Degrees= new int[N+1];
      for(int i=0;i<m;i++) {
         st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         Quesetions[a].add(b); //a 보다 뒤에 위치해야 하는 b 목록
         Degrees[b]++; //뒤에 위치해야 하면 위상 증가
      }
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      for(int i=1;i<=N;i++) {
         if(Degrees[i]==0) {
            pq.add(i); //위상이 0이면 우선순위 큐에 삽입
         }
      }
      while(!pq.isEmpty()) {
         int curr = pq.poll();
         bw.append(curr+" "); //위상이 0인 작은 수 순서대로 출력
         for(int x:Quesetions[curr]) {
            Degrees[x]--; //현재 출력한 숫자 뒤에 위치한 숫자들 위상 감소
            if(Degrees[x]==0) { //뒤에 위치한 숫자의 위상이 0이라면
               pq.add(x); //우선순위 큐에 추가, 위상이 0인 숫자끼리 재정렬
            }
         }
      }
      bw.close();
      br.close();
   }
}