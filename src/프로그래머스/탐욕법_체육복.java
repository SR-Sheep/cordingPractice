package 프로그래머스;

import java.util.*;

public class 탐욕법_체육복 {
	static class Ex{
		private int n;
		private int[] lost, reserve;
		
		public Ex(int n, int[] lost, int[] reserve) {
			this.n=n;
			this.lost=lost;
			this.reserve=reserve;
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public int[] getLost() {
			return lost;
		}

		public void setLost(int[] lost) {
			this.lost = lost;
		}

		public int[] getReserve() {
			return reserve;
		}

		public void setReserve(int[] reserve) {
			this.reserve = reserve;
		}
		 
	}
	
	
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        //여벌이 있는 학생을 저장할 배열, 최대 학생수 30명
        boolean[] student =new boolean[30];
        Arrays.sort(lost);//학생 번호 정렬
        //여벌이 있으면 true
        for(int r:reserve) {
        	int idx=r-1;
        	student[idx]=true;
        }
        //잃어버린 학생을 담을 list
        List<Integer> list = new ArrayList<Integer>();
        
        for(int l:lost) {
        	int idx=l-1;
        	//잃어버렸으나 여벌이 있으면
        	//자신이 입고 답 증가
        	if(student[idx]) {
        		answer++;
        		student[idx]=false;
        	}else {
        		//여벌 없을 시 리스트에 추가
        		list.add(idx);
        	}
        }
        
        for(int idx:list) {
        	//내 앞번호 체육복 있으면 해당 여벌을 본인이 입음
        	if(idx-1>=0&&student[idx-1]) {
        		student[idx-1]=false;
        		answer++;
    		//앞사람 없으면 내 뒷번호가 체육복이 있으면 해당 여벌을 본인이 입음
        	}else if(idx+1<30&&student[idx+1]) {
        		student[idx+1]=false;
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		List<Ex> list = new ArrayList<>();
		list.add(new Ex(5,new int[] {2,4},new int[] {1,3,5})); //5
		list.add(new Ex(5,new int[] {2,4},new int[] {3})); //4
		list.add(new Ex(3,new int[] {3},new int[] {1})); //2
		list.add(new Ex(5,new int[] {1,2,3},new int[] {2,3,4})); //4
		list.add(new Ex(5,new int[] {2,3,4},new int[] {1,2,3})); //4
		for(Ex ex:list) {
			System.out.println(solution(ex.getN(), ex.getLost(), ex.getReserve()));
		}
	}
}
