package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간합구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[] accuNums = new int[n+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			accuNums[i]=accuNums[i-1]+Integer.parseInt(st.nextToken());
		}
		int s,e;
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			bw.append(accuNums[e]-accuNums[s-1]+"\n");
		}
		br.close();
		bw.close();
	}
}
