package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 위클리_교점에별만들기 {
	/*
	Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때,
	이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
	직선 A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다.
	이때 모든 별을 포함하는 최소 사각형을 return 하도록 solution 함수를 완성해주세요.

	제한사항
	line의 세로(행) 길이는 2 이상 1,000 이하인 자연수입니다.
	line의 가로(열) 길이는 3입니다.
	line의 각 원소는 [A, B, C] 형태입니다.
	A, B, C는 -100,000 이상 100,000 이하인 정수입니다.
	무수히 많은 교점이 생기는 직선 쌍은 주어지지 않습니다.
	A = 0이면서 B = 0인 경우는 주어지지 않습니다.
	정답은 1,000 * 1,000 크기 이내에서 표현됩니다.
	별이 한 개 이상 그려지는 입력만 주어집니다.
	*/
	//답을 넣을 list
	static List<Long[]> Stars;
	//x y의 최소 최대값
	static Long XMin,XMax,YMin,YMax;
	
	//교점 구하기
	public static void meetPoint(int[] m, int[] n) {
		long a=m[0], b=m[1], e=m[2];
		long c=n[0], d=n[1], f=n[2];
		
		double gradient =a*d-b*c;
		if(gradient==0) return;
		
		double x = (b*f-e*d)/gradient;
		double y = (e*c-a*f)/gradient;
		//기울기가 0이면 리턴
		if(x-(long)x!=0||y-(long)y!=0) return;
		//x 최대 최소, y 최대 최소 설정
		XMin=Math.min(XMin,(long)x);
		XMax=Math.max(XMax, (long)x);
		YMin=Math.min(YMin,(long)y);
		YMax=Math.max(YMax, (long)y);
		//리스트에 좌표값 추가
		Stars.add(new Long[] {(long)x,(long)y});
	}
	
    public static String[] solution(int[][] line) {
        Stars=new ArrayList<>();
        XMin=YMin=Long.MAX_VALUE;
        XMax=YMax=Long.MIN_VALUE;
        //좌표값 넣기
        for(int i=0;i<line.length-1;i++) {
        	for(int j=i+1;j<line.length;j++) {
        		meetPoint(line[i], line[j]);
        	}
        }
        //y의 길이(row)
        int ylength=(int)(YMax-YMin+1);
        //x의 길이(col)
        int xlength=(int)(XMax-XMin+1);
        //값을 집어넣을 임시 2차 배열 생성
        String[][] tmp = new String[ylength][xlength];
        //답을 넣을 1차 배열 생성
        String[] answer = new String[ylength];
        //임시 배열 .으로 채우기
        for(int y=0;y<YMax-YMin+1;y++) {
        	for(int x=0;x<XMax-XMin+1;x++) {
        		tmp[y][x]=".";
        	}
        }
        //해당 좌표값에 * 넣기
        for(Long[] star:Stars) {
        	int yidx =(int)(-YMin+star[1]);
        	int xidx=(int)(-XMin+star[0]);
        	tmp[yidx][xidx]="*";
        }
        //해당 좌표값을 역순으로 삽입
        for(int i=0;i<YMax-YMin+1;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(String s:tmp[ylength-1-i]) {
        		sb.append(s);
        	}
        	answer[i]=sb.toString();
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		for(String s:solution(line)) {
			System.out.println(s);
		};
	}

}
