package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 증가배열만들기 {
	//https://www.acmicpc.net/problem/27648
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		//불가
		if(n+m>=k+2) {
			bw.append("NO");
		}else {
			bw.append("YES\n");
			for(int i=1;i<=n;i++) {
				for(int j=0;j<m;j++) {
					bw.append((i+j)+" ");
				}
				bw.append("\n");
			}
		}
		bw.close();
		br.close();
	}
}
