package 프로그래머스;
import java.util.*;

public class 이분탐색_입국심사 {
	//시간이 충분한지 검사
    public static boolean isEnoughTime(long n,int[] times,long mid ) {
		long cnt=0;
		// mid/time : mid시간동안 몇사람을 받을 수 있는지?
		for(long time:times) cnt+=mid/time;
		// n명을 받을 수 없다면 false
		if(n>cnt)return false;
		//n명이 수용 가능하다면 true
		else return true;
	}
    public static long solution(long n, int[] times) {
        //답을 최대 시간으로 설정
    	long answer=Long.MAX_VALUE;
        //배열 정렬
        Arrays.sort(times);
        //최소 = 1명 1분, 최대 = 사람수 * 최대 걸리는 시간
		long start=1,end=n*times[times.length-1],mid=0;
		
		while(start<=end) {
			//중간값 설정
			mid=(start+end)/2;
			//제한시간을 mid로 설정했을 때, 모두 수용이 가능하면
			if(isEnoughTime(n, times, mid)) {
				//최소값이 답, 이곳에 오면 어차피 최소값
				answer=mid;
				//수용이 가능하므로 최대값을 좁힘(mid 감소)
				end=mid-1;
			//수용 불가시 최소값을 늘림 (mid 증가)
			}else start=mid+1;	
		}
		return answer;
    }
    
    public static void main(String[] args) {
		int[] times = {7,10};
		int n= 6;
		System.out.println(solution(n, times));	
	}

}
