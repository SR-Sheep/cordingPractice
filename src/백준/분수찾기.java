package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 분수찾기 {
	
	//https://www.acmicpc.net/problem/1193
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int sum=0;
		int count =0;
		while(sum<n) {
			sum+=count++;
		}
		count--;
		sum-=count;
		n-=sum;
		int r=0,c=0;
		if(count%2==0) {
			r=0;
			c=count-1;
			while(n>1){
				r++;
				c--;
				n--;
			}
		}else {
			r=count-1;
			c=0;
			while(n>1){
				r--;
				c++;
				n--;
			}
		}
		bw.write((r+1)+"/"+(c+1)+"\n");
		br.close();
		bw.close();
	}
}
