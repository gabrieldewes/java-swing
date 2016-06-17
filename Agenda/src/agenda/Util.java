package agenda;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Dewes
 */
public class Util {
    
    public static String ArrayToString(ArrayList<String> list) {
        StringBuilder listString = new StringBuilder();
        list.stream().forEach((s) -> {
            listString.append(s).append(" ");
        });
        return listString.toString();
    }
    
     public static String ArrayToStringComma(ArrayList<String> list) {
        StringBuilder listString = new StringBuilder();
        list.stream().forEach((s) -> {
            listString.append(s).append(", ");
        });
        String s = listString.toString();
        s = s.substring (0, s.length() - 2);
        return s;
    }
     
     public static ArrayList StringToArray(String str) {
        ArrayList<String> list = new ArrayList<>();
        String[] arrayValores = str.split(" ");
        list.addAll(Arrays.asList(arrayValores)); 
         return list;
     }
    
}
