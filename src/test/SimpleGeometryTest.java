import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleGeometryTest {

    @Test
    public void tt() {
        System.out.println(BigDecimal.valueOf(13.5393432).setScale(3, RoundingMode.CEILING).doubleValue());
        System.out.println(BigDecimal.valueOf(13.5393432).setScale(4, RoundingMode.DOWN).doubleValue());
        System.out.println(BigDecimal.valueOf(13.5393432).setScale(4, RoundingMode.FLOOR).doubleValue());
        System.out.println(BigDecimal.valueOf(13.5393432).setScale(4, RoundingMode.HALF_DOWN).doubleValue());
        System.out.println(BigDecimal.valueOf(13.5393432).setScale(4, RoundingMode.HALF_EVEN).doubleValue());
        System.out.println(BigDecimal.valueOf(13.5393432).setScale(4, RoundingMode.HALF_UP).doubleValue());
        System.out.println(BigDecimal.valueOf(13.5393432).setScale(3, RoundingMode.UP).doubleValue());
    }

}
