package Machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rotor {
    public static char[][] rotor = new char[3][26];
    static String letters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static  char[] alp = letters.toCharArray();
    static int fastRotorCheck, middleRotorChecker;
    static Map<Character, Character> hashMap = new HashMap<Character, Character>();

    public Rotor(char[][] rotor) {
        this.rotor=rotor;
    }

    public static char forwardRouting (char p){
            if (64 < (int) p && 91 > (int) p) {
                p = rotor[0][(int) p - 65];
                p = rotor[1][(int) p-65];
                p = rotor[2][(int) p-65];

            }
        return p;
    }
    static char backwardRouting(char p){
        for(int i = 2;i>=0;i--){
            for (int j = 0; j < rotor[i].length&& j < alp.length; j++) {
                hashMap.put(rotor[i][j], alp[j]);
            }
            //for(int j=0; j< charText.length;j++){
                if (64 < (int) p && 91 > (int) p){
                    p = hashMap.get(p);
                }
            //}
        }
        if(64 < (int) p && 91 > (int) p) {
            rotor[0] = rotation(rotor[0], 1);
            fastRotorCheck++;
            if (fastRotorCheck / 26 == 1) {
                fastRotorCheck -= 25;
                middleRotorChecker++;
                rotor[1] = rotation(rotor[1], 1);
            }


            if (middleRotorChecker / 26 == 1) {
                middleRotorChecker -= 25;
                rotor[2] = rotation(rotor[2], 1);
            }
        }
        return p;

    }
    public static char[] rotation(char[] modRouter, int n) {
        for(int j=0;j<n;j++){
            char temp;
            temp = modRouter[modRouter.length-1];
            for (int i = modRouter.length-1; i >0; i--) {
                modRouter[i] = modRouter[i-1];
            }
            modRouter[0]=temp;
        }

        return modRouter;
    }
}
