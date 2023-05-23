package etc;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
//		StringTokenizer st=new StringTokenizer(br.readLine());
//		int t=Integer.parseInt(st.nextToken());
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(br.readLine());
			int b=Integer.parseInt(st.nextToken());
		}
		bw.close();
		br.close();
	}
}
