package SPW.functional;

import SPW.entity.Expense;
import SPW.entity.ExpenseMetadata;
import SPW.entity.Split;
import SPW.entity.User;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(String id, double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata) {
        super(id, amount, paidBy, splits, metadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }
        return true;
    }
}
