package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 시간관리 {
	//https://www.acmicpc.net/problem/1263
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //일의 수
		int[][] tasks = new int[n][2];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			tasks[i][0]=Integer.parseInt(st.nextToken()); //진행시간
			tasks[i][1]=Integer.parseInt(st.nextToken()); //마감시간
		}
		//마감시간 역순으로 정렬
		Arrays.sort(tasks, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]<o2[1]) return 1;
				else if(o1[1]>o2[1]) return -1;
				return 0;
			}
		});
		//현재 시각, 최대값인 100만으로 설정
		int time = 1000000;
		for(int[] task:tasks) {
			int processTime = task[0];
			int completeTime = task[1];
			//마감시간이 현재 시간보다 크면 마감시간을 현재시간으로 변경
			if(completeTime<time) time = completeTime;
			//현재 시간에서 진행시간을 뺌
			time-=processTime;
		}
		
		System.out.println(time<0?-1:time);
		
		br.close();
	}
}
