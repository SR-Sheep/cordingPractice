package 프로그래머스;

public class 코드챌린지1_쿼드압축후세기 {
	static int[] Answer;
	
	public static void zip(int[][] arr) {
		int len=arr.length;
		if(len==1) {
			if(arr[0][0]==0) {
				Answer[0]++;
			}else {
				Answer[1]++;
			}
			return;
		}
		int half = len/2;
		
		int[][] tmpArr=new int[half][half];
		int ridx=0, cidx=0;
		boolean isSame = true;
		
		int tmp=arr[0][0];
		//1 : r,c ~ r+half,c~half
		for(int i=0;i<half;i++) {
			for(int j=0;j<half;j++) {
				if(tmp!=arr[i][j]&&isSame) {
					isSame=false;
				}
				tmpArr[ridx][cidx++]=arr[i][j];
			}
			cidx=0;
			ridx++;
		}
		if(isSame) Answer[tmp]++;
		else zip(tmpArr);
			
		ridx=0;
		cidx=0;
		isSame=true;
		
		//2 : r,c+half
		tmp=arr[0][half];
		
		for(int i=0;i<half;i++) {
			for(int j=half;j<len;j++) {
				if(tmp!=arr[i][j]&&isSame) {
					isSame=false;
				}
				tmpArr[ridx][cidx++]=arr[i][j];
			}
			cidx=0;
			ridx++;
		}
		if(isSame) Answer[tmp]++;
		else zip(tmpArr);
			
		ridx=0;
		cidx=0;
		isSame=true;
		
		tmp=arr[half][0];
		for(int i=half;i<len;i++) {
			for(int j=0;j<half;j++) {
				if(tmp!=arr[i][j]&&isSame) {
					isSame=false;
				}
				tmpArr[ridx][cidx++]=arr[i][j];
			}
			cidx=0;
			ridx++;
		}
		if(isSame) Answer[tmp]++;
		else zip(tmpArr);
			
		ridx=0;
		cidx=0;
		isSame=true;
		
		tmp=arr[half][half];
		
		for(int i=half;i<len;i++) {
			for(int j=half;j<len;j++) {
				if(tmp!=arr[i][j]&&isSame) {
					isSame=false;
				}
				tmpArr[ridx][cidx++]=arr[i][j];
			}
			cidx=0;
			ridx++;
		}
		if(isSame) Answer[tmp]++;
		else zip(tmpArr);
			
		ridx=0;
		cidx=0;
		isSame=true;
	}
	
    public static int[] solution(int[][] arr) {
        Answer=new int[2];
        int start=arr[0][0];
        boolean isSame=true;
        for(int i=0;i<arr.length;i++) {
        	for(int j=0;j<arr.length;j++) {
        		if(start!=arr[i][j]) {
        			isSame=false;
        			break;
        		}
        		if(!isSame)break;
        	}
        }
        if(isSame) Answer[start]++;
        else zip(arr);
    	System.out.println(Answer[0]+" "+Answer[1]);
    	return Answer;
    }
	public static void main(String[] args) {
		int[][] arr={{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int[][] arr2={{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		int[][] arr3= {{0,0},{0,0}};
		System.out.println(solution(arr3));
	}
}
