package Problem4NumberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class NumberInReversedOrder {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal num = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
        DecimalNumber dec = new DecimalNumber(num);
        System.out.println(dec.reversed());
    }
}

class DecimalNumber {
    BigDecimal num;

    DecimalNumber(BigDecimal num) {
        this.num = num;
    }

    BigDecimal reversed() {
        String number = this.num.toString();
        if (number.endsWith(".0")) {
            number = number.substring(0, number.length() - 2);
            return BigDecimal.valueOf(Double.parseDouble(new StringBuilder(number).reverse().toString())).setScale(0);
        }
        return BigDecimal.valueOf(Double.parseDouble(new StringBuilder(number).reverse().toString()));
    }
}
