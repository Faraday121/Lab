package Main;

import org.junit.Test;

import static Main.assignment.simpson;
import static org.junit.Assert.*;

public class assignmentTest {

    @Test
    public void Q1() {
        double t = 9.5;
        double n = 4;
        double a = 0;
        double b = 9.5;
        double result =simpson(a,b,n,t);
        System.out.println(result);
        assertEquals(294.1,result,1);


    }
}