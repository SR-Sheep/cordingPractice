package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/27942
public class Danceplant {
	static int N;
	static int[][] Board;
	//클래스 선언
	static class DancePlant{
		int sum;
		StringBuilder moveHistory;
		int x,y,width,height;
		//생성자
		public DancePlant(int x, int y) {
			this.x = x;
			this.y = y;
			this.width = 2;
			this.height = 2;
			moveHistory = new StringBuilder();
			sum = 0;
		}
		//성장
		public String grow() {
			int u=0,d=0,l=0,r=0;
			int max = -1;
			//up
			if(this.y>0) {
				for(int i=0;i<this.width;i++) {
					u+=Board[this.y-1][this.x+i];
				}
				max=Math.max(max, u);
			}
			//down
			if(this.y+this.height<N) {
				for(int i=0;i<this.width;i++) {
					d+=Board[this.y+this.height][this.x+i];
				}
				max=Math.max(max, d);
			}
			//left
			if(this.x>0) {
				for(int i=0;i<this.height;i++) {
					l+=Board[this.y+i][this.x-1];
				}
				max=Math.max(max, l);
			}
			//right
			if(this.x+this.width<N) {
				for(int i=0;i<this.height;i++) {
					r+=Board[this.y+i][this.x + this.width];
				}
				max=Math.max(max, r);
			}
			//최대성장값이 0 이상이라면
			if(max>0) {
				//위쪽이 최대성장
				if(u==max) {
					sum+=u;
					this.y--;
					this.height++;
					moveHistory.append("U");
				//아래쪽이 최대성장
				}else if(d==max) {
					sum+=d;
					this.height++;
					moveHistory.append("D");
				//왼쪽이 최대성장
				}else if(l==max) {
					sum+=l;
					this.x--;
					this.width++;
					moveHistory.append("L");
				//오른쪽이 최대성장
				}else if(r==max) {
					sum+=r;
					this.width++;
					moveHistory.append("R");
				}
				//성장 재귀
				return this.grow();
			//더이상 성장할 수 없다면
			}else {
				//출력
				return toString();
			}
		}
		//출력 : 흡수 영야분 + 경로
		@Override
		public String toString() {
			return sum+"\n"+moveHistory.toString();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Board = new int[N][N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		DancePlant dancePlant = new DancePlant(N/2-1,N/2-1);
		//성장 값 출력
		System.out.println(dancePlant.grow());
		br.close();
	}
}
