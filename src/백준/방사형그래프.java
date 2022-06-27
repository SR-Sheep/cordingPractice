package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방사형그래프 {
	//https://www.acmicpc.net/problem/25308
	static int[] Abilities = new int[8];
	static double Root2 = Math.sqrt(2);
	public static boolean isUnderLine(double left, double right, double curr) {
		double y1 = left/Root2;
		double x1 = -y1;
		double y2 = right/Root2;
		double x2 = y2;
		double inclination = (y2-y1)/(x2-x1); //기울기
		double y = -inclination*x1+y1; //y절편
		return y>curr;
	}
	
	public static int solution(int[] octagons, int bitmask, int order) {
		int answer = 0;
		if(order == 8) {
			for(int i=0;i<8;i++) {
				int curr = octagons[i];
				int left=i==0?octagons[7]:octagons[i-1];
				int right=i==7?octagons[0]:octagons[i+1];
				if(isUnderLine(left, right, curr)) {
					return 0;
				}
			}
			return 1;
		}else {
			for(int i=0;i<8;i++) {
				int idx = 1<<i;
				//사용 안함
				if((bitmask&idx)!=idx) {
					int ability = Abilities[i];
					octagons[order]=ability;
					answer+=solution(octagons, bitmask|idx, order+1);
					octagons[order]=0;
				}
			}
		}
		return answer;
	}
	
	public static int test(int[] octagons) {
		for(int i=0;i<8;i++) {
			int curr = octagons[i];
			int left=i==0?octagons[7]:octagons[i-1];
			int right=i==7?octagons[0]:octagons[i+1];
			if(isUnderLine(left, right, curr)) {
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<8;i++) {
			Abilities[i]=Integer.parseInt(st.nextToken());
		}
		int[] octagons = new int[8];
		System.out.println(solution(octagons, 0, 0));
		br.close();
	}
}
