package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/28068
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
      //1.cost가 적고, 2.이득이 큰 순
      PriorityQueue<Book> costPq = new PriorityQueue<Book>((o1,o2)->{
		 if(o1.cost>o2.cost) return 1;
		 if(o2.cost>o1.cost) return -1;
         if(o1.benefit<o2.benefit) return 1;
         if(o1.benefit>o2.benefit) return 1;
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
      
      while(!costPq.isEmpty()) {
    	  Book book = costPq.poll();
    	  System.out.println("소모할 책"+book);
    	  while(!benefitPq.isEmpty()&&book.cost>joy) {
    		  Book benefitBook = benefitPq.poll();
    		  System.out.println("얻을 책"+benefitBook);
    		  if(benefitBook.cost>joy) {
    			  break;
    		  }else {
    			  joy+=benefitBook.getGap();
    		  }
    	  }
    	  System.out.println(joy);
    	  if(book.cost>joy) {
    		  break;
    	  }else {
    		  joy+=book.getGap();
    	  }
      }
      //남은 큐들 검사
      while(!benefitPq.isEmpty()) {
         Book book = benefitPq.poll();
         if(joy<book.cost) {
            canComplete = false;
            break;
         }
         joy+=book.getGap();
      }
      if(!costPq.isEmpty()) canComplete = false;
      System.out.println(canComplete?"1":"0");
      br.close();
   }
}