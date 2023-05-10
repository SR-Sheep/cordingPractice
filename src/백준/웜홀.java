package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1865
public class 웜홀 {
   
   static int N;
   static int[] Dists; //거리
   static final int INF = 987654321;
   
   static class Edge{
      int e,cost;
      public Edge(int e, int cost) {
         this.e=e;
         this.cost=cost;
      }
   }
   
   public static boolean bellmanFord(List<Edge>[] list) {
      Dists= new int[N+1];
      int start = 1;
      for(int j=1;j<=N;j++) Dists[j]=INF; //거리 초기화
      Dists[start]=0;
      int t = N-1; //반복횟수
      while(t-- >0) {
         for(int j=1;j<=N;j++) {
            for(Edge edge :list[j]) {
            	//거리 업데이트
               if(Dists[j]+edge.cost<Dists[edge.e]) {
                  Dists[edge.e]=Dists[j]+edge.cost;
               }
            }
         }
      }
      //벨만포드 탐색 후에도 감소한다면 false
      for(int j=1;j<=N;j++) {
         for(Edge edge :list[j]) {
            if(Dists[j]+edge.cost<Dists[edge.e]) {
               return false;
            }
         }
      }
      return true;
   }
   
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;
      while(t-- >0) {
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         int m = Integer.parseInt(st.nextToken());
         int w = Integer.parseInt(st.nextToken());
         
         int s = -1, e=-1, cost = -1;
         
         List<Edge>[] list = new List[N+1];
         for(int i=1;i<=N;i++) {
            list[i]= new ArrayList<>();
         }
         while(m-- >0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, cost));
            list[e].add(new Edge(s, cost));
         }
         while(w-- >0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken()); //웜홀은 가중치 음수
            list[s].add(new Edge(e, -cost));
         }
         sb.append(bellmanFord(list)?"NO\n":"YES\n");
      }
      System.out.println(sb);
      br.close();
   }
}