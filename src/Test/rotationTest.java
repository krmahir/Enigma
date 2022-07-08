package Test;

import Machine.Rotor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;

import static jdk.jfr.internal.consumer.StringParser.Encoding.CHAR_ARRAY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class rotationTest {
    @Test
    public void rotationCheck(){
        assertEquals("EABCD", String.valueOf(Rotor.rotation("ABCDE".toCharArray(),1)));
    }
    @Test
    public void rotationCheck1(){
        assertEquals("EFABCD", String.valueOf(Rotor.rotation("ABCDEF".toCharArray(),2)));
    }

}
