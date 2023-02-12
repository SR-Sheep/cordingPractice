package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 재귀의귀재 {
	//https://www.acmicpc.net/problem/25501
	//재귀함수 팰린드롬 판별, {팰린드롬판별 여부 0/1, 호출횟수}
    public static int[] recursion(String s, int l, int r,int n){
        if(l >= r) return new int[] {1,n};
        else if(s.charAt(l) != s.charAt(r)) return new int[] {0,n};
        else return recursion(s, l+1, r-1,++n);
    }
    //팰런드롬 판별
    public static int[] isPalindrome(String s){
        return recursion(s, 0, s.length()-1,1);
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String s = br.readLine();
			int[] result =isPalindrome(s);
			bw.append(result[0]+" "+result[1]+"\n"); //팰린드롬판별 / 호출횟수
		}
		bw.close();
		br.close();
	}
}
