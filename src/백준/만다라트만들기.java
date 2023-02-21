package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 만다라트만들기 {
	//https://www.acmicpc.net/problem/27495
	static HashMap<String, List<String>> MandaMap = new HashMap<>();
	//주변부를 추가해주는 메서드
	public static void putEdgeKeyword(String[][] board, int r, int c) {
		String mid =board[r][c];
		List<String> tmpList = MandaMap.get(mid);
		for(int i=r-1;i<r+2;i++) {
			for(int j=c-1;j<c+2;j++) {
				if(i!=r||j!=c) {
					tmpList.add(board[i][j]);
				}
			}
		}
		Collections.sort(tmpList);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//만다라트 입력
		String[][] board = new String[9][9];
		StringTokenizer st;
		for(int i=0;i<9;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				board[i][j] = st.nextToken();
			}
		}
		//만다라트 중간 목표
		List<String> titles = new ArrayList<>();
		for(int i=3;i<6;i++) {
			for(int j=3;j<6;j++) {
				if(i!=4||j!=4) {
					String goal = board[i][j];
					titles.add(goal); //중간 목표
					//중간 목표를 키로 하는 맵 생성
					MandaMap.put(goal,new ArrayList<>());
				}
			}
		}
		//중간목표에 행동 추가
		int r =-1, c =-1;
		for(int i=0;i<3;i++) {
			r = 1+i*3;
			for(int j=0;j<3;j++) {
				if(i!=1||j!=1) {
					c=1+j*3;
					putEdgeKeyword(board,r,c);
				}
			}
		}
		//정렬
		Collections.sort(titles);
		//출력
		int order = 0;
		for(String key:titles) {
			bw.append("#"+ ++order+". "+key+"\n");
			int secondOrder = 0;
			for(String goal:MandaMap.get(key)) {
				bw.append("#"+ order+"-"+ ++secondOrder+". "+goal+"\n");
			}
		}
		bw.close();
		br.close();
	}
}
