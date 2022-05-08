package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequenceConversion {
	//https://www.acmicpc.net/problem/25114
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		long[] befores =new long[n];
		long[] afters =new long[n];
		for(int i=0;i<n;i++) {
			befores[i]=Long.parseLong(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			afters[i]=Long.parseLong(st.nextToken());
		}
		
		int count=0;
		
		for(int i=0;i<n-1;i++) {
			long before = befores[i];
			long after = afters[i];
			if(before!=after) {
				count++;
				long x = before^after;
				befores[i]=after;
				befores[i+1]=befores[i+1]^x;
			}
		}
		
		if(befores[n-1]!=afters[n-1]) {
			count=-1;
		}
		System.out.println(count);
		br.close();
	}
}
