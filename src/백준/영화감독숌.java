package 백준;

import java.io.*;
import java.util.*;

public class 영화감독숌 {
	//https://www.acmicpc.net/problem/1436
	
	public static int solution(int n) {
		int num=666;
		int count = 0;
		while(count<n) {
			if(Integer.toString(num).contains("666")) count++;
			num++;
		}
		return num-1;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
        br.close();
	}
}
