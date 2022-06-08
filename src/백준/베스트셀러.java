package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 베스트셀러 {
	//https://www.acmicpc.net/problem/1302
	
	static class Book implements Comparable<Book>{
		String book;
		int count;
		public Book(String book, int count) {
			this.book=book;
			this.count=count;
		}
		
		@Override
		public int compareTo(Book o) {
			if(o.count==this.count) {
				return this.book.compareTo(o.book);
			}else {
				return o.count - this.count;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0)+1);
		}
		PriorityQueue<Book> pq = new PriorityQueue<>();
		for(String key:map.keySet()) {
			pq.add(new Book(key, map.get(key)));
		}
		
		System.out.println(pq.poll().book);
		
		br.close();
	}
}
