package ���α׷��ӽ�;

import java.util.LinkedList;
import java.util.Queue;

public class ���̳ʺ�켱Ž��_�ܾȯ {
	/*
	�� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �ֽ��ϴ�.
	�Ʒ��� ���� ��Ģ�� �̿��Ͽ� begin���� target���� ��ȯ�ϴ� ���� ª�� ��ȯ ������ ã������ �մϴ�.

	1. �� ���� �� ���� ���ĺ��� �ٲ� �� �ֽ��ϴ�.
	2. words�� �ִ� �ܾ�θ� ��ȯ�� �� �ֽ��ϴ�.
	���� ��� begin�� "hit", target�� "cog", words�� ["hot","dot","dog","lot","log","cog"]���
	"hit" -> "hot" -> "dot" -> "dog" -> "cog"�� ���� 4�ܰ踦 ���� ��ȯ�� �� �ֽ��ϴ�.

	�� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �Ű������� �־��� ��,
	�ּ� �� �ܰ��� ������ ���� begin�� target���� ��ȯ�� �� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

	���ѻ���
	�� �ܾ�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
	�� �ܾ��� ���̴� 3 �̻� 10 �����̸� ��� �ܾ��� ���̴� �����ϴ�.
	words���� 3�� �̻� 50�� ������ �ܾ ������ �ߺ��Ǵ� �ܾ�� �����ϴ�.
	begin�� target�� ���� �ʽ��ϴ�.
	��ȯ�� �� ���� ��쿡�� 0�� return �մϴ�.
	*/
	
	//���� ��
	static int N;
	//���� ����
	public static boolean isOneLetter(String begin,String target) {
		int count=0;
		for(int i=0;i<N;i++) {
			if(begin.charAt(i)!=target.charAt(i)) {
				count++;
			}
		}
		if(count==1) return true;
		return false;
	}
	//�ܾ� Ŭ����
	static class Word{
		private String word; //�ܾ�
		private int count; //ī��Ʈ
		private boolean[] visited; //�湮 ����
		
		public Word(String w, int c, boolean[] v) {
			this.word=w;
			this.count=c;
			this.visited=v;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public boolean[] getVisited() {
			return visited;
		}

		public void setVisited(boolean[] visited) {
			this.visited = visited;
		}
	}
	
    public static int solution(String begin, String target, String[] words) {
        //����
    	//2���� �迭�� WordŬ����(word,����Ƚ��,�湮����) ������ q�� �ֱ�
    	//words���� �ѱ��ڰ� �ٸ��� �湮���� ���� ��� q�� ����� �ܾ�, Ƚ��+1, �湮���� ������Ʈ q�� �ֱ�
    	//WordŬ������ �ܾ Ÿ�ٰ� ���ٸ� return;
    	
    	//���ڱ���
    	N=begin.length();
    	//�湮����
    	boolean[] visited = new boolean[words.length];
    	//ť ����
    	Queue<Word> q = new LinkedList<>();
    	//���۴ܾ�, ����Ƚ��, �湮���� �ֱ�
    	q.add(new Word(begin,0,visited));
    	while(!q.isEmpty()) {
    		Word word= q.poll();
    		String w = word.getWord(); //�ܾ� 
    		int c=word.getCount(); //Ƚ��
    		boolean[] v=word.getVisited(); //�湮����
    		//�ܾ Ÿ�ٰ� ������ Ƚ�� ����
    		if(w.equals(target)) return c;
    		
    		for(int i=0;i<words.length;i++) {
    			//�ѱ��ڰ� �ٸ� �ܾ��̰�,
    			if(isOneLetter(w,words[i])) {
    				if(v[i]) continue;
    				//�湮���� �ʾҴٸ� �湮���θ� ǥ��
    				v[i]=true;
    				//ť�� ���� �ܾ�, Ƚ��+1, �湮����
    				q.add(new Word(words[i], c+1, v));
    			}
    		}
    	}
        return 0; //���� �ܾ ������ 0 ���
    }
    
    public static void main(String[] args) {
		String b = "hit";
		String e = "cog";
		String[] w ={"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(b, e, w));
		//"hit" -> "hot" -> "dot" -> "dog" -> "cog
	}
	
	
}
