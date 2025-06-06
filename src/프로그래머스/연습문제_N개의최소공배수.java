package 프로그래머스;

public class 연습문제_N개의최소공배수 {
    //최대공약수
    public static int gcd(int a, int b){
        int big=0;
        int small=0;
        if(a>b){
            big=a;
            small=b;
        }else{
            big=b;
            small=a;
        }
        if(small==0) return big;
        else return gcd(small,big%small);
    }
    //최소공배수
    public static int lcd(int a, int b){
        return a*b/gcd(a,b);
    }
    
    
    public static int solution(int[] arr) {
        int answer = 1;
        for(int i:arr){
            answer=lcd(answer,i);
        }
        return answer;
    }
    
    public static void main(String[] args) {
		int n=2;
		int[][] arr = {{2,6,8,14},{1,2,3}}; //168, 6
		
		for(int i=0;i<n;i++) {
			System.out.println(solution(arr[i]));
		}
	}
}
