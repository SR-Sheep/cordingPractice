package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬인지확인하기 {
	//https://www.acmicpc.net/problem/10988
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		int frontIdx = 0;
		int backIdx = cArr.length-1;
		boolean isPalindrome =true;
		while(frontIdx<backIdx) {
			if(cArr[frontIdx++]!=cArr[backIdx--]) {
				isPalindrome = false;
				break;
			}
		}
		System.out.println(isPalindrome?"1":"0"); //팰린드롬이면 1 아니면 0
		br.close();
	}
}
