package 백준;

import java.io.*;

public class 벼락치기 {
	
	//https://www.acmicpc.net/problem/23739
	
	public static int solution(int[] chapters) {
		int time = 30;
		int answer = 0;
		for(int chapter:chapters) {
			//시간을 다 썻으면 30분 리필
			if(time==0) time = 30;
			//현재 남은 시간이 챕터 이상이면
			if(time>=chapter) {
				answer++; //답 증가
				time-=chapter; //시간 소모
			//남은 시간이 부족하면
			}else {
				//절반 이상 공부했다면 답 증가
				if(chapter-time<=chapter/2) answer++;
				time=30;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int r = Integer.parseInt(br.readLine());
		int[] chapters = new int[r];
		for(int o=0;o<r;o++) {
			chapters[o]=Integer.parseInt(br.readLine());
		}
		bw.append(solution(chapters) + "\n");
		br.close();
		bw.close();
	}
}
