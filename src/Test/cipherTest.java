package Test;

import Machine.Enigma;
import Machine.Rotor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class cipherTest
{
    @Test
    public void machineCheck(){
        Enigma sample = new Enigma();
        assertEquals("YZFBKRLMP", sample.Enigma("Plain Text", new String[]{"A Reflector", "I", "II", "III", "1", "1", "1"},"ZPHNMSWCIYTQEDOBLRFKUVGXJA","ABCDEFGHIJKLMNOPQRSTUVWXUZ"));
    }
}
