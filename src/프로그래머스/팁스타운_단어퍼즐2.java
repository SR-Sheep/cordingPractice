package 프로그래머스;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 팁스타운_단어퍼즐2 {
	//https://programmers.co.kr/learn/courses/30/lessons/12983
	//트리를 사용하려 풀려 했으나 시간초과
	
	static Alphabet[] Alpha;
	static int Answer; 
	static String Text;
	static final int INF = 987654321;
	
	static class Alphabet{
		char alphabet;
		boolean isEnd;
		Alphabet[] children;
		
		public Alphabet(char alphabet) {
			this.alphabet=alphabet;
			this.isEnd = false;
			children=new Alphabet[26];
		}
		
		public Alphabet addAndGetChild(char c) {
			int idx = c-'a';
			if(children[idx]==null) {
				children[idx]=new Alphabet(c);
			}
			return children[idx];
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
	}
	
	public static void dfs(int idx, int cost) {
		if(idx==Text.length()) {
			Answer = Math.min(Answer, cost);
			return;
		}
		
		int cIdx = Text.charAt(idx)-'a';
		Alphabet alphabet = Alpha[cIdx];
		idx++;
		while(alphabet!=null) {
			if(alphabet.isEnd) {
				dfs(idx,cost+1);
			}
			if(idx>=Text.length()) {
				break;
			}
			cIdx = Text.charAt(idx)-'a';
			alphabet=alphabet.children[cIdx];
			idx++;
		}
	}
	
    public static int solution(String[] strs, String t) {
        Alpha = new Alphabet[26];
        Text = t;
        Answer = INF;
        for(String str:strs) {
        	int cIdx = str.charAt(0)-'a';
        	if(Alpha[cIdx]==null) {
        		Alpha[cIdx]=new Alphabet(str.charAt(0));
        	}
        	Alphabet alphabet = Alpha[cIdx];
        	for(int i=1;i<str.length();i++) {
        		char c = str.charAt(i);
        		alphabet=alphabet.addAndGetChild(c);
        	}
        	alphabet.setEnd(true);
        }
        dfs(0,0);
        return Answer==INF?-1:Answer;
    }
    
    public static void main(String[] args) {
		String[] strs = {"ba","na","n","a"};
		String t = "banana";
		System.out.println(solution(strs, t));
		String[] strs2 = {"app","ap","p","l","e","ple","pp"};
		String t2 = "apple";
		System.out.println(solution(strs2, t2));
	}
}
