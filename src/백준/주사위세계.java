package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 주사위세계 {
	//https://www.acmicpc.net/problem/2480
	public static int reward(int[] dice) {
		int max = 0;
		for(int i=1;i<=6;i++) {
			if(dice[i]==3) {
				max=10000+i*1000;
				break;
			}else if(dice[i]==2) {
				max=1000+i*100;
				break;
			}else if(dice[i]>0){
				max=i*100;
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dice = new int[7];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++) {
			int n=Integer.parseInt(st.nextToken());
			dice[n]++;
		}
		System.out.println(reward(dice));
		br.close();
	}
}
