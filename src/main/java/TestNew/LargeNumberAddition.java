package TestNew;

/*
WITH CTE AS {
    SELECT
        name,
        ROW_NUMBER() OVER (PARTITION BY name ORDER BY name) as rom_num
        FROM
         NAME_TABLE
    }

    DELETE FROM CTE WHERE name IN (SELECT name from CTE where row_num > 1);
*/
public class LargeNumberAddition {
    public static void main(String[] args) {
        String num1 = "9999999999999999999";
        String num2 = "1";
        System.out.println("Sum: " + addLargeNumber(num1, num2));
    }

    private static String addLargeNumber(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        num1 = new StringBuilder(num1).reverse().toString(); // O(N)
        num2 = new StringBuilder(num2).reverse().toString(); // O(N)

        int maxLength = Math.max(num1.length(), num2.length());
        int carry = 0;

        for(int i=0; i<maxLength; i++) { // O (maxLength)
            int digit1 = i <  num1.length() ? num1.charAt(i)-'0' : 0;
            int digit2 = i <  num2.length() ? num2.charAt(i)-'0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }

        if(carry!=0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

}
