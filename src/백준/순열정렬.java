package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 순열정렬 {
	//https://www.acmicpc.net/problem/25287
	
	//변화할수 있는 수
	public static int getChangeNumber(int n , int i) {
		return n-i+1;
	}
	
	public static boolean isIncrease(int n, int[] arr) {
		if(n==1) return true; //1개면 true
		//답을 저장할 배열
		int[] answer = new int[n];
		//처음 수 vs 변화한 수 중 적은 값을 초기값으로 취함
		answer[0]=Math.min(arr[0], getChangeNumber(n, arr[0]));
		//탐색
		for (int i = 1; i <n; i++) {
			//현재 수
			int curr = arr[i];
			//변화한 수
			int change = getChangeNumber(n, curr);
			//현재 수, 변화한 수 둘다 이전 수보다 작다면 둘 중 작은수를 취함
			if(answer[i-1]<=curr&&answer[i-1]<=change) {
				answer[i]=Math.min(curr, change);
			//현재 수만 이전 수보다 작다면 현재수 를 취함
			}else if(answer[i-1]<=curr) {
				answer[i]=curr;
			//변화한 수만 이전 수보다 작다면 변화한 수를 취함
			}else if(answer[i-1]<=change) {
				answer[i]=change;
			//둘 다 이전 수보다 크다면 false 리턴
			}else {
				return false;
			}
		}
		//모든 조건 통과시 true 리턴
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			bw.append(isIncrease(n, arr) ? "YES" : "NO").append("\n");
		}
		bw.close();
		br.close();
	}
}
