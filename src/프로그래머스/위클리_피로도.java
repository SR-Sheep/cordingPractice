package 프로그래머스;

public class 위클리_피로도 {
	/*
	XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며,
	일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
	이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
	"최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며,
	"소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 예를 들어 "최소 필요 피로도"가 80,
	"소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며,
	던전을 탐험한 후에는 피로도 20이 소모됩니다.

	이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데,
	한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
	유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
	유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.

	제한사항
	k는 1 이상 5,000 이하인 자연수입니다.
	dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
	dungeons의 가로(열) 길이는 2 입니다.
	dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
	"최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
	"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
	서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
	*/
	
	static boolean[] Visited;
	static int[][] Dungeons;
	
	public static int dfs(int k) {
		int answer=0;
		for(int i=0;i<Dungeons.length;i++) {
			int tmp=0;
			int patigue = adv(k,Dungeons[i]); //탐험을 마쳤을 때 피로도
			if(patigue<0) continue; //피로도가 음수일 시 pass
			if(Visited[i]) continue; //방문 했을 시 pass
			Visited[i]=true; //방문여부 체크
			tmp+=1+dfs(patigue); //1 증가 및 k값 현재 피로도로 변경하여 재귀
			Visited[i]=false;//방문여부 회복
			answer=Math.max(answer, tmp); //계산값과 답 중 큰값을 취함
		}
		return answer;
	}
	//탐험 가능 시 현재 피로도 - 소모 피로도 리턴, 불가시 -1 리턴
	public static int adv(int k, int[] dungeon) {
		if(k>=dungeon[0]) {
			return k-dungeon[1];
		}
		return -1;
		
	}
	
	//같은 코드를 압축함
	public static int dfsZip(int k) {
		int answer=0;
		for(int i=0;i<Dungeons.length;i++) {
			if(adv(k,Dungeons[i])<0) continue; //피로도가 음수일 시 pass
			if(!Visited[i]&&k>=Dungeons[i][0]){
				Visited[i]=true; //방문여부 체크
				answer=Math.max(answer, 1+dfs(k-Dungeons[i][1])); //계산값과 답 중 큰값을 취함
				Visited[i]=false;//방문여부 회복
			}//방문 했을 시 pass
		}
		return answer;
	}
	
	public static int solution(int k, int[][] dungeons) {
        Visited=new boolean[dungeons.length];
        Dungeons=dungeons;
        return dfs(k);
    }
    
	public static void main(String[] args) {
		int[][] d = {{80,20},{50,40},{30,10}};
		int k =80;
		System.out.println(solution(k, d));
	}
}
