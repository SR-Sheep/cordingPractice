package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 위클리_전력망둘로나누기 {
	/*
	문제 설명
	n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
	당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
	이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.

	송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
	전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
	두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.

	제한사항
	n은 2 이상 100 이하인 자연수입니다.
	wires는 길이가 n-1인 정수형 2차원 배열입니다.
	wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며,
	이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
	1 ≤ v1 < v2 ≤ n 입니다.
	전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
	*/
	
	
	//부모가져오기
	public static int getParent(int x,int[] link) {
		if(link[x]==x) return x;
		return link[x]= getParent(link[x],link);
	}
	
	//부모 병합
	public static void setParent(int a,int b,int[] link) {
		a=getParent(a,link);
		b=getParent(b,link);
		if(a<b) link[b]=a;
		else link[a]=b;
	}
	
	public static int countNode(int[] l,List<int[]> list) {
		int answer=0;
		int[] link=Arrays.copyOf(l, l.length);
		int nodes=link.length-1; //0 제외
		
		//list의 형제요소 부모 세팅
		for(int[] w:list) setParent(w[0], w[1], link);
		
		//부모가 맨 처음요소와 같으면 답 증가
		for(int i=1;i<link.length;i++) {
			if(1==getParent(i,link)) answer++;
		}
		// 부모1의 수 - 부모2의 수
		// 부모2의 수 = (전체 요소 수 - 부모 1의 수);
		// 답: abs(2*부모1의 수 - 전체 요소 수)
		answer=2*answer-nodes;
		//음수일시 양수로 변환
		return answer<0?answer*-1:answer;
	}
	
    public static int solution(int n, int[][] wires) {
    	final int INF = 987654321;
    	int answer = INF;
    	//1~n link 선언(0 사용 안함)
    	int[] link=new int[n+1];
    	//link의 node들 root 초기화(자기번호)
    	for(int i=1;i<n+1;i++) link[i]=i;
        
    	//한개씩 list에 빼서 담기
    	for(int i=0;i<n-1;i++) {
    		List<int[]> list = new ArrayList<int[]>();
        	for(int j=0;j<n-1;j++) {
        		if(i==j) continue;
        		list.add(wires[j]);
        	}
        	//계산결과와 답을 비교하여 최소값을 답으로 취함
        	answer=Math.min(answer, countNode(link, list));
        }
        return answer;
    }
    
    //=======================다른사람의 풀이=======================//
    
    //말단에서부터 자식 노드 합친 갯수를 이용하여 풀이
    
    static int N;
	static int min;
	static int[][] map;
	static int[] vst;
	static int dfs(int n){
		//자식수 설정, 자기 자신 포함
        int child = 1;
        for(int i = 1; i <= N; i++) {
        	//방문하지 않고, n과 i가 연결되어 있다면
            if(vst[i] == 0 && map[n][i] == 1) {
            	//i 방문 여부 표시
                vst[i] = 1;
                child += dfs(i); //자식과 연결된 자식 수를 더함
            }
        }
        System.out.println("n : "+n+" // child : "+child);
        
        //min과 차이 중 작은 것을 min으로 취함
        min = Math.min(min, Math.abs(child - (N - child)));
        return child;
    }
    public static int solution2(int n, int[][] wires) {
        N = n;
        min = n;
        map = new int[n+1][n+1]; //인덱스 그대로 사용 그래프
        vst = new int[n+1];
        for(int[] wire : wires) {
            int a = wire[0], b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        return min;
    }
    //===================== 다른사람의 풀이 끝=====================//
    
	
	public static void main(String[] args) {
		int n=9;
		int[][] wires={{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}; //3
		int n2=4;
		int[][] wires2={{1,2},{2,3},{3,4}}; //0
		int n3=7;
		int[][] wires3={{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}; //1
		
		System.out.println(solution2(n, wires));
		System.out.println(solution(n2, wires2));
		System.out.println(solution(n3, wires3));
	}
}
