package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔진수이진수 {
	//https://www.acmicpc.net/problem/1212
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char nums[] = br.readLine().toCharArray(); //8진수
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(nums[0]-'0')); //첫글자 붙이기
		//나머지 글자 붙이기
		for(int i=1;i<nums.length;i++) {
			String binaryNum = Integer.toBinaryString(nums[i]-'0'); //붙을 숫자
			int zeroCount = 3-binaryNum.length(); //0이 붙는 수
			//0붙이기
			while(zeroCount-->0) {
				sb.append("0");
			}
			//변환한 이진수 붙이기
			sb.append(binaryNum);
		}
		System.out.println(sb);
		br.close();
	}
}
