package ���α׷��ӽ�;

import java.util.*;

public class īī��_�����϶��ּ�ȭ {
	
	/*https://programmers.co.kr/learn/courses/30/lessons/72416*/
	
	//Ŭ������ �迭�� �� ����Ʈ
	static ArrayList<Employee> company;
	//�ִ밪 ����
    static final int INF=Integer.MAX_VALUE;
    
    //���� Ŭ����
    static class Employee{
    	//���� ��ȣ, ������ ��ȸ���, ������ ��ȸ���
        int no, sales,memberSales;
        //���� ������
        List<Employee> members;
        //�ʱ�ȭ
        public Employee(int no,int sales){
            this.no=no;
            this.sales=sales;
            this.memberSales=0;
            this.members=new ArrayList<>();
        }
    }
    //Employee Ŭ������ ������ ��ȸ���� ������ ��ȸ��� �� �ּҰ� ���
    public static int minValue(Employee emp){
        return Math.min(emp.sales, emp.memberSales);
    }
    
    //���ΰ� �ڽĵ��� ��ȸ��� ���
    public static void workshop(int no){
        //�ش� ��ȣ�� Ŭ����
    	Employee emp=company.get(no);
    	//�ڽ��� �ִٸ� ��ȸ����� ����� �ʿ䰡 ����
        if(!emp.members.isEmpty()){
        	//������ ��ȸ��� ���
        	int sum=0;
        	//������ ��ȸ��� ���
            int cost=INF;
            //���� �ڽĵ��� ��ȸ��� ���
            for(int i=0;i<emp.members.size();i++){
                workshop(emp.members.get(i).no);
            }
            //�ڽĵ� Ž��
            for(int i=0;i<emp.members.size();i++){
                //�ڽĵ��� ��ȸ����� ���� �ӽ� ����
            	int tmp=0;
                for(int j=0;j<emp.members.size();j++){
                	//������ ��� ���� ��ȸ����� ����
                    if(i==j) tmp+=emp.members.get(j).sales;
                    //�ٸ� ������ ��� ���� ��ȸ���� ���� ��ȸ��� �� ���� ���� ����
                    else tmp+=minValue(emp.members.get(j));
                }
                //���� �ӽ� ���� �� ���� ���� ������� ����
                cost=Math.min(cost,tmp);
                //�ڽĵ��� ��ȸ��� �ּҰ��� �� (�ڽĵ��� �ּ� ��ȸ���)
                sum+=minValue(emp.members.get(i));
            }
            //������ ��ȸ��� = 
            emp.memberSales=cost;
            //������ ��ȸ��� =  �� ���� + �ڽĵ��� �ּ� ��ȸ���
            emp.sales+=sum;
        }
        
    }
    
    public static int solution(int[] sales, int[][] links) {
       //ȸ�� ����
        company = new ArrayList<>();
        //ȸ�翡 ������ȣ, ���� �Է�
        for(int i=0;i<sales.length;i++){
            company.add(new Employee(i,sales[i]));
        }
        for(int[] link:links){
            int sup=link[0]-1; //��� ��ȣ - 1 (0���� ���� ����)
            int sub=link[1]-1; //���� ��ȣ - 1 (0���� ���� ����) 
            company.get(sup).members.add(company.get(sub));
        }
        //0���� ��ȸ��� ���
        workshop(0);
        //0���� ��ȸ��� �� ���� ���� ����
        return minValue(company.get(0));
    }
    
    public static void main(String[] args) {
    	//�ǸŽ���
		int[][] sales= {{14, 17, 15, 18, 19, 14, 13, 16, 28, 17},{5, 6, 5, 3, 4},{5, 6, 5, 1, 4},{10, 10, 1, 1}};
		//��� - ���� ����
		int[][][] links = {{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}},{{2,3}, {1,4}, {2,5}, {1,2}},{{2,3}, {1,4}, {2,5}, {1,2}},{{3,2}, {4,3}, {1,4}}};
		for(int i=0;i<sales.length;i++) {
			System.out.println(solution(sales[i], links[i]));
		}
		//44,6,5,2
	}
    
}
