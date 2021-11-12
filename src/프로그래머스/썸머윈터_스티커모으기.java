package 프로그래머스;

public class 썸머윈터_스티커모으기 {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/12971#
	
	원형으로 연결된 스티커에서 몇 장의 스티커를 뜯어내어 뜯어낸 스티커에 적힌 숫자의 합이 최대가 되도록 하고 싶습니다.
	단 스티커 한 장을 뜯어내면 양쪽으로 인접해있는 스티커는 찢어져서 사용할 수 없게 됩니다.

	스티커에 적힌 숫자가 배열 형태로 주어질 때, 스티커를 뜯어내어 얻을 수 있는 숫자의 합의 최댓값을 return 하는 solution 함수를 완성해 주세요.
	원형의 스티커 모양을 위해 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어 있다고 간주합니다.

	제한 사항
	sticker는 원형으로 연결된 스티커의 각 칸에 적힌 숫자가 순서대로 들어있는 배열로, 길이(N)는 1 이상 100,000 이하입니다.
	sticker의 각 원소는 스티커의 각 칸에 적힌 숫자이며, 각 칸에 적힌 숫자는 1 이상 100 이하의 자연수입니다.
	원형의 스티커 모양을 위해 sticker 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어있다고 간주합니다.
	*/
	public static int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];
        else if(sticker.length==2) return Math.max(sticker[0],sticker[1]);
        
        int answer=0;
        int[] point = new int[sticker.length];
        //1)첫째항 채택
        point[0]=point[1]=sticker[0];
        for(int i=2;i<sticker.length-1;i++){
            //이전값, 이전전 값 + 현재 스티커값 중 큰값을 취함
            point[i]=Math.max(point[i-1],point[i-2]+sticker[i]);
        }
        //마지막 값은 취할 수 없음으로 마지막 -1 값을 취함
        answer = point[sticker.length-2];    
        
        //2)첫 항 채택 안함
        point[0]=0;
        point[1]=sticker[1];
        for(int i=2;i<sticker.length;i++){
            //이전값, 이전전 값 + 현재 스티커값 중 큰값을 취함
            point[i]=Math.max(point[i-1],point[i-2]+sticker[i]);
        }
        //마지막 값과 이전 답 비교하여 큰값을 취함
        answer = Math.max(answer,point[sticker.length-1]);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		int[] sticker = {14,6,5,11,3,9,2,10}; //36
		int[] sticker2 = {1,3,2,5,4}; //8
		System.out.println(solution(sticker));
		System.out.println(solution(sticker2));
	}
}
