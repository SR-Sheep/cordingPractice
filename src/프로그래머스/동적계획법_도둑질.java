package 프로그래머스;

public class 동적계획법_도둑질 {
	/*
	도둑이 어느 마을을 털 계획을 하고 있습니다. 이 마을의 모든 집들은 아래 그림과 같이 동그랗게 배치되어 있습니다.

	각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 두 집을 털면 경보가 울립니다.

	각 집에 있는 돈이 담긴 배열 money가 주어질 때, 도둑이 훔칠 수 있는 돈의 최댓값을 return 하도록 solution 함수를 작성하세요.

	제한사항
	이 마을에 있는 집은 3개 이상 1,000,000개 이하입니다.
	money 배열의 각 원소는 0 이상 1,000 이하인 정수입니다.
	*/
    public static int solution(int[] money) {
        int answer = 0;
        int len=money.length;
        int[] board=new int[len];
        //1) 첫째항 채택시
        board[0]=board[1]=money[0];
        for(int i=2;i<len;i++) {
        	//i번재 = 이전(안더함) ,이이전 + 현재 돈
        	board[i]=Math.max(board[i-1],board[i-2]+money[i]);
        }
        //마지막 -1항을 취함
        answer=Math.max(answer, board[len-2]);
        
        //2)마지막항 채택시(역순)
        board[len-1]=board[len-2]=money[len-1];
        for(int i=len-3;i>=0;i--) {
        	//i번재 = 이전(안더함) ,이이전 + 현재 돈
        	board[i]=Math.max(board[i+1], board[i+2]+money[i]);
        }
        //2번째 항을 취함
        answer=Math.max(answer, board[1]);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		int[][] money = {{1,2,3,1},{1,1,4,1,4},{1000, 0, 0, 1000, 0, 0, 1000, 0, 0, 1000}};
		for(int[] m:money) {
			System.out.println(solution(m));
		}
	}
}
