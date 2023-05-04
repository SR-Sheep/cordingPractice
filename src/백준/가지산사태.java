package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/27940
public class 가지산사태 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //농장층수(사실상 사용 안함)
		int m=Integer.parseInt(st.nextToken()); //비오는 횟수
		int k=Integer.parseInt(st.nextToken()); //버틸 수 있는 빗물의 양
		long sum = 0;
		boolean isBreak = false; //무너짐 여부 확인
		//1층은 무조건 잠기게 됨으로 누적 합만 취함
		for(int i=1;i<=m;i++) {
			st=new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken()); //t 층까지
			sum+=Integer.parseInt(st.nextToken()); //누적 비 수
			//누적된 비의 양이 k를 넘으면
			if(sum>k) {
				System.out.println(i+" 1"); //i번째에서 1층 출력
				isBreak = true;
				break;
			}
		}
		if(!isBreak) System.out.println("-1"); //무너지지 않는다면 -1 출력
		bw.close();
		br.close();
	}
}
