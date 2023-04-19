package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 약수들의합 {
	//https://www.acmicpc.net/problem/9506
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0; //숫자
		StringBuilder sb = new StringBuilder(); //출력을 위한 스트링빌더
		//-1이 나올때까지 반복
		while((n=Integer.parseInt(br.readLine()))!=-1) {
			int sum = 1; //합, 1은 무조건 들어감
			List<Integer> list = new ArrayList<>();
			for(int i=2;i<n;i++) { //2부터 시작
				if(n%i==0) {
					list.add(i); //약수면 list에 추가
					sum+=i;
				}
			}
			sb.append(n+" ");
			if(sum==n) { //완전수라면
				sb.append("= 1"); //추가
				for(int i:list) {
					sb.append(" + "+i); //부호 + 숫자
				}
				sb.append("\n");
			}else {  //완전수 아님
				sb.append("is NOT perfect.\n");
			}
		}
		System.out.println(sb); //출력
		br.close();
	}
}
