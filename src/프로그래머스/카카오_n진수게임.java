package ���α׷��ӽ�;

public class īī��_n�������� {
	
    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        //���ڱ���
        int repeat = m*(t-1)+p;
        int num=0;
        while(tmp.toString().length()<=repeat){
            //���� ��ȯ�Ͽ� ���̱�
        	tmp.append(Integer.toString(num++,n));
        }
        for(int i=p-1;i<repeat;i+=m){
        	//�� ���ʿ� �ش�Ǵ� ���ڸ� �信 ���̱�
            answer.append(tmp.toString().toUpperCase().charAt(i));
        }
        return answer.toString();
    }
    
	public static void main(String[] args) {
		int[] n= {2,16,16}, t= {4,16,16}, m= {2,2,2},p={1,1,2};
		for(int i=0;i<n.length;i++) {
			System.out.println(solution(n[i], t[i], m[i], p[i]));
		}
		
	}
}
