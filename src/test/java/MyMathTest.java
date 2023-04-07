import org.example.testing.MyMath;
import org.junit.Test;

public class MyMathTest {
    @Test(expected = ArithmeticException.class)
    public void zeroDenominatorShouldThrowException() {
        MyMath.divide(1, 0);

    }
}
