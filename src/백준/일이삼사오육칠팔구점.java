package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이삼사오육칠팔구점 {
	//https://www.acmicpc.net/problem/24394
	
	static StringBuilder Sb;
	static final long DefalutScore=1000000000;
	
	public static void playNote(long n, long score) {
		double goodScore = (double)DefalutScore /(double)(2*n);
		long abc1 = (long)((double)score/goodScore);
		long abc2 = (long)Math.ceil((double)(score+1)/goodScore);
		long abc = -1;
		long a = -1;
//		System.out.println("입력 : "+n+" "+score);
//		System.out.println("abc : "+abc1+" "+abc2);
		for(long l=abc1;l<abc2;l++) {
			a = score-(DefalutScore*l/(2*n));
			if(a>n) continue;
//			System.out.println("a : "+a);
			long bc = l-a*2; //2b + c;
//				System.out.println(bc);
//			System.out.println("bc : "+bc);
			if(bc>=0) {
				abc=l;
				break;
			}
		}
		if(abc==-1) {
			Sb.append("-1\n");
		}else {
			Sb.append(abc+" ").append(a+"\n");
		}
//		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			long score=Long.parseLong(st.nextToken());
			playNote(n, score);
		}
		System.out.println(Sb);
		br.close();
	}
	
//	public static void main(String[] args) {
//		Sb = new StringBuilder();
//		long[][] questions = {{1000,1000001000},{4318,899954000},{20000,123456789}
//		,{3,1000000002},{3,166666666},{6,333333334},{1,1000000000}};
//		
//		for(long[] q:questions) {
//			playNote(q[0], q[1]);
//		}
//		
//		System.out.println(Sb);
//	}
}
