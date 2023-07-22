package turing;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Turing {
    
    public static List<String> getMorseCode(String morsecode){
        List<String> results = new ArrayList<>();
        String previous = morsecode.substring(0, 1);
        for (int i = 1; i < morsecode.length(); i++) {
            String code = morsecode.substring(i, i + 1);
            if(previous.equals(".") && code.equals(".")){
                StringBuilder stringBuilder = new StringBuilder(morsecode);
                stringBuilder.setCharAt(i-1, '-');
                stringBuilder.setCharAt(i, '-');
                results.add(stringBuilder.toString());
            }
            previous = code;
        }
        return results;
    }

    /**
     * @TODO
     */
    public static int getMaxDistanceBtwnChars(String text, char c){

        return -1;
    }
    
    /**
     * @TODO
     */
    public static int[] getMisplacedSequence(int[] sequence){
        // 0 = Duplicated
        // 1 = Lost
        return new int[2];
    }

    public static List<Integer> getDistanceArray(String code, char c){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> distance = new ArrayList<>();
        for(int i = 0; i < code.length(); i++){
            if(c == code.charAt(i)){
                queue.add(i);
            }
        }
        int closestId = queue.remove();
        System.out.println("closestId = " + closestId);
        for(int i = 0; i < code.length(); i++){
            if(!queue.isEmpty() && (Math.abs(closestId - i) > Math.abs(queue.peek() - i))){
                closestId = queue.remove();
            }
            distance.add(Math.abs(closestId - i));
        }
        return distance;
    }



    public static void main(String[] args) throws Exception {
        System.out.println(getMorseCode("..--...."));
        System.out.println(getMorseCode("...."));
    }
}
