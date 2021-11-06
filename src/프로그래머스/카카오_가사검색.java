package ���α׷��ӽ�;

import java.util.*;

public class īī��_����˻� {
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
	
	//�ܾ� �ִ� ���� 10000
	static Trie[] TrieRoot = new Trie[10000];
	static Trie[] ReTrieRoot = new Trie[10000];
	
	
	public static int[] solution1(String[] words,String[] queries) {
		int[] answer= new int[queries.length];
		int ansIdx=0;
		
		//�ܾ� �Է�
		for(String word:words) {
			//�ܾ��� ���̷� idx
			int idx = word.length()-1;
			//���� ���ٽ�, ��ü ����
			if(TrieRoot[idx]==null) {
				TrieRoot[idx]=new Trie();
				ReTrieRoot[idx]=new Trie();
			}
			//�����⿡ �ܾ� ����
			TrieRoot[idx].insert(word);
			//�����⿡ �Ųٷ� �ܾ� ����
			ReTrieRoot[idx].insert(new StringBuilder(word).reverse().toString());
		}
		//���� ã��
		for(String query:queries) {
			//������ ���̷� idx
			int idx= query.length()-1;
			//������ ���̸� ���� �ܾ ������ 0 �Է�
			if(TrieRoot[idx]==null) {
				answer[ansIdx++]=0;
				continue;
			}
			//ó���� ? �� �ƴϸ� ������
			if(query.charAt(0)!='?') {
				//Ʈ�� root���� �ܾ� ã��
				answer[ansIdx++]=TrieRoot[idx].search(query);
			//ó���� ? �̸� ������
			}else {
				//�� Ʈ�� root ���� �ܾ� ������ ���·� ã��
				answer[ansIdx++]=ReTrieRoot[idx].search(new StringBuilder(query).reverse().toString());
			}
		}
		
		return answer;
	}
	
	
	
	
	
	//-----------------���� �ۼ�, �׷��� ȿ���� ��� ����------------------------//
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
    		//������
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
    			//�ڽ����� ���ٸ�
    			if(next==null) {
    				next=new Alphabet(c,i);
    				now.next.put(c,next);
    			}
    			now=next;
    		}
    		if(!isConatain) forward.put(word.charAt(0) ,root);
    		
    		//������
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
    			//�ڽ����� ���ٸ�
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
    		//������
    		int num=0;
    		if(q.charAt(0)!='?') {
    			for(Character key:forward.keySet()) {
    				num+=count(0,q,forward.get(key));
    			}
			//����
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
