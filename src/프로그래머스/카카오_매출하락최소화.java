package 프로그래머스;

import java.util.*;

public class 카카오_매출하락최소화 {
	
	/*https://programmers.co.kr/learn/courses/30/lessons/72416*/
	
	//클래스의 배열이 들어갈 리스트
	static ArrayList<Employee> company;
	//최대값 설정
    static final int INF=Integer.MAX_VALUE;
    
    //직원 클래스
    static class Employee{
    	//직원 번호, 참석시 기회비용, 불참시 기회비용
        int no, sales,memberSales;
        //부하 직원들
        List<Employee> members;
        //초기화
        public Employee(int no,int sales){
            this.no=no;
            this.sales=sales;
            this.memberSales=0;
            this.members=new ArrayList<>();
        }
    }
    //Employee 클래스의 참석시 기회비용과 불참시 기회비용 중 최소값 출력
    public static int minValue(Employee emp){
        return Math.min(emp.sales, emp.memberSales);
    }
    
    //본인과 자식들의 기회비용 계산
    public static void workshop(int no){
        //해당 번호의 클래스
    	Employee emp=company.get(no);
    	//자식이 있다면 기회비용을 계산할 필요가 있음
        if(!emp.members.isEmpty()){
        	//참석시 기회비용 계산
        	int sum=0;
        	//불참시 기회비용 계산
            int cost=INF;
            //먼저 자식들의 기회비용 계산
            for(int i=0;i<emp.members.size();i++){
                workshop(emp.members.get(i).no);
            }
            //자식들 탐색
            for(int i=0;i<emp.members.size();i++){
                //자식들의 기회비용을 더할 임시 변수
            	int tmp=0;
                for(int j=0;j<emp.members.size();j++){
                	//본인일 경우 참석 기회비용을 더함
                    if(i==j) tmp+=emp.members.get(j).sales;
                    //다른 팀원일 경우 참석 기회비용과 불참 기회비용 중 적은 것을 취함
                    else tmp+=minValue(emp.members.get(j));
                }
                //비용과 임시 변수 중 적은 것을 비용으로 취함
                cost=Math.min(cost,tmp);
                //자식들의 기회비용 최소값의 합 (자식들의 최소 기회비용)
                sum+=minValue(emp.members.get(i));
            }
            //불참시 기회비용 = 
            emp.memberSales=cost;
            //참석시 기회비용 =  내 실적 + 자식들의 최소 기회비용
            emp.sales+=sum;
        }
        
    }
    
    public static int solution(int[] sales, int[][] links) {
       //회사 선언
        company = new ArrayList<>();
        //회사에 직원번호, 실적 입력
        for(int i=0;i<sales.length;i++){
            company.add(new Employee(i,sales[i]));
        }
        for(int[] link:links){
            int sup=link[0]-1; //상사 번호 - 1 (0부터 시작 보정)
            int sub=link[1]-1; //부하 번호 - 1 (0부터 시작 보정) 
            company.get(sup).members.add(company.get(sub));
        }
        //0번의 기회비용 계산
        workshop(0);
        //0번의 기회비용 중 적은 것을 리턴
        return minValue(company.get(0));
    }
    
    public static void main(String[] args) {
    	//판매실적
		int[][] sales= {{14, 17, 15, 18, 19, 14, 13, 16, 28, 17},{5, 6, 5, 3, 4},{5, 6, 5, 1, 4},{10, 10, 1, 1}};
		//상사 - 부하 관계
		int[][][] links = {{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}},{{2,3}, {1,4}, {2,5}, {1,2}},{{2,3}, {1,4}, {2,5}, {1,2}},{{3,2}, {4,3}, {1,4}}};
		for(int i=0;i<sales.length;i++) {
			System.out.println(solution(sales[i], links[i]));
		}
		//44,6,5,2
	}
    
}
