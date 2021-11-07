package ���α׷��ӽ�;

import java.util.*;

public class �ڵ�ç����3_���ǰ�ν���Ŭ {
    //https://programmers.co.kr/learn/courses/30/lessons/86052
	/*
	���� ����
	�� ĭ���� S, L, �Ǵ� R�� ���� �ִ� ���ڰ� �ֽ��ϴ�. ����� �� ���ڿ��� ���� ����� �մϴ�. �� ������ �� ĭ���� ������ ���� Ư���� ������ �ֽ��ϴ�.

	���� "S"�� ���� ĭ�� ������ ���, �����մϴ�.
	���� "L"�� ���� ĭ�� ������ ���, ��ȸ���� �մϴ�.
	���� "R"�� ���� ĭ�� ������ ���, ��ȸ���� �մϴ�.
	���� ������ ���� �Ѿ ���, �ݴ��� ������ �ٽ� ���ƿɴϴ�. ���� ���, ���� 1�࿡�� ���� �پ��� �������� �̵��� ���, ���� ���� �ݴ��� �� ������ �ٽ� ���ƿɴϴ�.
	����� �� ���� ������ ���� �̵��� �� �ִ� ��� ����Ŭ�� �� �� �ְ�, �� ����Ŭ�� ���̰� ������ �˰� �ͽ��ϴ�. ��� ����Ŭ�̶�, ���� �̵��ϴ� ��ȯ ��θ� �ǹ��մϴ�.
	
	������ ������ ��Ÿ���� 1���� ���ڿ� �迭 grid�� �Ű������� �־����ϴ�.
	�־��� ���ڸ� ���� ��������� ���� ��� ����Ŭ�� ��� ���̵��� �迭�� ��� ������������ �����Ͽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	1 �� grid�� ���� �� 500
	1 �� grid�� �� ���ڿ��� ���� �� 500
	grid�� ��� ���ڿ��� ���̴� ���� �����ϴ�.
	grid�� ��� ���ڿ��� 'L', 'R', 'S'�� �̷���� �ֽ��ϴ�.
	*/
	
    //�Ʒ�, ��, ���� , ������
    static int[][] D={{1,0},{-1,0},{0,-1},{0,1}};
    //�Ʒ�, ��, ���� , ������
    static int[][] R={{0,-1},{0,1},{-1,0},{1,0}};
    //�Ʒ�, ��, ���� , ������           
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
            //���� ��ġ
            Node curr=Board[r][c];
            while(!curr.visited[direction]){
                curr.visited[direction]=true;
                //���� ��ǥ��
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
                //���� ����
                //�Ʒ�
                if(r<nr) direction=0;
                //��
                else if(r>nr) direction=1;
                //����
                else if(c>nc) direction=2;
                //������
                else if(c<nc) direction=3;
                
                //�Ѿ�� ����
                if(nr<0) nr=Row-1;
                else if(nr>=Row) nr=0;
                if(nc<0) nc=Col-1;
                else if(nc>=Col) nc=0;
                
                //���� ��ġ ������Ʈ
                r=nr;
                c=nc;
                curr=Board[r][c];
                //Ƚ�� ����
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
        //����
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                Board[i][j]=new Node(grid[i].charAt(j));
            }
        }
        
        //Ž��
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                for(int d=0;d<4;d++){
                    int count = Board[i][j].search(d,i,j);
                    if(count!=0) answer.add(count);
                }
                
            }
        }
        //����
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
