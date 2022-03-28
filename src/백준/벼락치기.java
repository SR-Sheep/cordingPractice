package 백준;

import java.io.*;

public class 소강_벼락치기 {
	
	//https://www.acmicpc.net/problem/23739
	
	public static int solution(int[] chapters) {
		int time = 30;
		int answer = 0;
		for(int chapter:chapters) {
			if(time==0) time = 30;
			if(time>=chapter) {
				answer++;
				time-=chapter;
			}else {
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
