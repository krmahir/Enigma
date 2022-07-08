package Machine;

import java.util.HashMap;
import java.util.Map;

public class PlugBoard extends NullPointerException{


    public static Map<Character, Character> r1 = new HashMap();
    private static String plugBoard ;
    private static char[] ref = new String("ZPHNMSWCIYTQEDOBLRFKUVGXJA").toCharArray();
    static  char[] alp = new String("ABCDEFGHIJKLMNOPQRSTUVWXUZ").toCharArray();;

    public PlugBoard(String plugLeft, String plugRight) {
        try{
            alp = plugLeft.toCharArray();
            ref = plugRight.toCharArray();
            for(int i=0;i<ref.length;i++){
                r1.put(ref[i],alp[i]);
            }

        }
        catch (NullPointerException npe){
            for(int i=0;i<ref.length;i++){
                r1.put(ref[i],alp[i]);
            }
        }


    }


    public static char substitute(char copy){
        if (64 < (int) copy && 91 > (int) copy) {
            copy= r1.get(copy);
        }

        return copy;
    }


}
