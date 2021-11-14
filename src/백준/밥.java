package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 밥 {
	
	public static void solution(int n, int money, int[][] lunch) {
		int l = (money-n*1000)/4000; //5000 최대값
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
		for(int[] cost:lunch) {
			int five = cost[0];
			int one = cost[1];
			if(l>0&&five>one) {
				answer+=five;
				l--;
			}else {
				answer+=one;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		
		int[][] lunch = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			lunch[i][0]=Integer.parseInt(st.nextToken());
			lunch[i][1]=Integer.parseInt(st.nextToken());
		}
		br.close();
		
		solution(n,money, lunch);
	}

}
