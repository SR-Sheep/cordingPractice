package ���α׷��ӽ�;

import java.util.Arrays;

public class Ž���_����Ʈ {
    public static int solution(int[] people, int limit) {
        //���� Ƚ��
    	int count=0;
    	//����
    	Arrays.sort(people);
    	int idx=0;
    	//����(ū�ź���)
        for(int i=people.length-1;i>-1;i--) {
        	if(idx==i) {
        		count++;
        		break;
        	}else if(idx>i){
        		break;
        	}
        	int heavy =people[i];
        	int light =people[idx];
        	if(heavy+light<=limit) idx++;
        	count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] p = {70,50,80,50};
		int limit = 100;
		System.out.println(solution(p, limit));
	}
}
