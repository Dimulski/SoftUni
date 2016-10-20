package Problem6PrimeChecker;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PrimeChecker {

    public static void main(String[] args) throws IOException {

        Field[] fields = Number.class.getDeclaredFields();

        List<Field> filedsDeclared = Arrays.stream(fields) // gj
                .filter(f -> f.getName().contains("isPrimeMaybe") || f.getName().contains("number"))
                .collect(Collectors.toList());

        List<Constructor<?>> constructors = Arrays.stream(Number.class.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() > 1)
                .collect(Collectors.toList());

        if (filedsDeclared.size() <= 1 || constructors.size() < 1 ) {
            throw new ClassFormatException();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Random rnd = new Random();
        Number number = new Number(n, rnd.nextBoolean());
        Object[] results = number.returnResults();
        System.out.println(results[0] + ", " + results[1]);
    }
}

class Number {
    int number;
    boolean isPrimeMaybe;

    Number(int number, boolean isPrimeMaybe) {
        // "They should be passed as parameters to the constructor
        // (Note there could be a case in which a passed Boolean value does not match)." What's the point then?
        this.number = number;
        this.isPrimeMaybe = isPrimeMaybe;
    }

    public String[] returnResults() { //
        boolean isActuallyPrime = isPrime(number);
        number += 1;
        while (true) {
            if (isPrime(number)) {
                break;
            } else {
                number++;
            }
        }
        String[] results = new String[2];
        results[0] = number + "";
        results[1] = isActuallyPrime + "";
        return results;
    }

    public String toString() {
        return this.number + "";
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0 && i != number) return false;
        }
        return true;
    }
}
