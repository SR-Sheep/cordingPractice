package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/20920
public class 영단어암기는괴로워 {
	//word 클래스
	static class Word implements Comparable<Word>{
		String word;
		int count;
		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}
		//정렬
		@Override
		public int compareTo(Word o) {
			//1 자주 나오는 단어
			if(this.count!=o.count) {
				return o.count - this.count;
			//2 단어 길이
			}else if(this.word.length()!=o.word.length()) {
				return o.word.length() - this.word.length();
			//3 사전순
			}else {
				return this.word.compareTo(o.word);
			}
		}
		//출력
		@Override
		public String toString() {
			return this.word;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		Map<String,Integer> map = new HashMap<>();
		while(n-- >0) {
			String word = br.readLine();
			if(word.length()>=m) {
				map.put(word, map.getOrDefault(word, 0)+1); //map에 개수 증가
			}
		}
		//우선순위 큐 이용
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for(String key:map.keySet()) {
			pq.add(new Word(key,map.get(key)));
		}
		//출력
		while(!pq.isEmpty()) {
			bw.append(pq.poll()+"\n");
		}
		bw.close();
		br.close();
	}
}
