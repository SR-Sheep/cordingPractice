package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 나무자르기 {
	//https://www.acmicpc.net/problem/2805
	
	static long[] Trees;
	
	public static long sumCuttingTrees (long saw) {
		long sum = 0;
		for(long l:Trees) {
			if(l>saw) sum+=l-saw;
		}
		return sum;
	}
	
	public static long cutTree(long max, int count) {
		long left = 0, right = max, mid=-1;
		long answer = 0;
		while(left<=right) {
			mid=(left+right)/2;
			if(sumCuttingTrees(mid)>=count) {
				answer=mid; //답 업데이트
				left=mid+1; //길이 늘리기(최소값 상승)
			}else{
				right=mid-1; //기준 갯수보다 적으면 길이 좁히기(최대값 하락)
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int count=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		Trees=new long[n]; //나무길이를 저장할 배열
		long max = 0; //최대값 초기화
		for(int i=0;i<n;i++) {
			Trees[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, Trees[i]);
		}
		bw.append(cutTree(max,count)+"\n");
		br.close();
		bw.close();
	}
}
