package 프로그래머스;

import java.util.PriorityQueue;

public class 연습문제_땅따먹기 {
	//https://programmers.co.kr/learn/courses/30/lessons/12913
	/* 땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
	 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
	 * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
	 * 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요
	 */
    public static int solution(int[][] land) {
        int answer = 0;
        int[][] dp =new int[land.length][4];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(y[1]-x[1]));
        dp[0]=land[0];
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                pq.add(new int[]{j,dp[i-1][j]}); //idx, 값
            }
            int[] first = pq.poll(); //이전 최대값(idx, value)
            int[] second = pq.poll(); //이전 두번째 최대값(idx, value)
            for(int j=0;j<4;j++){
                if(first[0]!=j){
                    dp[i][j]=land[i][j]+first[1];
                }else{
                    dp[i][j]=land[i][j]+second[1];
                }
            }
            pq.clear();
        }
        for(int i=0;i<4;i++){
            answer=Math.max(answer,dp[land.length-1][i]);
        }
        return answer;
    }
}
