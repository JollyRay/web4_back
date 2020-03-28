package lab4.area;

import lab4.validation.OneOf;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Service
@Validated
public class AreaService {

    public boolean contains(
            @DecimalMin(value = "-3") @DecimalMax(value = "5")
            double x,
            @DecimalMin(value = "-3") @DecimalMax(value = "5")
                    double y,
            @DecimalMin(value = "-3") @DecimalMax(value = "5")
                    double r
    ) {
        if (r < 0) {
            return doContains(-x, -y, -r);
        }

        return doContains(x, y, r);
    }

    private boolean doContains(double x, double y, double r) {

        return (
                (x<r && y<r && y>=0 && x >=0) ||
                (x <= 0 && y >= 0 && y <= 0.5*(x+r)) ||
                (x >=0 && y <= 0 && x*x + y*y <= r*r/4)
        );

    }
}
