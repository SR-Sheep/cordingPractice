package 프로그래머스;

import java.util.Arrays;

public class 탐욕법_섬연결하기 {
/*	
	문제 설명
	n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
	최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때
	필요한 최소 비용을 return 하도록 solution을 완성하세요.

	다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다.
	예를 들어 A 섬과 B 섬 사이에 다리가 있고,
	B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

	제한사항

	섬의 개수 n은 1 이상 100 이하입니다.
	costs의 길이는 ((n-1) * n) / 2이하입니다.
	임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는
	다리가 연결되는 두 섬의 번호가 들어있고, 
	costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
	같은 연결은 두 번 주어지지 않습니다.
	또한 순서가 바뀌더라도 같은 연결로 봅니다.
	즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
	모든 섬 사이의 다리 건설 비용이 주어지지 않습니다.
	이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
	연결할 수 없는 섬은 주어지지 않습니다.
*/	
	
	//전략 : 비용순 정렬 후
	//	    선택한 간선간 연결 여부 확인
	//		연결 되어있으면? 패쓰
	//		연결 안되어 있으면? 등록
	
	static int[] Link;
	
	//부모가져오기
	public static int getParent(int x) {
		if(Link[x]==x) return x;
		Link[x]= getParent(Link[x]);
		return Link[x];
	}
	
	//부모 병합
	public static void setParent(int a,int b) {
		a=getParent(a);
		b=getParent(b);
		if(a<b) Link[b]=a;
		else Link[a]=b;
	}
	
	//같은 부모 여부 확인
	public static boolean isSibling(int a, int b) {
		a=getParent(a);
		b=getParent(b);
		if(a==b) return true;
		return false;
	}
	
	
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Link = new int[n]; //부모를 알려주는 table;
        
        for(int i=0;i<n;i++) {
        	Link[i]=i; //자기 자신 = 부모
        }
        //비용 순 정렬
        Arrays.sort(costs,(x,y)->x[2]-y[2]);
        
        for(int[] cost:costs) {
        	int a = cost[0]; //노드 1
        	int b = cost[1]; //노드 2
        	int c = cost[2]; //비용
        	//a와 b가 아직 서로 연결이 안되어 있다면(부모가 다르다면)
        	if(!isSibling(a, b)) {
        		setParent(a, b); //부모 설정
        		answer+=c; //비용을 답에 더함
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] costs={{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n=4;
		System.out.println(solution(n, costs));
	}
}
