package Problem5FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FibonacciNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int end = Integer.parseInt(reader.readLine());
        Fibonacci fib = new Fibonacci();
        List<Long> list = fib.getFibSequence(start, end);
        StringBuilder sb = new StringBuilder();
        for (Long num : list) {
            sb.append(String.format("%d, ", num));
        }
        sb.replace(sb.length() - 2, sb.length() - 1, "");
        System.out.println(sb);
    }
}

class Fibonacci {
    HashMap<Integer, Long> fibNums;

    Fibonacci() {
        fibNums = new HashMap<>();
        fibNums.put(0, 0L);
        fibNums.put(1, 1L);
    }

    public ArrayList<Long> getFibSequence(int start, int end) {
        ArrayList<Long> nums = new ArrayList<>(end - start);
        for (int i = start; i < end; i++) {
            nums.add(getFib(i));
        }
        return nums;
    }

    private Long getFib(int end) {
        if (!fibNums.containsKey(end)) {
            fibNums.put(end, getFib(end - 1) + getFib(end - 2));
        }
        return fibNums.get(end);
    }
}
