package java_level2;

import java.util.Arrays;

// 3. 최솟값과 최댓값
public class MaximumAndMinimum {
	
    public String solution(String s) {
        String answer = "";
        String[] stringInts = s.split(" ");
        int[] intArrays = Arrays.stream(stringInts)
        						.mapToInt(Integer::parseInt)
        						.toArray();
        
        int min = intArrays[0];
        int max = intArrays[0];
        
        for(int intArray : intArrays) {
        	if(min > intArray) min = intArray;
        	if(max < intArray) max = intArray;
        }
        
        answer = min + " " + max;
        
        return answer;
    }
	
    public String solution2(String s) {
        String answer = "";
        String[] stringInts = s.split(" ");
        
        int min, max, n;
        min = max = Integer.parseInt(stringInts[0]);
        
        for(String stringInt : stringInts) {
        	n = Integer.parseInt(stringInt);
        	
        	if(min > n) min = n;
        	if(max < n) max = n;
        }
        
        answer = min + " " + max;
        
        return answer;
    }


	public static void main(String[] args) {
		String str = "-1";
		int i = Integer.parseInt(str);
		System.out.println(i);
		
		MaximumAndMinimum mam = new MaximumAndMinimum();
		String str1 = "-1 1 30 -9 35 0 40 -88";
		System.out.println(mam.solution2(str1));
		
	}

}
