package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이천22는무엇이특별할까 {
	//https://www.acmicpc.net/problem/24268
	public static int specialYear(int year, int num) {
		year++; //주어진 년도 다음 년도를 계산하기 위해 1 증가시킴
		//만약 year를 num 진법으로 변환 했을 경우, 길이가 num 보다 작다면 모든 숫자가 들어갈 수 없음으로
		//n진법이라면 1 0 2 3 ... (n-1)이 최소
		//따라서 year = 1*(n^(n-1))+ 2*(n^(n-3) + ... (n-1)*(n^0)
		if(Integer.toString(year, num).length()<num) {
			year = 0;
			int front = num -1; 
			int back = 1;
			while(front>1) {
				year+=front*back;
				front--;
				back*=num;
			}
			year+=back*num;
//			System.out.println(Integer.toString(year,num));
			return year;
		}
		while(true) {
			//num 진법으로 year 변환
			char[] tmp = Integer.toString(year, num).toCharArray();
			//변환 길이가 num보다 크면, 진법의 모든 수가 한번 이상 나옴으로 -1 출력
			if(tmp.length>num) {
				break;
			//변환 길이가 num과 같다면 모든 수가 나올 수 있음
			}else if(tmp.length==num) {
				//각 진법의 숫자가 들어갈 계산할 배열 생성
				int[] nums = new int[num];
				//특별한지 여부를 판별할 boolean
				boolean isSpecial=true;
				//변환 배열 탐색
				for(char c:tmp) {
					//char형 임으로 각 숫자의 idx의 숫자 배열 증가
					nums[c-'0']++;
					//해당 숫자 배열이 2 이상이면 중복임으로 체크 후 break
					if(nums[c-'0']>1) {
						isSpecial=false;
						break;
					}
				}
				//특별하면 해당 연도 출력
				if(isSpecial) {
					return year;
				}
			}
			//다음 년도 검사
			year++;
		}
		//답이 없으면 -1 리턴
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int year=Integer.parseInt(st.nextToken());
		int num=Integer.parseInt(st.nextToken());
		
		System.out.println(specialYear(year, num));
		
		br.close();
	}
}
