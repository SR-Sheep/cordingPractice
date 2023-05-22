package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class IAmKnowledge {
   
   static class Book{
      long cost,benefit;
      public Book(long cost, long benefit) {
         this.cost=cost;
         this.benefit= benefit;
      }
      
      public long getGap() {
         return benefit-cost;
      }
      
      @Override
      public String toString() {
         return cost+" "+benefit;
      }

   }
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      
      //cost 가 적은 순
      PriorityQueue<Book> benefitPq = new PriorityQueue<Book>((o1,o2)->{
         if(o1.cost>o2.cost) return 1;
         if(o2.cost>o1.cost) return -1;
         return 0;
      });
      //gap이 작은 순
      PriorityQueue<Book> costPq = new PriorityQueue<Book>((o1,o2)->{
         long gap1 = o1.getGap(); 
         long gap2 = o2.getGap(); 
         if(gap1<gap2) return 1;
         if(gap2<gap1) return -1;
         return 0;
      });
      StringTokenizer st;
      for(int i=0;i<n;i++) {
         st = new StringTokenizer(br.readLine());
         long cost = Long.parseLong(st.nextToken());
         long benetfit = Long.parseLong(st.nextToken());
         
         Book book = new Book(cost,benetfit);
         if(benetfit-cost>0) benefitPq.add(book);
         else costPq.add(book);
      }
      int joy = 0;
      boolean canComplete = true;
      while(!benefitPq.isEmpty()) {
         Book book = benefitPq.poll();
         if(joy<book.cost) {
            canComplete = false;
            break;
         }
         joy+=book.getGap();
      }
      if(canComplete) {
         while(!costPq.isEmpty()) {
            Book book = costPq.poll();
            if(joy<book.cost) {
               canComplete = false;
               break;
            }
            joy+=book.getGap();
         }
         if(joy<0) canComplete =false; 
      }
      System.out.println(canComplete?"1":"0");
      br.close();
   }
}