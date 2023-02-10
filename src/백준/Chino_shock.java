package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chino_shock {
	//https://www.acmicpc.net/problem/27310
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int length = s.length();//문자열길이
		int countColon = 0;//콜론수
		int countUnder = 0;//언더바수
		//문자열탐색
		for(char c:s.toCharArray()) {
			//콜론일 경우
			if(c==':') {
				countColon++;
			//언더바일경우
			}else if(c=='_') {
				countUnder++;
			}
		}
		//난이도 출력 = l + c + u*5
		System.out.println(length+countColon+countUnder*5);
		br.close();
	}
}
