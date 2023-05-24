package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/1526
public class 가장큰금민수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		//완전탐색
		while(num>0) {
			boolean isAnswer = true;
			int tmp = num;
			while(tmp>0) {
				if(tmp%10!=7&&tmp%10!=4) {
					isAnswer=false;
					break;
				};
				tmp/=10;
			}
			if(isAnswer) break;
			else num--;
		}
		System.out.println(num);
		br.close();
	}
}
