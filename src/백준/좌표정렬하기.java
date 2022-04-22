package 백준;

import java.io.*;
import java.util.*;

public class 좌표정렬하기 {
	
	//https://www.acmicpc.net/problem/11650
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) return 1;
				else if(o1[0]<o2[0]) return -1;
				else {
					if(o1[1]>o2[1]) return 1;
					else if(o1[1]<o2[1]) return -1;
					else return 0;
				}
			}
		});
		
		for(int[] tmp:arr) bw.append(tmp[0]+" "+tmp[1]+"\n");
		br.close();
		bw.close();
	}
}
