package Level1;

import java.util.Arrays;

public class Knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int pick = commands[i][2]-1;
            int idx = 0;
            int [] arr = new int[end-start+1];
            for(int j=start-1; j<end; j++ ) {
                arr[idx] = array[j];
                idx++;
            }
            Arrays.sort(arr);
            answer[i] = arr[pick];
        }
        return answer;
    }
}
