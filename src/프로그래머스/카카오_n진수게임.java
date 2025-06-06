package 프로그래머스;

public class 카카오_n진수게임 {
	
    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        //글자길이
        int repeat = m*(t-1)+p;
        int num=0;
        while(tmp.toString().length()<=repeat){
            //진법 변환하여 붙이기
        	tmp.append(Integer.toString(num++,n));
        }
        for(int i=p-1;i<repeat;i+=m){
        	//내 차례에 해당되는 숫자만 답에 붙이기
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
