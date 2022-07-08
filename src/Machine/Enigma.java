package Machine;

import java.lang.*;

import static Machine.PlugBoard.substitute;

public class Enigma {
    public String Enigma(String m, String[] config,String plugLeft,String plugRight) {
        char[] charText;
        m= m.replace(" ","").toUpperCase();
        charText = m.toCharArray();
        String I= "QVZNTOWYHXUSPAIBRCJEKMFLGD", II= "EAJDKSIRUXBLHWTMCQGZNPYFVO", III= "VZNYEIWGAKMUSQOBDFHJLCPRTX", IV= "ESOVPZJAYQUIRHXLNFTGKDCMWB", V= "VZBRGITYUPSDNHLXAWMJQOFECK";
        String bReflector= "EJMZALYXVBWFCRQUONTSPIKHGD", cReflector= "YRUHQSLDPXNGOKMIEBFZCWVJAT";
        char[][] rotor = new char[3][26];
        PlugBoard plug = new PlugBoard(plugLeft, plugRight);
        Reflector ref;
        Rotor rot = null;
        if(config[0]=="A Reflector"){
            ref = new Reflector(bReflector);
        }
        else{
            ref = new Reflector(cReflector);
        }
        for(int j = 1,k = 2;j<4;j++,k--){
            switch (config[j]){
                case "I":rotor[k] = I.toCharArray();break;
                case "II":rotor[k] = II.toCharArray();break;
                case "III":rotor[k] = III.toCharArray();break;
                case "IV":rotor[k] = IV.toCharArray();break;
                case "V":rotor[k] = V.toCharArray();break;
            }
            rotor[k]=rot.rotation(rotor[k], Integer.parseInt(config[j+3])-1);
        }
        
        rot = new Rotor(rotor);
        rot.fastRotorCheck=0;
        rot.middleRotorChecker=0;
         for(int i=0;i< charText.length;i++) {
             charText[i] = plug.substitute(charText[i]);
             charText[i] = rot.forwardRouting(charText[i]);
             charText[i] = ref.ref(charText[i]);
             charText[i] = rot.backwardRouting(charText[i]);
             charText[i] = plug.substitute(charText[i]);
         }
        m = String.valueOf(charText);
        return m;
    }
}