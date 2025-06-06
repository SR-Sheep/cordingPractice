package 프로그래머스;

public class 코드챌린지1_삼각달팽이 {
	/*
	정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서
	맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
	첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
	*/
	static int[][] Board;
	
	public static void triangle(int n) {
    	int r=0, c=0; //초기 행 렬
    	int num=1; //들어갈 숫자
    	int count=n; //횟수
    	while(count>0) {
    		//아래쪽
    		while(r<Board.length&&Board[r][c]==0) {
    			Board[r++][c]=num++;
    		}
    		r--;
    		c++;
			//오른쪽
			while(c<Board.length&&Board[r][c]==0) {
    			Board[r][c++]=num++;	
    		}
			r--;
			c-=2;
			//대각선
			while(r>0&&c>0&&Board[r][c]==0) {
				Board[r--][c--]=num++;
			}
			r+=2;
			c++;
    		count-=3;
    	}
	}
	
    public static int[] solution(int n) {
        int len = n*(n+1)/2;
        int[] answer = new int[len];
        Board = new int[n][n];
        
        triangle(n);
        //보드 확인
        for(int[] b:Board) {
        	for(int i:b){
        		System.out.print(i+"\t");
        	}
        	System.out.println();
        }
        //답 넣기
        int idx=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<=i;j++) {
        		answer[idx++]=Board[i][j];
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int n=5;
		for(int i:solution(n))System.out.print(i+" ");;
	}

}
