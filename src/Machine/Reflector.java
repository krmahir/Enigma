package Machine;

public class Reflector{
    public static String reflector;

    public Reflector(String bReflector) {
        this.reflector=bReflector;
    }

    public static char ref(char p){
        char[] ref = reflector.toCharArray();
            if (64 < (int) p && 91 > (int) p){
                p = ref[(int) p -65];
            }
        return p;
    }
}
//ZPHNMSWCIYTQEDOBLRFKUVGXJA";