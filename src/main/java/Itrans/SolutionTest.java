package Itrans;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void testNoInvalidTransactions() {
        Solution solution = new Solution();
        String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing"};
        List<String> expected = Arrays.asList();
        List<String> result = solution.invalidTransactions(transactions);
        assertNotEquals(expected, result);
    }

    @Test
    public void testSingleTransactionOverLimit() {
        Solution solution = new Solution();
        String[] transactions = {"alice,20,1200,mtv"};
        List<String> expected = Arrays.asList("alice,20,1200,mtv");
        List<String> result = solution.invalidTransactions(transactions);
        assertEquals(expected, result);
    }

    @Test
    public void testTransactionsDifferentCitiesWithin60Minutes() {
        Solution solution = new Solution();
        String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing"};
        List<String> expected = Arrays.asList("alice,20,800,mtv","alice,50,100,beijing");
        List<String> result = solution.invalidTransactions(transactions);
        assertEquals(expected, result);
    }

    @Test
    public void testTransactionsSameCityWithin60Minutes() {
        Solution solution = new Solution();
        String[] transactions = {"bob,20,500,nyc","bob,50,300,nyc"};
        List<String> expected = Arrays.asList();
        List<String> result = solution.invalidTransactions(transactions);
        assertEquals(expected, result);
    }

    @Test
    public void testMultipleInvalidTransactions() {
        Solution solution = new Solution();
        String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing","bob,20,1200,mtv"};
        List<String> expected = Arrays.asList("alice,20,800,mtv","alice,50,100,beijing","bob,20,1200,mtv");
        List<String> result = solution.invalidTransactions(transactions);
        assertEquals(expected, result);
    }

    @Test
    public void testOverlappingTimeDifferentCities() {
        Solution solution = new Solution();
        String[] transactions = {"charlie,20,500,nyc","charlie,25,300,la"};
        List<String> expected = Arrays.asList("charlie,20,500,nyc","charlie,25,300,la");
        List<String> result = solution.invalidTransactions(transactions);
        assertEquals(expected, result);
    }

    @Test
    public void testExactly60MinutesDifferenceSameCity() {
        Solution solution = new Solution();
        String[] transactions = {"david,20,500,mtv","david,80,600,mtv"};
        List<String> expected = Arrays.asList();
        List<String> result = solution.invalidTransactions(transactions);
        assertEquals(expected, result);
    }

    @Test
    public void testExactly60MinutesDifferenceDifferentCities() {
        Solution solution = new Solution();
        String[] transactions = {"eve,20,500,nyc","eve,80,600,la"};
        List<String> expected = Arrays.asList("eve,20,500,nyc","eve,80,600,la");
        List<String> result = solution.invalidTransactions(transactions);
        assertEquals(expected, result);
    }
}
