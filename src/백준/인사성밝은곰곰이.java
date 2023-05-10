package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//https://www.acmicpc.net/problem/25192
public class 인사성밝은곰곰이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set= new HashSet<>(); //중복제거를 위한 set 선언
		int answer = 0;
		while(n-->0) {
			String id = br.readLine();
			//id가 엔터면
			if(id.equals("ENTER")) {
				answer+=set.size(); //set의 길이만큼 이모티콘 추가
				set = new HashSet<>(); //set 초기화
			}else {
				set.add(id); //set에 id 추가
			}
		}
		answer+=set.size(); //set 길이만큼 이모티콘 추가
		System.out.println(answer); //출력
		br.close();
	}
}
