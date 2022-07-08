package Test;

import Machine.Enigma;
import Machine.Reflector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class reflectorTest {

    @Test
    public void aReflectorTest(){
        Enigma sample = new Enigma();
        sample.Enigma("Plain Text", new String[]{"A Reflector", "I", "II", "III", "1", "1", "1"},"ZPHNMSWCIYTQEDOBLRFKUVGXJA","ABCDEFGHIJKLMNOPQRSTUVWXUZ");
        assertTrue(Reflector.reflector=="EJMZALYXVBWFCRQUONTSPIKHGD");
    }
    @Test
    public void bReflectorTest(){
        Enigma sample = new Enigma();
        sample.Enigma("Plain Text", new String[]{"B Reflector", "I", "II", "III", "1", "1", "1"},"ZPHNMSWCIYTQEDOBLRFKUVGXJA","ABCDEFGHIJKLMNOPQRSTUVWXUZ");
        assertTrue(Reflector.reflector=="YRUHQSLDPXNGOKMIEBFZCWVJAT");
    }
}
