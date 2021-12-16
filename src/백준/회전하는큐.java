package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 회전하는큐 {
	//https://www.acmicpc.net/problem/1021
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) list.add(i);
		int r = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		
		int answer = 0; //답
		int forward = 0; //순방향
		int backward = 0; //역방향
		while(r-->0) {
			int goal = Integer.parseInt(st.nextToken()); //목표
			int count=0; //횟수
            //둘 중 하나라도 답이면 종료
			while(list.get(forward)!=goal&&list.get(backward)!=goal) {
				forward++; //순방향 진행
				backward--; //역방향 진행
				if(forward>=list.size()) {
					forward=0; //범위 넘어가면 0
				}
				if(backward<0) {
					backward=list.size()-1; //범위 넘어가면 맨 마지막
				}
				count++; //횟수 증가
			}
            //순방향이 답일 경우
			if(list.get(forward)==goal) {
				list.remove(forward); //순방향 제거
				if(forward==list.size()) forward=0; //마지막 요소였다면 0으로 변경
				backward=forward; //역방향 보정
			//역방향이 답일 경우
			}else {
				list.remove(backward); //역방향 제거
				if(backward==list.size()) backward=0; //마지막 요소였다면 0으로 변경
				forward=backward; //순방향 보정
			}
			answer+=count; //횟수만큼 답 증가
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
