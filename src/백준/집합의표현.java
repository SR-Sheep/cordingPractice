package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 집합의표현 {
	//https://www.acmicpc.net/problem/1717
	
	static int[] Roots;
	
	static int getRoot(int num) {
		if(Roots[num]==num) {
			return num;
		}
		return Roots[num]=getRoot(Roots[num]);
	}
	
	static void setRoot(int a, int b) {
		if(a>b) {
			int tmp = a;
			a = b;
			b= tmp;
		}
		Roots[getRoot(b)]=getRoot(a);
	}
	
	static boolean isSameRoot(int a, int b) {
		return getRoot(a)==getRoot(b);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		
		Roots=new int[n+1];
		for(int i=1;i<n+1;i++) {
			Roots[i]=i;
		}
		
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken());
			int setA=Integer.parseInt(st.nextToken());
			int setB=Integer.parseInt(st.nextToken());
			if(cmd==0) {
				setRoot(setA, setB);
			}else {
				if(isSameRoot(setA, setB)) {
					bw.append("YES\n");
				}else {
					bw.append("NO\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
