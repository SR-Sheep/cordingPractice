package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 신나는함수실행 {
	//https://www.acmicpc.net/problem/9184
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][][] exciting= new int[51][51][51];
		
		for(int i=0;i<21;i++) {
			for(int j=0;j<21;j++) {
				for(int k=0;k<21;k++) {
					if(i<=0||j<=0||k<=0) {
						exciting[i][j][k]=1;
					}else if(i<j&&j<k) {
						exciting[i][j][k]=exciting[i][j][k-1]+exciting[i][j-1][k-1]-exciting[i][j-1][k];
					}else {
						exciting[i][j][k]=exciting[i-1][j][k]+exciting[i-1][j-1][k]+exciting[i-1][j][k-1]-exciting[i-1][j-1][k-1];
					}
				}
			}
		}
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int a =Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		int c =Integer.parseInt(st.nextToken());
			
		while(a!=-1||b!=-1||c!=-1) {
			bw.append("w("+a+", "+b+", "+c+") = ");
			if(a<=0||b<=0||c<=0) {
				bw.append(1+"\n");
			}else if(a>20||b>20||c>20){
				bw.append(exciting[20][20][20]+"\n");
			}else {
				bw.append(exciting[a][b][c]+"\n");
			}
			//다음수
			st=new StringTokenizer(br.readLine());
			a =Integer.parseInt(st.nextToken());
			b =Integer.parseInt(st.nextToken());
			c =Integer.parseInt(st.nextToken());
			
		}	
			
		br.close();
		bw.close();
	}
}
