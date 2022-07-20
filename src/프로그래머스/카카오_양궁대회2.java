package 프로그래머스;

public class 카카오_양궁대회2 {
	static int[] Info, Answer;
	static int Max;
	
	public static void dfs(int n,int idx, int lion,int apeach, int[] arr) {
		//idx가 10인 경우, 즉 0점짜리인 경우
		if(idx==10) {
			arr[10]+=n;//0점에 남은 화살 몰아주기
			//최대 점수차보다 크다면
			if(Max<lion-apeach) {
                Max = lion-apeach; //최대점수 업데이트
                //답 업데이트
                for(int i=0;i<11;i++) {
                	Answer[i]=arr[i];
                }
                //동점이라면
            }else if(Max==lion-apeach){
                //낮은 점수를 더 많이 맞춘 쪽이 답
                for(int i=10;i>=0;i--){
                    //현재 답이 더 낮은 점수를 맞춘 횟수가 더 많다면
                    if(Answer[i]<arr[i]){
                    	//답 업데이트
                        for(int j=0;j<11;j++) {
                        	Answer[j]=arr[j];
                        }
                        break; //종료
                    //원래 답이 더 낮은 점수가 더 많다면    
                    }else if(Answer[i]>arr[i]){
                        break; //그냥 종료
                    }
                }
			}
			arr[10]-=n;//돌려놓기
			return;
		}
		int arrow = Info[idx]+1; //해당 점수를 얻기 위한 요구화살
		int score = 10-idx; //점수는 역순으로 배열되어 있음으로 10-idx;
		//1)점수 가지기
		if(n>=arrow) {
			//백트래킹
			arr[idx]+=arrow;
			dfs(n-arrow, idx+1, lion+score,apeach, arr);
			arr[idx]-=arrow;
		}
		//2)점수 안 가지기
		//어피치가 맞춘 경우라면
		if(Info[idx]>0) {
			//어피치가 점수를 받음
			apeach+=score;
		}
		dfs(n,++idx,lion,apeach,arr);
	}
	
	
	public static int[] solution(int n, int[] info) {
        Info=info;
        Max=0;
        Answer =new int[11];
        dfs(n, 0, 0, 0, new int[11]);
        return Max==0?new int[] {-1}:Answer;
    }
	
	public static void main(String[] args) {
//		int n = 5;
//		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//		int n = 1;
//		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
//		int n = 9;
//		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
//		int n = 10;
//		int[] info = {0,0,0,0,0,0,0,0,3,4,3};
		int n = 10;
		int[] info = {1,1,1,1,1,1,1,1,1,1,0};
		for(int i:solution(n, info)) {
			System.out.println(i);
		}
	}
}
