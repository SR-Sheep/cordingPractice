package 프로그래머스;

public class 연습문제_가장큰정사각형찾기 {
	/*
	문제 설명
	1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
	표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
	(단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
	
	제한사항
	표(board)는 2차원 배열로 주어집니다.
	표(board)의 행(row)의 크기 : 1,000 이하의 자연수
	표(board)의 열(column)의 크기 : 1,000 이하의 자연수
	표(board)의 값은 1또는 0으로만 이루어져 있습니다.
	*/
	
    public static int solution(int [][]board) {
    	int answer=0;
    	for(int i=1;i<board.length;i++) {
    		//좌측, 상단, 대각선과 비교하여 가장 작은 수+1(자기 자신)을 보드의 숫자로 변경
        	for(int j=1;j<board[0].length;j++) {
        		if(board[i][j]!=0) {
        			board[i][j]=Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]))+1;
        		}
        		//보드의 최대값을 답으로 취함
        		answer=Math.max(answer, board[i][j]);
        	}
    	}
    	return answer*answer;
    }
	
	public static void main(String[] args) {
		int[][] b = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};//9
		int[][] c = {{0,0,1,1},{1,1,1,1}};//4
		int[][] d = {{0,0,0,0},{1,0,0,0},{1,0,0,0},{0,0,0,0}};//1
		System.out.println(solution(d));
	}
}
