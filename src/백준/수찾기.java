package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {
	//https://www.acmicpc.net/problem/1920
	
	static int[] Arr;
	//이분탐색을 통한 수 찾기
	public static int isExist(int num) {
		int left = 0, right = Arr.length-1, mid = -1;
		while(left<=right) {
			mid=(left+right)/2;
			if(Arr[mid]<num) {
				left = mid+1;
			}else if(Arr[mid]>num) {
				right = mid-1;
			}else {
				return 1;
			}
		}
		return 0;
	} 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Arr = new int[n];
		for(int i=0;i<n;i++) {
			Arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Arr);
		n = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			bw.append(isExist(num)+"\n");
		}
		br.close();
		bw.close();
	}
}
