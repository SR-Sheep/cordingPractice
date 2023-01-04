package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 행렬덧셈 {
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/submit/2738
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); 
		int m=Integer.parseInt(st.nextToken());
		int[][] metrix = new int[n][m]; //2차원 행렬
		//2번 반복
		int count =2;
		while(count-->0) {
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					metrix[i][j]+=Integer.parseInt(st.nextToken());
					//2번째라면 출력
					if(count==0) {
						bw.append(metrix[i][j]+" ");
					}
				}
				//2번째라면 개행
				if(count==0) {
					bw.append("\n");
				}
			}
		}
		//출력
		bw.close();
		br.close();
	}
}
