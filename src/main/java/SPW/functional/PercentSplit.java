package SPW.functional;

import SPW.entity.Split;
import SPW.entity.User;

public class PercentSplit extends Split {
    double percent;

    public PercentSplit(User user) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
