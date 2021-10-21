package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 탐욕법_단속카메라 {
	/*
	고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.

	고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때,
	모든 차량이 한 번은 단속용 카메라를 만나도록 하려면
	최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.

	제한사항

	차량의 대수는 1대 이상 10,000대 이하입니다.
	routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점,
	routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
	차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
	차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.

	*/
	
	public static int solution(int[][] routes) {
        int answer = 0;
        //빨리 나가는 순으로 정렬
        Arrays.sort(routes,(x,y)->x[1]-y[1]);
        //list에 집어넣기
        List<int[]> list = new ArrayList<>();
        for(int[] route:routes) list.add(route);
        
        while(!list.isEmpty()) {
        	int[] now=list.get(0);
        	int camera = now[1];//마지막 지점에 카메라 설치
        	for(int i=0;i<list.size();i++) {
        		int[] car = list.get(i);
                //출발지점<=카메라지점이면 해당 차량은 지우고 다시 실행
        		if(car[0]<=camera) list.remove(i--); 
        	}  
            //카메라 수 증가
        	answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] routes= {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
		
	}

}
