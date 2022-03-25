package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 밥 {
	//https://www.acmicpc.net/problem/23559
	
	public static int solution(int n, int money, int[][] lunch) {
		//5천원 메뉴를 먹을 수 있는 최대 개수
		//(모든 메뉴를 1000원어치를 사먹고 각 4천원씩 추가하여 메뉴 업그래이드)
		int l = (money-n*1000)/4000;
		//런치 가성비가 큰 순 정렬 (A 가성비 - B 가성비)
		Arrays.sort(lunch, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]-o1[1]>(o2[0]-o2[1])) return -1;
				else if(o1[0]-o1[1]<(o2[0]-o2[1])) return 1;
				else {
					if(o1[0]>o2[0]) return -1;
					else if(o1[0]<o2[0]) return 1;
					else return 0;
				}
			}
		});
		int answer=0;
		//탐색
		for(int[] cost:lunch) {
			int five = cost[0]; //5천원 값어치
			int one = cost[1]; //천원 값어치
			//아직 5천원 메뉴를 먹을 수 있고, 값어치가 5천원이 더 크다면
			if(l>0&&five>one) {
				answer+=five; //답에 5천원 값어치 추가
				l--; //5천원 가지수 감소
			//5천원 메뉴를 더 이상 살 수 없거나, 천원의 값어치가 5천원 이상이라면
			}else {
				answer+=one; //답에 천원 값어치 추가
			}
		}
		//답 출력
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //가지수
		int money = Integer.parseInt(st.nextToken()); //가지고 있는 돈
		
		int[][] lunch = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			lunch[i][0]=Integer.parseInt(st.nextToken()); //5천원 값어치
			lunch[i][1]=Integer.parseInt(st.nextToken()); //천원 값어치
		}
		br.close();
		//출력
		System.out.println(solution(n,money, lunch));
	}

}
