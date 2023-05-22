package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/16466
public class 콘서트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		long[] arr = new long[t];
		
		for(int i=0;i<t;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		//정렬
		Arrays.sort(arr);
		//최소값
		long curr = 1;
		long answer = -1;
		for(int i=0;i<t;i++) {
			if(curr==arr[i]) {
				curr++;
			}else {
				answer = curr;
				break;
			}
		}
		System.out.println(answer<0?curr:answer);
		br.close();
	}
}
