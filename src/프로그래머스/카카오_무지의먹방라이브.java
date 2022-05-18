package 프로그래머스;

public class 카카오_무지의먹방라이브 {
	//https://programmers.co.kr/learn/courses/30/lessons/42891
    public static int solution(int[] food_times, long k) {
        //k초에서 장애 발생 후, 다시 먹는 음식은 k+1초 순서인 음식임으로 k에 1을 추가
        k++;
        //이분탐색으로 바퀴수 탐색
        long left = 0;
        long right = k;
        long mid = -1;
        
        long repeat = 0; //회전 수
        long repeatSum = 0;//경과 시간
        //이분탐색 시작
        while(left<=right){
            //회전수 설정
            mid = (left+right)/2;
            //총 걸린 시간
            long sum = 0;
            //회전수보다 큰 음식은 회전수만큼, 작은 음식은 필요한 시간만큼 계산
             for(int i=0;i<food_times.length;i++){
                sum+=food_times[i]<mid?food_times[i]:mid;
            }
            //총 걸린 시간이 k보다 작다면 총걸린시간과 회전수를 기록하고 최소값 증가
            if(sum<k){
                repeatSum=sum;
                repeat = mid;
                left = mid+1;
            //총 걸린시간이 k이상이라면 최대값 감소
            }else {
                right = mid-1;
            }
        }
        //남은 시간 = k초에서 총걸린시간 빼기
        long leftTime = k-repeatSum;
        //회전수만큼 돌고 새로운 회전을 위해 1 증가
        repeat++;
        //걸린 시간 계산을 위한 선언
        long time=0;
        for(int i=0;i<food_times.length;i++){
            if(food_times[i]-repeat>=0){
                time++;
                if(time==leftTime) return i+1;
            }
            
        }
        //이미 음식을 다 먹은 경우 -1을 출력합니다.
        return -1;
    }
    
    
    public static void main(String[] args) {
    	int[] food_times= {3,1,2};
    	long k=5;
    	System.out.println(solution(food_times, k));
	}
}
