package ���α׷��ӽ�;

import java.text.SimpleDateFormat;
import java.util.*;

public class īī��_1���߼�Ʈ���� {
	
	static class Log{
		private long start, end;
		
		public Log(long start, long end) {
			this.start=start;
			this.end=end;
		}
		@Override
		public String toString() {
			return start+" "+end;
		}
	}
	
	
	public static int solution(String[] lines) {
        int answer = 1;
        List<Log> logs = new LinkedList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
        StringTokenizer st;
        for(String line:lines){
            try {
                st=new StringTokenizer(line);
                st.nextToken();
                Date time =sdf.parse(st.nextToken());
                long end = time.getTime(); //���ð�
                long duration=(int)(Double.parseDouble(st.nextToken().replace("s", ""))*1000); //ó���ð�
                long start = end-duration+1; //���۽ð�
                logs.add(new Log(start, end));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        for(int i=0;i<logs.size();i++) {
            int curr = 0;
            long end = logs.get(i).end;
            long er = end + 1000; //1�� ����
            for(int j = i; j < logs.size(); j++) {
                long s = logs.get(j).start;
                long e = logs.get(j).end;
                if(er<=s) continue; 
                if(s<er&&e>=end||s>=end&&e<er){
                    curr++;
                }

            }
            answer = Math.max(answer, curr);
        }
        
        return answer;
	}
	
	public static void main(String[] args) {
		String[] lines = {"2016-09-15 01:00:04.001 2.1s","2016-09-15 01:00:07.000 2s"};
		String[] lines2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		System.out.println(solution(lines2));
	}
}
