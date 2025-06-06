package 프로그래머스;

import java.util.*;

public class 카카오_가사검색 {
	static class Trie{
		private Trie[] child= new Trie[26];
		private int count;
		
		public void insert(String str) {
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				curr.count++;
				int idx = ch-'a';
				if(curr.child[idx]==null) {
					curr.child[idx]=new Trie();
				}
				curr=curr.child[idx];
			}
			
			curr.count++;
		}
		
		public int search(String str) {
			Trie curr=this;
			for(char ch: str.toCharArray()) {
				if(ch=='?') return curr.count;
				curr=curr.child[ch-'a'];
				if(curr==null) return 0;
			}
			
			return -1;
		}
		
	}
	
	//단어 최대 길이 10000
	static Trie[] TrieRoot = new Trie[10000];
	static Trie[] ReTrieRoot = new Trie[10000];
	
	
	public static int[] solution1(String[] words,String[] queries) {
		int[] answer= new int[queries.length];
		int ansIdx=0;
		
		//단어 입력
		for(String word:words) {
			//단어의 길이로 idx
			int idx = word.length()-1;
			//최초 접근시, 객체 선언
			if(TrieRoot[idx]==null) {
				TrieRoot[idx]=new Trie();
				ReTrieRoot[idx]=new Trie();
			}
			//선방향에 단어 삽입
			TrieRoot[idx].insert(word);
			//역방향에 거꾸로 단어 삽입
			ReTrieRoot[idx].insert(new StringBuilder(word).reverse().toString());
		}
		//쿼리 찾기
		for(String query:queries) {
			//쿼리의 길이로 idx
			int idx= query.length()-1;
			//쿼리의 길이를 가진 단어가 없으면 0 입력
			if(TrieRoot[idx]==null) {
				answer[ansIdx++]=0;
				continue;
			}
			//처음이 ? 가 아니면 순방향
			if(query.charAt(0)!='?') {
				//트리 root에서 단어 찾기
				answer[ansIdx++]=TrieRoot[idx].search(query);
			//처음이 ? 이면 역방향
			}else {
				//역 트리 root 에서 단어 뒤집은 상태로 찾기
				answer[ansIdx++]=ReTrieRoot[idx].search(new StringBuilder(query).reverse().toString());
			}
		}
		
		return answer;
	}
	
	
	
	
	
	//-----------------본인 작성, 그러나 효율성 통과 못함------------------------//
	static class Alphabet{
		private char alphabet;
		private int idx;
		private HashMap<Character ,Alphabet> next;
		
		public Alphabet(char c, int index) {
			alphabet=c;
			idx=index;
			this.next=new HashMap<>();
		}
		
		@Override
		public String toString() {
			return next.toString()+" "+idx;
		}
		
	}
	
	public static int count(int idx, String q, Alphabet a) {
		if(a.idx>=q.length()) return 0;
		if(a.idx==q.length()-1&&a.next.size()==0) return 1;
		if(q.charAt(idx)!='?') {
			if(q.charAt(idx)!=a.alphabet) return 0;
		}
		int tmp=0;
		for(Character key:a.next.keySet()) {
			tmp+=count(idx+1,q, a.next.get(key));
		}
		return tmp;
	}

	
    public static int[] solution(String[] words, String[] queries) {
    	HashMap<Character, Alphabet> forward = new HashMap<>();
    	HashMap<Character, Alphabet> backward = new HashMap<>();
    	
    	for(String word:words) {
    		//정방향
    		boolean isConatain=true;
    		Alphabet root = forward.get(word.charAt(0));
    		if(root==null) {
    			isConatain=false;
    			root = new Alphabet(word.charAt(0), 0);
    		}
    		Alphabet now = root;
    		
    		for(int i=1;i<word.length();i++) {
    			char c = word.charAt(i);
    			Alphabet next = now.next.get(c);
    			//자식으로 없다면
    			if(next==null) {
    				next=new Alphabet(c,i);
    				now.next.put(c,next);
    			}
    			now=next;
    		}
    		if(!isConatain) forward.put(word.charAt(0) ,root);
    		
    		//역방향
    		root = backward.get(word.charAt(word.length()-1));
    		isConatain=true;
    		if(root==null) {
    			root = new Alphabet(word.charAt(word.length()-1), 0);
    			isConatain=false;
    		}
    		
    		now = root;
    		
    		for(int i=1;i<word.length();i++) {
    			int idx=word.length()-1-i;
    			char c = word.charAt(idx);
    			Alphabet next = now.next.get(c);
    			//자식으로 없다면
    			if(next==null) {
    				next=new Alphabet(c,i);
    				now.next.put(c,next);
    			}
    			now=next;
    		}
    		if(!isConatain) backward.put(word.charAt(word.length()-1),root);
    	}
    	
    	int[] answer = new int[queries.length];
    	int idx=0;
    	for(String q:queries) {
    		//정방향
    		int num=0;
    		if(q.charAt(0)!='?') {
    			for(Character key:forward.keySet()) {
    				num+=count(0,q,forward.get(key));
    			}
			//역순
    		}else {
    			StringBuilder sb = new StringBuilder(q);
    			String r = sb.reverse().toString();
    			for(Character key:backward.keySet()) {
    				num+=count(0,r,backward.get(key));
    			}
    		}
    		answer[idx++]=num;
    			
    	}
    	
        return answer;
    }
	
	public static void main(String[] args) {
		String[] w = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] q = {"fro??", "????o", "fr???", "fro???", "pro?"};
		for(int i:solution1(w, q)) {
			System.out.print(i+" ");
		}
	}
}
