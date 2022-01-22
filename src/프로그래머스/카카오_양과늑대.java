package 프로그래머스;

public class 카카오_양과늑대 {
    //https://programmers.co.kr/learn/courses/30/lessons/92343
	
	static int[] Tree;
	static int Sheep;
	static int[] Info;
	
	public static void dfs(int no, int sheep, int wolf, int bitmask, int depth) {
		//양과 늑대수 업데이트
		sheep+=Info[no]^1;
		wolf+=Info[no];
		//System.out.println("노드 "+no+"- 깊이 "+depth+" : 양 = "+sheep+" 늑대 = "+wolf);
		
		//늑대가 더 많으면 리턴 
		if(wolf>=sheep) {
			return;
		}
		//양 최대값 갱신
		Sheep=Math.max(Sheep, sheep);
		//연결된 리스트 넣기
		bitmask|=Tree[no];
		//다음 방문 목록에서 현재값 제거
		bitmask&=~(1<<no);
		
		//다음 방문지를 탐색 후 dfs
		for(int i=0;i<Info.length;i++) {
			int idx = 1<<i;
			if((bitmask&idx)==idx) {
				dfs(i,sheep,wolf,bitmask,depth+1);
			}
		}
	}
	
	
	public static int solution(int[] info, int[][] edges) {
        Info=info;
		Tree=new int[info.length];
		int bitmask= 1<<info.length; //다음 행선지를 표시하기 위한 비트마스크
		for(int[] edge:edges) {
        	int parent = edge[0];
        	int child = edge[1];
        	Tree[parent]|=1<<child; //자식 추가
        }
        bitmask|=1; //root 추가
        dfs(0,0,0,bitmask,0);
        return Sheep;
    }
    
    public static void main(String[] args) {
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(solution(info, edges));
	}
}
