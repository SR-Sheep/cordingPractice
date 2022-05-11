package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 참외밭 {
	//https://www.acmicpc.net/problem/2477
	
	public static int getKoreanMelonCount(int n, int[][] arrows) {
		//가로 세로 최대값 탐색
		int maxWidth = 0, maxHeight = 0;
		for(int[] arrow:arrows) {
			//동,서
			if(arrow[0]<3) {
				maxWidth=Math.max(maxWidth, arrow[1]);
			//남,북
			}else {
				maxHeight=Math.max(arrow[1], maxHeight);
			}
		}
		//최대값 양 옆의 변의 길이 차 구하기
		int diffW = -1, diffH = -1;
		for(int i=0;i<6;i++) {
			int[] arrow = arrows[i];
			//이전 변의 idx
			int beforeIdx = i==0?5:i-1;
			//다음 별의 idx
			int nextIdx = i==5?0:i+1;
			//현재 변이 가로며, 가로 최대길이라면
			if(arrow[0]<3&&arrow[1]==maxWidth) {
				//높이의 차
				diffH = arrows[beforeIdx][1]-arrows[nextIdx][1];
				//음수 보정
				diffH = diffH<0?-diffH:diffH;
			//현재 변이 세로며, 세로 최대길이라면
			}else if(arrow[0]>2&&arrow[1]==maxHeight) {
				//너비의 차
				diffW = arrows[beforeIdx][1]-arrows[nextIdx][1];
				//음수 보정
				diffW = diffW<0?-diffW:diffW;
			}
		}
		//밭의 넓이 = 큰사각형 - 작은 사각형
		int area = maxHeight*maxWidth - diffW*diffH;
		//1밭 당 참외 재배수 * 밭의 넓이
		return n*area;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1밭당 재배 참외 수
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//밭의 경계 이동 방향 및 길이를 저장할 배열
		int[][] arrows = new int[6][2];
		for(int i=0;i<6;i++) {
			st=new StringTokenizer(br.readLine());
			//경계 이동 방향
			arrows[i][0] = Integer.parseInt(st.nextToken());
			//길이
			arrows[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(getKoreanMelonCount(n, arrows));
		br.close();
	}
}
