package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �����⼳ġ {
	//https://www.acmicpc.net/problem/2110
	
	static int RouterCount;
	static int[] Routers;
	
	public static boolean isPossible(int mid) {
		int count = 1; //ó�� 1�� ��ġ
		int curr = Routers[0]; //������ ��ġ, ó������ ����
		for(int i=0;i<Routers.length;i++) {
			if(Routers[i]-curr>=mid) { //������ �Ÿ��� mid ���� ũ��
				count++; //Ƚ�� ����
				curr=Routers[i]; //������ ������ ��ġ ������Ʈ
			}
		}
		return count>=RouterCount?true:false; //Ƚ���� ������ ������ ���ٸ� true, ���ٸ� false
	}
	
	public static int solution() {
		Arrays.sort(Routers); //����
		int answer = 0;
		//�̺� Ž��
		int left=1,right=Routers[Routers.length-1],mid=-1;
		while(left<=right) {
			mid=(left+right)/2;
			if(isPossible(mid)) { //�����ϸ� �� ������Ʈ
				answer=mid;
				left=mid+1; //�ּҰ� ����
			}else {
				right=mid-1; //�ִ밪 ����
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		RouterCount=Integer.parseInt(st.nextToken());
		Routers = new int[n];
		for(int i=0;i<n;i++) {
			Routers[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(solution());
		br.close();
	}
}
