package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 카카오_기둥과보설치 {
	static boolean[][] P; //기둥
	static boolean[][] F; //보
	static int N;
	
	public static boolean isOK(int r, int c, int kind) {
		if(kind==0) { //기둥이라면
			if(r!=0) {
				//밑에 기둥이 있을때
				if(P[r-1][c]) return true;
				//왼쪽에 발판이 있을 때
				else if(c>0&&F[r][c-1]) return true;
				//오른쪽에 발판이 있을 때
				else if(F[r][c]) return true;
			}else return true;
		}else { //보 라면
			if(r==0) return false;
			//왼 밑에 기둥이 있을 때
			if(P[r-1][c]) return true;
			//오른 밑에 기둥이 있을 때
			if(c<N&&P[r-1][c+1]) return true;
			//양 옆에 보가 있을 때
			if(c<N&&c>0&&F[r][c-1]&&F[r][c+1]) return true;
		}
		return false;
	}
	
    public static int[][] solution(int n, int[][] build_frame) {
        //x,y,(기둥, 보),(삭제, 설치)
    	P=new boolean[n+1][n+1]; //맨 위에는 세울 수 없음
    	F=new boolean[n+1][n+1]; //맨 오른쪽에는 세울 수 없음
    	N=n;
    	for(int[] bf:build_frame) {
    		int c = bf[0];
    		int r = bf[1];
    		int kind = bf[2];
    		int action = bf[3];
    		//기둥
    		if(kind==0) {
    			//삭제
    			if(action==0) {
    				//삭제
    				P[r][c]=false;
    				//전체 탐색
                    boolean pPass=true;
                    boolean fPass=true;
                    for(int i=0;i<n+1;i++){
                        for(int j=0;j<n+1;j++){
                            if(P[i][j]) pPass=isOK(i,j,0);
                            if(F[i][j]) fPass=isOK(i,j,1);
                            if(!pPass||!fPass) break;
                        }
                        if(!pPass||!fPass) break;
                    }
                    if(!pPass||!fPass) P[r][c]=true;
				//설치
    			}else {
    				P[r][c]=isOK(r,c,kind);
    			}
    		//보	
    		}else {
    			//바닥에는 설치 불가
    			if(r==0) continue;
    			//삭제
    			if(action==0) {
    				F[r][c]=false;
                    boolean pPass=true;
                    boolean fPass=true;
                    for(int i=0;i<n+1;i++){
                        for(int j=0;j<n+1;j++){
                            if(P[i][j]) pPass=isOK(i,j,0);
                            if(F[i][j]) fPass=isOK(i,j,1);
                            if(!pPass||!fPass) break;
                        }
                        if(!pPass||!fPass) break;
                    }
                    if(!pPass||!fPass) F[r][c]=true;
				//설치
    			}else {
    				F[r][c]=isOK(r, c, kind);
    			}
    		}
    	}
    	List<int[]> list = new ArrayList<>();
    	for(int i=0;i<n+1;i++) {
    		for(int j=0;j<n+1;j++) {
    			if(P[i][j]) list.add(new int[] {j,i,0});
    			if(F[i][j]) list.add(new int[] {j,i,1});
    		}
    	}
    	
    	Collections.sort(list,new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			if(o1[0]>o2[0]) return 1;
    			else if(o1[0]<o2[0]) return -1;
    			else {
    				if(o1[1]>o2[1]) return 1;
        			else if(o1[1]<o2[1]) return -1;
        			else {
        				if(o1[2]>o2[2]) return 1;
            			else if(o1[2]<o2[2]) return -1;
        				else return 0;
        			}
    			}
    		}
    	});
    	
    	int[][] answer = new int[list.size()][3];
    	for(int i=0;i<list.size();i++) {
    		answer[i]=list.get(i);
    	}
    	
    	for(int[] tmp:list) {
    		System.out.print(tmp[0]+" "+tmp[1]+" "+tmp[2] + " // ");
    	}
    	System.out.println("기둥");
    	for(boolean[] tmp:P) {
    		for(boolean b:tmp) System.out.print(b?"O ":"X ");
    		System.out.println();
    	}
    	System.out.println();
    	System.out.println("바닥");
    	for(boolean[] tmp:F) {
    		for(boolean b:tmp) System.out.print(b?"O ":"X ");
    		System.out.println();
    	}
        return answer;
    }
	
	public static void main(String[] args) {
		int n=5;
//		int[][] bf = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] bf = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0}};
		for(int[] a:solution(n, bf)) {
			for(int i:a) System.out.print(i+" ");
			System.out.println();
		}
	}
}
