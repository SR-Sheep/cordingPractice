package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 정사각형 {
	
	//https://www.acmicpc.net/problem/1485
	
	public static long powDistance(int[] point1, int[] point2) {
		long tmpX = point1[0]-point2[0];
		long tmpY = point1[1]-point2[1];
//		System.out.println(tmpX*tmpX + tmpY*tmpY);
		return tmpX*tmpX+tmpY*tmpY;
	}
	
	public static int solution(int[][] points) {
		
		HashMap<Long,Integer> map = new HashMap<Long, Integer>();
		
		long max=0; //대각선의 값
		long min=Long.MAX_VALUE;
		//6번의 검사 (0,1),(0,2),(0,3),(1,2),(1,3),(2,3)
		for(int i=0;i<3;i++) {
			for(int j=i+1;j<4;j++) {
				long dist = powDistance(points[i], points[j]);
				max = Math.max(max, dist);
				min = Math.min(min, dist);
				map.put(dist, map.getOrDefault(dist, 0)+1);
			}
		}
		
		for(Long key:map.keySet()) {
			System.out.println(key+" "+map.get(key));
		}
		
		//점간의 거리가 2개가 아니거나, 대각선이 사각형 변의 2배가 안되거나, 변의 개수가 4가 아니면 거짓
		if(map.size()!=2) {
//			System.out.println("사이즈!");
			return 0;
		}
		if(max!=min*2) {
//			System.out.println("대각선!");
			return 0;
		}
		if(map.get(min)!=4) {
//			System.out.println("개수!");
			return 0;
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			int[][] points=new int[4][2];
			for(int j=0;j<4;j++) {
				st=new StringTokenizer(br.readLine());
				points[j][0]=Integer.parseInt(st.nextToken());
				points[j][1]=Integer.parseInt(st.nextToken());
			}
			bw.append(solution(points)+"\n");
		}
		br.close();
		bw.close();
	}
}
