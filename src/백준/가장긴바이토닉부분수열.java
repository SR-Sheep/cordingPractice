package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {
	//https://www.acmicpc.net/problem/11054
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] bitonic = new int[n+1];
		int[] forward = new int[n+1];
		int[] backward = new int[n+1];
		forward[1]=backward[n]=1;
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			bitonic[i]=Integer.parseInt(st.nextToken());
			forward[i]=1;
			for(int j=1;j<i;j++) {
				if(bitonic[j]<bitonic[i]) {
					forward[i]=Math.max(forward[i], forward[j]+1);
				}
			}
		}
		int answer = 0;
		for(int i=n;i>=1;i--) {
			backward[i]=1;
			for(int j=n;j>i;j--) {
				if(bitonic[j]<bitonic[i]) {
					backward[i]=Math.max(backward[i], backward[j]+1);
				}
			}
			answer=Math.max(answer, forward[i]+backward[i]-1);
		}
		System.out.println(answer);
		br.close();
	}
}
