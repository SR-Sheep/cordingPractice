package 백준;

import java.io.*;
import java.util.*;

public class 가장_긴_증가하는_부분_수열_4 {
	public static List<Integer> solution(int[] arr) {
		List<Integer> answer = new ArrayList<Integer>();
		int n= arr.length;
		int[] dp = new int[n+1]; //최대 길이
		int[] tmp = new int[n+1]; //이전 참조 인덱스 값
		
		int result = 0, resultIdx=0;
		//arr 탐색
		for(int i=0;i<n;i++) {
			//기본값 1(본인의 크기)
			dp[i]=1;
			//본인보다 작은 값 탐색
			for(int j=0;j<i;j++) {
				//본인 길이보다 작고, 이 중 최대 길이값을 취함
				if(arr[i]>arr[j]&&dp[j]>=dp[i]) {
					dp[i]=dp[j]+1; //해당 길이보다 1 큼 (본인 크기 추가)
					tmp[i]=j; //최대길이 인덱스 기록
				}
			}
			//답과 해당 인덱스 값 기록
			if(dp[i]>result) {
				result = dp[i];
				resultIdx=i;
			}
		}

		for(int i=0;i<result;i++) {
			answer.add(0,arr[resultIdx]);
			resultIdx = tmp[resultIdx];
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		List<Integer> list = solution(arr);
		StringBuilder sb=new StringBuilder();
		for(Integer i:list) sb.append(i+" ");
		br.close();
		bw.write(list.size()+"\n");
		bw.write(sb.toString().trim()+"\n");
		bw.close();
		
	}
}
