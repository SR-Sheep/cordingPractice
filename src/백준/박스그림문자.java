package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 박스그림문자 {
	
	//https://www.acmicpc.net/problem/23038
	
	static char[][] Board;
	static int N, M;
	static int[][] D1= {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void masterpiece() {
		for(int r=1;r<N*3;r+=3) {
			for(int c=1;c<M*3;c+=3) {
				if((r+c)%2!=0) {
					Board[r][c]='#';
					for(int i=0;i<4;i++) {
						int nr=r+2*D1[i][0];
						int nc=c+2*D1[i][1];
						if(nr<0||nr>=N*3||nc<0||nc>=M*3) continue;
						if(Board[nr][nc]=='#') {
							Board[r+D1[i][0]][c+D1[i][1]]='#';
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Board=new char[N*3][M*3];
		for(int i=0;i<N*3;i++) {
			Board[i]=br.readLine().toCharArray();
		}
		masterpiece();
		
		for(int i=0;i<N*3;i++) {
			for(int j=0;j<M*3;j++) {
				bw.append(Board[i][j]);
			}
			bw.append("\n");
		}
		br.close();
		bw.close();
	}
}
