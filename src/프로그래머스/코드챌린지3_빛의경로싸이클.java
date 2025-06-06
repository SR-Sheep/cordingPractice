package 프로그래머스;

import java.util.*;

public class 코드챌린지3_빛의경로싸이클 {
    //https://programmers.co.kr/learn/courses/30/lessons/86052
	/*
	문제 설명
	각 칸마다 S, L, 또는 R가 써져 있는 격자가 있습니다. 당신은 이 격자에서 빛을 쏘고자 합니다. 이 격자의 각 칸에는 다음과 같은 특이한 성질이 있습니다.

	빛이 "S"가 써진 칸에 도달한 경우, 직진합니다.
	빛이 "L"이 써진 칸에 도달한 경우, 좌회전을 합니다.
	빛이 "R"이 써진 칸에 도달한 경우, 우회전을 합니다.
	빛이 격자의 끝을 넘어갈 경우, 반대쪽 끝으로 다시 돌아옵니다. 예를 들어, 빛이 1행에서 행이 줄어드는 방향으로 이동할 경우, 같은 열의 반대쪽 끝 행으로 다시 돌아옵니다.
	당신은 이 격자 내에서 빛이 이동할 수 있는 경로 사이클이 몇 개 있고, 각 사이클의 길이가 얼마인지 알고 싶습니다. 경로 사이클이란, 빛이 이동하는 순환 경로를 의미합니다.
	
	격자의 정보를 나타내는 1차원 문자열 배열 grid가 매개변수로 주어집니다.
	주어진 격자를 통해 만들어지는 빛의 경로 사이클의 모든 길이들을 배열에 담아 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해주세요.

	제한사항
	1 ≤ grid의 길이 ≤ 500
	1 ≤ grid의 각 문자열의 길이 ≤ 500
	grid의 모든 문자열의 길이는 서로 같습니다.
	grid의 모든 문자열은 'L', 'R', 'S'로 이루어져 있습니다.
	*/
	
    //아래, 위, 왼쪽 , 오른쪽
    static int[][] D={{1,0},{-1,0},{0,-1},{0,1}};
    //아래, 위, 왼쪽 , 오른쪽
    static int[][] R={{0,-1},{0,1},{-1,0},{1,0}};
    //아래, 위, 왼쪽 , 오른쪽           
    static int[][] L={{0,1},{0,-1},{1,0},{-1,0}};
    static Node[][] Board;
    static int Row,Col;
    
    static class Node{
        private char type;
        private boolean[] visited;
        public Node(char type){
            this.type=type;
            visited=new boolean[4];
        }
        
        public int search(int direction,int r, int c){
            int count=0;
            //현재 위치
            Node curr=Board[r][c];
            while(!curr.visited[direction]){
                curr.visited[direction]=true;
                //다음 좌표값
                int nr=0,nc=0;
                if(curr.type=='R'){
                    nr=r+R[direction][0];
                    nc=c+R[direction][1];
                }else if(curr.type=='L'){
                    nr=r+L[direction][0];
                    nc=c+L[direction][1];
                }else{
                    nr=r+D[direction][0];
                    nc=c+D[direction][1];
                }
                //방향 설정
                //아래
                if(r<nr) direction=0;
                //위
                else if(r>nr) direction=1;
                //왼쪽
                else if(c>nc) direction=2;
                //오른쪽
                else if(c<nc) direction=3;
                
                //넘어가면 보정
                if(nr<0) nr=Row-1;
                else if(nr>=Row) nr=0;
                if(nc<0) nc=Col-1;
                else if(nc>=Col) nc=0;
                
                //현재 위치 업데이트
                r=nr;
                c=nc;
                curr=Board[r][c];
                //횟수 증가
                count++;
            }
            
            return count;
        }
        
    }

    public static List<Integer> solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        Row = grid.length;
        Col = grid[0].length();
        Board=new Node[Row][Col];
        //삽입
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                Board[i][j]=new Node(grid[i].charAt(j));
            }
        }
        
        //탐색
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                for(int d=0;d<4;d++){
                    int count = Board[i][j].search(d,i,j);
                    if(count!=0) answer.add(count);
                }
                
            }
        }
        //정렬
        Collections.sort(answer);
        return answer;
    }
    
    public static void main(String[] args) {
		String[][] gd = {{"SL","LR"},{"S"},{"R","R"}};
		for(String[] s:gd) {
			System.out.println(solution(s));
		}
    }
}
