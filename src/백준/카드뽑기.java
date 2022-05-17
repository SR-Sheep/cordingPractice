package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 카드뽑기 {
	//https://www.acmicpc.net/problem/25185
	public static boolean isRestDay(String[] cards) {
		int[][] nums = new int[10][3];
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('m', 0);
		map.put('p', 1);
		map.put('s', 2);
		
		for(String card:cards) {
			int num = card.charAt(0)-'0';
			int c = map.get(card.charAt(1));
			nums[num][c]++;
		}
		
		int two = 0;
		
		for(int i=0;i<3;i++) {
			int count = 0;
			for(int j=1;j<10;j++) {
				int result = nums[j][i];
				//1) 연속 숫자
				if(result==1) {
					count++;
				//2) 같은 수 3장 이상
				}else if(result>2) { 
					return true;
				//3) 2장 / 2장
				}else if(result==2) {
					two++;
					if(two>1) {
						return true;
					}
					//1) 연속 숫자
					count++;
				}else {
					count = 0;
				}
				//연속 숫자 3이면 true
				if(count==3) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String[] cards = new String[4];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				cards[j]=st.nextToken();
			}
			bw.append(":").append(isRestDay(cards)?")":"(").append("\n");
		}
		bw.close();
		br.close();
	}
}
