package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 약수 {
	//https://www.acmicpc.net/problem/1037
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		long max = 0l,tmp = 0l,min = 1000001;
		//1과 양수 A를 제외한 약수 중 최대값과 최소값을 곱해 A를 구한다.
		for(int i=0;i<n;i++) {
            tmp= Long.parseLong(st.nextToken());
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
		}
		bw.append(max*min+"\n");
		br.close();
		bw.close();
	}
}
