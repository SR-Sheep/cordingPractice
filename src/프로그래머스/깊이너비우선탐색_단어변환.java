package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 깊이너비우선탐색_단어변환 {
	/*
	두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
	아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

	1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
	2. words에 있는 단어로만 변환할 수 있습니다.
	예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
	"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

	두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
	최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

	제한사항
	각 단어는 알파벳 소문자로만 이루어져 있습니다.
	각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
	words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
	begin과 target은 같지 않습니다.
	변환할 수 없는 경우에는 0를 return 합니다.
	*/
	
	//글자 수
	static int N;
	//글자 변경
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
	//단어 클래스
	static class Word{
		private String word; //단어
		private int count; //카운트
		private boolean[] visited; //방문 여부
		
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
        //전략
    	//2차원 배열에 Word클래스(word,변경횟수,방문여부) 저장후 q에 넣기
    	//words에서 한글자가 다르고 방문하지 않은 경우 q에 변경된 단어, 횟수+1, 방문여부 업데이트 q에 넣기
    	//Word클래스의 단어가 타겟과 같다면 return;
    	
    	//글자길이
    	N=begin.length();
    	//방문여부
    	boolean[] visited = new boolean[words.length];
    	//큐 선언
    	Queue<Word> q = new LinkedList<>();
    	//시작단어, 변경횟수, 방문여부 넣기
    	q.add(new Word(begin,0,visited));
    	while(!q.isEmpty()) {
    		Word word= q.poll();
    		String w = word.getWord(); //단어 
    		int c=word.getCount(); //횟수
    		boolean[] v=word.getVisited(); //방문여부
    		//단어가 타겟과 같으면 횟수 리턴
    		if(w.equals(target)) return c;
    		
    		for(int i=0;i<words.length;i++) {
    			//한글자가 다른 단어이고,
    			if(isOneLetter(w,words[i])) {
    				if(v[i]) continue;
    				//방문하지 않았다면 방문여부를 표시
    				v[i]=true;
    				//큐에 변경 단어, 횟수+1, 방문여부
    				q.add(new Word(words[i], c+1, v));
    			}
    		}
    	}
        return 0; //같은 단어가 없으면 0 출력
    }
    
    public static void main(String[] args) {
		String b = "hit";
		String e = "cog";
		String[] w ={"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(b, e, w));
		//"hit" -> "hot" -> "dot" -> "dog" -> "cog
	}
	
	
}
