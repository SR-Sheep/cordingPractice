package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 저항 {
	//https://www.acmicpc.net/problem/1076
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Long> colorMap = new HashMap<>();
		String[] colors = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
		for(long i=0;i<10;i++) {
			String color = colors[(int)i];
			colorMap.put(color,i);
		}
		String color1 = br.readLine();
		String color2 = br.readLine();
		String color3 = br.readLine();
		long result = (colorMap.get(color1)*10+colorMap.get(color2))*((long)Math.pow(10, colorMap.get(color3)));
		System.out.println(result);
		br.close();
	}
}
