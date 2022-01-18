package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 카카오_동굴탐험 {
	static List<Integer>[] AdjList; //인접리스트
	static HashMap<Integer, Integer> Prev; //방문 -> 열림
	static HashMap<Integer, Integer> Next; //열림 -> 방문
	static boolean[] Visited; //방문 여부
	static int Count; //방문 횟수(n과 비교하여 답 출력)
	
	public static void dfs(int n) {
		//방문해야 열리는 곳이고, 아직 열리지 않았다면 패쓰
		if(Next.containsKey(n)&&!Visited[Next.get(n)]) {
			Prev.put(Next.get(n), n);
			return;
		}
		Visited[n]=true; //방문 여부 표시
		//방문횟수 증가
		Count++;
		//열린 곳 탐색
		if(Prev.containsKey(n)) {
			dfs(Prev.get(n));
		}
		//인접 리스트 방문
		for(int i:AdjList[n]) {
			//방문한 곳이면 패쓰
			if(Visited[i]) continue;
			dfs(i);
		}
	}
	
	
    public static boolean solution(int n, int[][] path, int[][] order) {
        AdjList=new ArrayList[n];
        Prev=new HashMap<Integer, Integer>();
        Next=new HashMap<Integer, Integer>();
        Visited=new boolean[n];
        Count = 0;
        for(int i=0;i<n;i++) {
        	AdjList[i]=new ArrayList<>();
        }
        for(int[] p:path) {
        	AdjList[p[0]].add(p[1]);
        	AdjList[p[1]].add(p[0]);
        }
        for(int[] o:order) {
        	Next.put(o[1], o[0]);
        }
        dfs(0);
        return Count==n?true:false;
    }
	
	public static void main(String[] args) {
		int n=9;
		int[][] path ={{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		int[][] order ={{8,5},{6,7},{4,1}};
		System.out.println(solution(n, path, order));//true;
		int[][] order1 ={{4,1},{8,7},{6,5}};
		System.out.println(solution(n, path, order1)); //false
		int[][] path2 ={{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}};
		int[][] order2 = {{4,1},{5,2}}; 
		System.out.println(solution(n, path2, order2)); //true;
		n=2;
		int[][] path3 ={{0,1}};
		int[][] order3 = {{0,1}};
		System.out.println(solution(n, path3, order3)); //true;
		
	}
}
