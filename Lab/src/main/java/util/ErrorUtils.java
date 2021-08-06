package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class ErrorUtils {

    public static double percentageError(double actualValue, double expectedValue){
        double result = abs((actualValue-expectedValue)/(actualValue));
        return BigDecimal.valueOf(result)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
