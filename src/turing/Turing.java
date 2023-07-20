package turing;

import java.util.ArrayList;
import java.util.List;

public class Turing {
    
    public static List<String> Action(String morsecode){
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

    public static void main(String[] args) throws Exception {
        System.out.println(Action("..--...."));
        System.out.println(Action("...."));
    }
}
