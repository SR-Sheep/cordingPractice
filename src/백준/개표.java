package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 개표 {
	static final long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		
		long min = INF;
		long max = 0;
		
		//득표수 기록
		long[] votes = new long[n+2];
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken());
			
			if(cmd==1) {
				long x=Long.parseLong(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				votes[y]+=x;
				if(y!=n+1) {
					max=Math.max(max,votes[y]);
					min=Math.min(min, votes[y]);
				}
			}else {
				long x=Long.parseLong(st.nextToken());
				long y=Long.parseLong(st.nextToken());
				long myScore=votes[n+1]+x;
				//내 점수가 최고점일 경우
				if(myScore>max) {
					//최소값에 y표를 더해도 내가 승리하면 Y, 아니면 N
					if(myScore>min+y) {
						bw.append("YES\n");
					}else {
						bw.append("NO\n");
					}
				//내 점수가 최고점이 아닐 경우
				}else {
					bw.append("NO\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
