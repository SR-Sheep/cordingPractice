package 프로그래머스;

public class 동적계획법_등굣길 {
	/*
	계속되는 폭우로 일부 지역이 물에 잠겼습니다.
	물에 잠기지 않은 지역을 통해 학교를 가려고 합니다.
	집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.

	가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고
	가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

	격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다.
	오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를
	return 하도록 solution 함수를 작성해주세요.

	제한사항
	- 격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
	- m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
	- 물에 잠긴 지역은 0개 이상 10개 이하입니다.
	- 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
	*/
	
	public static int solution(int m, int n, int[][] puddles) {
		//idx가 1부터 시작이므로 보드 사이즈를 1 더 크게 잡아 idx를 그대로 사용
		int[][] board = new int[m+1][n+1];
		//웅덩이 위치는 -1
		for(int[] p:puddles) {
			board[p[0]][p[1]]=-1;
		}
		//위쪽은 1로 채우기, 웅덩이를 만나면 stop
		for(int i=1;i<=m;i++) {
			if(board[i][1]==-1) break;
			board[i][1]=1;
		}
		//왼쪽 1로 채우기, 웅덩이를 만나면 stop
		for(int i=1;i<=n;i++) {
			if(board[1][i]==-1) break;
			board[1][i]=1;
		}
		//2,2 부터 시작
		for(int i=2;i<m+1;i++) {
			for(int j=2;j<n+1;j++) {
				//웅덩이가 아니면
				if(board[i][j]!=-1) {
					//현재 위치의 경우의 수 = 왼쪽 + 위
					int up=board[i-1][j]<0?0:board[i-1][j];
					int left=board[i][j-1]<0?0:board[i][j-1];
					//1,000,000,007로 나눈 나머지 값을 반환
					board[i][j]=up+left>1000000007?up+left-1000000007:up+left;
				}
			}
		}
		return board[m][n];
	}
	public static void main(String[] args) {
		int m=4,n=3;
		int[][] p= {{2,2}};
		System.out.println(solution(m, n, p));
		
	}
}
