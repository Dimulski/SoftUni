package Problem8MultiplyBigBumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by User on 11.6.2016 г..
 */
public class CheatingMultiplyBigNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger firstNum = new BigInteger(reader.readLine());
        BigInteger secondNum = new BigInteger(reader.readLine());
        BigInteger sum = firstNum.multiply(secondNum);
        System.out.println(sum);
    }
}
