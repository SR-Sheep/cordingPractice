package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class INU_���ɰ��� {
	//https://www.acmicpc.net/problem/23842
	
	static int[] match = {6,2,5,5,4,5,6,3,7,6};
	
	public static String solution(int n) {
		n-=4; //+, = ���� ���
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				for(int a=0;a<10;a++) {
					for(int b=0;b<10;b++) {
						for(int c=0;c<10;c++) {
							for(int d=0;d<10;d++) {
								if(match[i]+match[j]+match[a]+match[b]+match[c]+match[d]==n&&i*10+j+a*10+b==c*10+d) {
									return i+""+j+"+"+a+""+b+"="+c+""+d;
								}
							}
						}
					}
				}
			}
		}
		return "impossible";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.append(solution(n));
		br.close();
		bw.close();
	}
}
