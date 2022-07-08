package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 문자열집합 {
	//https://www.acmicpc.net/problem/14425
	static class Trie{
		
		Eng root = new Eng();
		
		public int charToInt(char c) {
			return c-'a';
		}
		
		
		public void setString(String s) {
			Eng parent = root;
			int no;
			for(char c:s.toCharArray()) {
				no=charToInt(c);
				if(parent.children[no]==null) {
					parent.children[no]=new Eng(c);
				}
				parent = parent.children[no];
			}
			parent.end=true;
		}
		
		public int isExist(String s) {
			Eng parent = root;
			int no;
			for(char c:s.toCharArray()) {
				no=charToInt(c);
				if(parent.children[no]==null) {
					return 0;
				}
				parent = parent.children[no];
			}
			return parent.end?1:0;
		}
		
		
	}
	
	static class Eng{
		char c;
		Eng[] children = new Eng[26];
		boolean end;
		
		public Eng() {
			
		}
		public Eng(char c) {
			this.c = c;
			this.end=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int answer = 0;
		
		Trie trie = new Trie();
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			trie.setString(s);
		}
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			answer+=trie.isExist(s);
		}
		System.out.println(answer);
		bw.close();
		br.close();
	}
}
