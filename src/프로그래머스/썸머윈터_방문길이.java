package 프로그래머스;

import java.util.HashMap;

public class 썸머윈터_방문길이 {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/49994#
	
	문제 설명
	게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

	U: 위쪽으로 한 칸 가기

	D: 아래쪽으로 한 칸 가기

	R: 오른쪽으로 한 칸 가기

	L: 왼쪽으로 한 칸 가기

	캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
	
	명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.

	제한사항
	dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
	dirs의 길이는 500 이하의 자연수입니다.
	
	*/
	
	public int solution(String dirs) {
        HashMap<Character, int[]>map = new HashMap<>(); //방향 저장 해쉬맵
        map.put('U',new int[]{-1,0}); // 위
        map.put('R',new int[]{0,1});  // 오른쪽
        map.put('L',new int[]{0,-1}); // 왼쪽
        map.put('D',new int[]{1,0});  // 아래
        boolean[][] visited=new boolean[22][22]; //방문여부, 중간 경로를 계산해야 함으로 2배 적용
        int r=10,c=10; //가운데 값
        int answer = 0; //답
        //탐색
        for(char ch:dirs.toCharArray()){
            //해당 좌표값 가져오기
            int[] dir = map.get(ch); 
            int nr = r+dir[0];
            int nc = c+dir[1];
            //범위를 벗어나면 컨티뉴
            if(nr+dir[0]<0||nr+dir[0]>=22||nc+dir[1]<0||nc+dir[1]>=22) continue;
            //첫 방문시 방문여부 표시 후 답 증가
            if(!visited[nr][nc]){
                visited[nr][nc]=true;
                answer++;
            };
            //현재 좌표 업데이트
            r=nr+dir[0];
            c=nc+dir[1];
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
	}
}
