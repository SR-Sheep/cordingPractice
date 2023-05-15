package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/28015
public class 영역색칠 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int prev=Integer.parseInt(st.nextToken());
			int[] colors = new int[3];
			if(prev!=0) colors[prev]++;
			for(int j=1;j<m;j++) {
				int curr=Integer.parseInt(st.nextToken());
				//0이 아니고 이전 색과 다르다면
				if(prev!=curr&&curr!=0) {
					colors[curr]++; //해당 색깔의 컬러 영역 증가
				//0일 경우
				}else if(curr==0) {
					//둘중에 하나라도 0이 아니라면
					if(colors[1]!=0||colors[2]!=0) {
						//최소값
						int min = Math.min(colors[1], colors[2]);
						answer+= ++min; //최소값 +1 만큼 증가 (최대값은 한번 칠하고 최소값을 덧칠)
						//배열 초기화
						colors[1]=0;
						colors[2]=0;
					}
				}
				//이전 영역 색 업데이트
				prev = curr;
			}
			//가로줄 종료 후, 영역 검사 실시
			//둘중에 하나라도 0이 아니라면
			if(colors[1]!=0||colors[2]!=0) {
				//최소값보다 1만큼 더 색칠
				int min = Math.min(colors[1], colors[2]);
				answer+= ++min;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
