package 프로그래머스;

import java.util.Arrays;

public class 이분탐색_징검다리 {
	/*
	출발지점부터 도착지점까지의 거리 distance,
	바위들이 있는 위치를 담은 배열 rocks,
	제거할 바위의 수 n이 매개변수로 주어질 때,
	바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에
	가장 큰 값을 return 하도록 solution 함수를 작성해주세요.

	제한사항
	- 도착지점까지의 거리 distance는 1 이상 1,000,000,000 이하입니다.
	- 바위는 1개 이상 50,000개 이하가 있습니다.
	- n 은 1 이상 바위의 개수 이하입니다.
	*/
	
	/*
	 * 전략
	 * 줄을 세운 뒤
	 * 최소(1), 최대 거리(distance) 값에서 점점 값을 좁혀 mid 설정
	 * mid보다 덜 떨어진 돌은 파괴 -> 떨어진 거리의 현재 최소값 = mid 
	 * 
	 * 최소가 최대보다 클때까지 반복
	 * 
	 * 돌 파괴 횟수가 n보다 작거나 같다면
	 * 답과 비교하여 큰값을 취한뒤
	 * 최소값을 mid+1로 설정하고 반복
	 * 
	 * 돌 파괴 횟수가 n보다 크다면
	 * 최대값을 mid-1로 설정하고 반복
	 * 
	 */
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        //최소 거리 1, 최대 거리 = distance
        int left = 1, right = distance, mid=0;
        
        while(left<=right) {
        	int prev = 0; //이전 돌
        	int cnt=0; //횟수
        	//중간 거리 설정
        	mid = (left+right)/2;
        	//탐색 시작
        	for(int rock:rocks) {
        		//현재 돌과 이전 돌 사이의 거리가 미드보다 작다면 돌 파괴(횟수 증가)
        		if(mid>rock-prev) {
        			cnt++;
        		} else {
        			//아니라면 이전돌로 설정
        			prev = rock;
        		}
        	}
        	//마지막 요소에 대한 검사
        	if(distance-prev <mid) cnt++;
        	
        	//돌 파괴 횟수가 제시한 숫자보다 작다면
        	if(cnt<=n) {
        		//left값을 mid+1로 변경
        		left = mid+1;
        		//답은 mid의 최대값으로 취함
        		answer = Math.max(answer, mid);
        	//돌 파괴 횟수가 n보다 크면 조건에 맞지 않음으로 right만 설정
        	}else {
        		right = mid-1;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int d = 25;
		int[] rocks = {2,14,11,21,17};
		int n= 2;
		System.out.println(solution(d, rocks, n));
		
	}

}
