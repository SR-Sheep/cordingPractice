package 프로그래머스;

public class 카카오_4단고음 {

		
		//1) 1*3+1+1 *3+1+1
		//2_ 1*3 *3+1+1 +1+1
		//3) 1*3+1 *3+1+1
		
		
    public static int solution(int n) {
        return dfs(n,0);
    }

    public static int dfs(int n, int cnt){
        if(n < 3 || n < Math.pow(3,cnt/2)) return 0;
        if(n == 3){
            if(cnt == 2) return 1;
        }else if(n>3){
              if(n%3 == 0 && cnt>=2){
            	  return dfs(n/3,cnt-2)+dfs(n-1,cnt+1);
              }
              return dfs(n-1,cnt+1);
        }
        return 0;
    }
	
	public static void main(String[] args) {
		int[] ns= {5,15,24,41,2147483647};
		for(int n:ns) System.out.println(solution(n));
	}

}
