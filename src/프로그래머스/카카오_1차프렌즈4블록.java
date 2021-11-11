package 프로그래머스;

import java.util.Stack;

public class 카카오_1차프렌즈4블록 {
	//https://programmers.co.kr/learn/courses/30/lessons/17679
	//전략 : 해당칸의 문자가 밑, 오른쪽, 오른쪽 밑과 같으면 visited에 1 넣기
	//-> visited 값을 모두 더한 뒤 변화가 없으면 0 리턴
	//-> 변화가 있으면 stack을 이용하여 문자 내리기, 빈공간은 * 넣기
	//-> visited값을 모두 더한 값 + 재귀 리턴
	
	static int Row,Col;
	static char[][] Board;
	
	public static int pop() {
		int[][] visited = new int[Row][Col];
		//검색, 왼쪽 상단 기준 2*2이므로 행과 열 1씩 빼서 돌림
		for(int i=0;i<Row-1;i++) {
			for(int j=0;j<Col-1;j++) {
				char c = Board[i][j];
				if(c=='*') continue; //빈공간이면 컨티뉴
				if(c==Board[i+1][j]&&c==Board[i][j+1]&&c==Board[i+1][j+1]) { //밑, 오른쪽, 오른쪽 아래 대각선이 같다면
					visited[i][j]=1;
					visited[i+1][j]=1;
					visited[i][j+1]=1;
					visited[i+1][j+1]=1;
					//visited에 2*2 모두 체크
				}
			}
		}
		//카운팅
		int count=0;
		for(int[] v:visited) {
			for(int i:v) count+=i;
		}
		//카운틴 결과가 0이면 0 리턴
		if(count==0) return 0;
		//블록 내리기
		for(int j=0;j<Col;j++) {
			Stack<Character> st = new Stack<Character>();
			//비어있지 않으면 스택에 넣기
			for(int i=0;i<Row;i++) {
				if(visited[i][j]!=1) st.push(Board[i][j]);
			}
			//맨 밑에서 부터 채우기
			int idx=Row-1;
			while(!st.isEmpty()) {
				Board[idx--][j]=st.pop();
			}
			//스택이 빈 idx부터 * 채우기
			for(int i=idx;i>=0;i--) {
				Board[i][j]='*';
			}
		}
		//카운팅 횟수 + 재귀
		return count+pop();
	}
	
	
    public static int solution(int m, int n, String[] board) {
    	//초기값 설정
        Row=m;
        Col=n;
        Board=new char[Row][Col];
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length();j++) {
        		Board[i][j]=board[i].charAt(j);
        	}
        }
        //계산 실행
        return pop();
    }
    
	public static void main(String[] args) {
		int m=6,n=6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m, n, board));
	}
}
