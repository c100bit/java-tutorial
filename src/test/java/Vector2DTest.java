import org.example.testing.Vector2D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {
    private static Vector2D v1;
    private final double EPS = 1e-9;

    @BeforeClass
    public static void createNewVector() {
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength() {
        Assert.assertEquals(0, v1.length(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Assert.assertEquals(0, v1.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Assert.assertEquals(0, v1.getY(), EPS);
    }

    @Test(timeout = 1000)
    public void getConnectionShouldReturnFasterThanOneSecond() {
        Vector2D.getConnection();
    }
}