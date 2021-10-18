package 프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 스택큐_다리를지나가는트럭 {
	/*
	 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
	 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
	 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
	 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
	 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
	 
	 *제한조건
	 
	 bridge_length는 1 이상 10,000 이하입니다.
 	 weight는 1 이상 10,000 이하입니다.
	 truck_weights의 길이는 1 이상 10,000 이하입니다.
	 모든 트럭의 무게는 1 이상 weight 이하입니다.
	 
	 */
	
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	//자동차를 올릴 다리 q 선언 (먼저 올라가는 차가 먼저 나감)
    	Queue<Integer> bridge = new LinkedList<Integer>();
    	//다리에 빈 공간 0 채우기 (마지막 부분은 첫 차가 올라 갈 것)
    	for(int i=0;i<bridge_length-1;i++) bridge.add(0);
    	//첫 차 다리 위에 올리기
    	bridge.add(truck_weights[0]);
    	
    	//이미 첫차가 올라갔으니 시간은 1초, 위치 idx는 1, 다리위 무게는 첫차의 무게
    	int sec=1;
    	int idx=1;
    	int sum = truck_weights[0];
    	
    	while(!bridge.isEmpty()) {
    		sec++;// 시간경과
    		int truck = bridge.poll();
    		sum-=truck; //현재 트럭 탈출
    		//인덱스가 범위 내에 있다면
    		if(idx<truck_weights.length) {
    			//현재 합계 + 다음 트럭의 무게가 중량초과일시
    			if(sum+truck_weights[idx]>weight) {
    				bridge.add(0); //다리 위에 0 추가
				//현재 합계 + 다음 트럭의 무게가 중량 내 일시
    			}else {
    				sum+=truck_weights[idx]; //다음 트럭 올리기
    				bridge.add(truck_weights[idx]); //브릿지에 다음 트럭 추가
    				idx++;//인덱스 증가
    			}
    		}
		}
        return sec;
    }
    
	public static void main(String[] args) {
		List<int[][]> list = new ArrayList<>();
		list.add(new int[][] {{2},{10},{7,4,5,6}});
		list.add(new int[][] {{100},{100},{10}});
		list.add(new int[][] {{100},{100},{10,10,10,10,10,10,10,10,10,10}});
		for(int[][] question:list) {
			System.out.println(solution(question[0][0], question[1][0], question[2]));
		}
		
		
	}

}
