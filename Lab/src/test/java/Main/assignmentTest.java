package Main;
import org.junit.Test;
import static org.junit.Assert.*;
public class assignmentTest {
    @Test
    public void Q(){
        double t = 9.5;
        double n = 4;
        double a = 0;
        double b = 9.5;
        double result = assignment.simpson2(a,b,n,t);
        assertEquals(490.61,result,1);
    }

}