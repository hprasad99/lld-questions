package SPW.functional;

import SPW.entity.Split;
import SPW.entity.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
