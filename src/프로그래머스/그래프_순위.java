package 프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 그래프_순위 {
	
	/*
	문제 설명
	n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
	권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
	심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다.
	하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
	
	선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때
	정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
	
	제한사항
	선수의 수는 1명 이상 100명 이하입니다.
	경기 결과는 1개 이상 4,500개 이하입니다.
	results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
	모든 경기 결과에는 모순이 없습니다.
	 
	 */
	
	static class Fighter{
		int num;
		private List<Fighter> parents, children;
		
		public Fighter(int number) {
			this.num=number;
			parents=new ArrayList<>();
			children=new ArrayList<>();
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public List<Fighter> getParents() {
			return parents;
		}

		public void setParents(List<Fighter> parents) {
			this.parents = parents;
		}

		public List<Fighter> getChildren() {
			return children;
		}

		public void setChildren(List<Fighter> children) {
			this.children = children;
		}
				
	}
	
	
    public static int solution(int n, int[][] results) {
        int answer = 0;
        
        List<Fighter> list = new ArrayList<>();
        //리스트에 Fight 객체 생성
        for(int i=0;i<n+1;i++) {
        	list.add(new Fighter(i)); 
        }
        
        //각 객체에 승자(parent)와 패자(losser) 세팅
        for(int[] result:results) {
        	int winner = result[0];
        	int losser = result[1];
        	list.get(winner).getChildren().add(list.get(losser));
        	list.get(losser).getParents().add(list.get(winner));
        }
        
        //리스트 순회
        for(int i=1;i<list.size();i++) {
        	int count=0;
        	//승자들과 패자들
        	List<Fighter> parents=list.get(i).getParents();
        	List<Fighter> children=list.get(i).getChildren();
        	//큐
        	Queue<List<Fighter>> q = new LinkedList<List<Fighter>>(); 
        	//큐에 부모들 세팅
        	q.add(parents);
        	//방문여부 체크
        	boolean[] visited1 = new boolean[n+1];
        	
        	while(!q.isEmpty()) {
        		List<Fighter> now = q.poll();
        		for(Fighter parent :now) {
        			//방문했으면 컨티뉴
        			if(visited1[parent.getNum()]) continue;
        			//방문 표시 후, 갯수 증가
        			visited1[parent.getNum()]=true;
        			count++;
        			//큐에 부모의 부모 넣기
        			q.add(list.get(parent.getNum()).getParents());
        		}
        	}
        	//큐에 자식들 세팅
        	q.add(children);
        	//방문 여부 체크
        	boolean[] visited2 = new boolean[n+1];
        	
        	while(!q.isEmpty()) {
        		List<Fighter> now = q.poll();
        		for(Fighter child :now) {
        			//방문했으면 컨티뉴
        			if(visited2[child.getNum()]) continue;
        			//방문 표시 후, 갯수 증가
        			visited2[child.getNum()]=true;
        			count++;
        			//큐에 자식의 자식들 넣기
        			q.add(list.get(child.getNum()).getChildren());
        		}
        	}
        	//부모수 + 자식수 = n-1이면 모든 선수와 경기했음으로 순위 산정 가능 -> 답 증가
        	if(count==n-1) answer++;
        }
        
        return answer;
    }
    //그래프로 풀기
    public static int solution2(int n, int[][] results) {
        int answer = 0;
        //방문 여부 확인
        boolean[][] chk = new boolean[n + 1][n + 1];
        //경기 했으면 true;
        for(int i = 0; i < results.length; i++) {
            chk[results[i][0]][results[i][1]] = true;
        }
        //중간값
        for(int k = 1; k < n + 1; k++) {
            //시작값
        	for(int i = 1; i < n + 1; i++) {
                //끝값
        		for(int j = 1; j < n + 1; j++) {
        			//시작과 끝이 다르고
        			//시작 - 중간, 중간-끝 의 경기가 있으면
                    if(i != j && chk[i][k] && chk[k][j]) {
                    	//시작 - 끝은 경기를 한거나 다름없음
                        chk[i][j] = true;
                    }
                }
            }
        }
        
        //방문여부 순회
        //시작값
        for(int i = 1; i < n + 1; i++) {
            boolean pass = true;
            //끝값
            for(int j = 1; j < n + 1; j++) {
                //시작과 끝이 다르고
            	//시작 - 끝 이나 끝 - 시작의 경기 결과가 없으면
            	if(i != j && !(chk[i][j] || chk[j][i])) {
                    //패스 불가
            		pass = false;
                    break;
                }
            }
            //패스하면(모든 경기를 했으면)
            if(pass) {
            	//답 증가
                answer++;
            }
        }

        return answer;
    }
    
	
	public static void main(String[] args) {
		int n=5;
		int[][] r = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(n, r));
	}
}
