package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class AC {
	//https://www.acmicpc.net/problem/5430
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
			char[] cmds = br.readLine().toCharArray();
			int m = Integer.parseInt(br.readLine());
			String tmp = br.readLine();
			String[] tmpArr= tmp.substring(1,tmp.length()-1).split(",");
			try {
				for(String s:tmpArr) {
					dq.add(Integer.parseInt(s));
				}
			} catch (Exception e) {
			}	
			try {
				boolean isBackward = false;
				for(char c:cmds) {
					//R일 경우, 방향 전환
					if(c=='R') {
						isBackward=!isBackward;
					//역방향일경우
					}else if(isBackward){
						dq.removeLast(); //뒤에서 제거
					//정방향일경우
					}else {
						dq.removeFirst(); //앞에서 제거
					}
				}
				StringBuilder sb = new StringBuilder("[");
				//최종 역방향일 경우
				if(isBackward) {
					while(!dq.isEmpty()) {
						sb.append(dq.pollLast()).append(",");
					}
				//최종 정방향일 경우	
				}else {
					while(!dq.isEmpty()) {
						sb.append(dq.pollFirst()).append(",");
					}
				}
				if(sb.length()>1) sb.deleteCharAt(sb.length()-1);
				sb.append("]\n"); //마지막 콤마 제거후 대괄호 닫기
				bw.append(sb);
			} catch (Exception e) {
				bw.append("error\n"); //에러면 에러 표시
			}
		}
		br.close();
		bw.close();
	}
}
