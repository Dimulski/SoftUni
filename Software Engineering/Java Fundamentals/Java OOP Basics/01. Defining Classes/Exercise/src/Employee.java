import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

    String name;
    Double salary;
    String position;
    String department;
    String email;
    String age;

    Employee(String name, Double salary, String position, String department, String email, String age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
//    Employee(String name, double salary, String position, String department, String email) {
//        this(name, salary, position, department, email, -1);
//    }
//    Employee(String name, double salary, String position, String department, int age) {
//        this(name, salary, position, department, "n/a", age);
//    }

    public static void main(String[] args) throws IOException { // We'll trust that in a department two people wont have the same salary (sorting: because we sort by salary and no other param.)

        Map<String, LinkedList<Double>> departmentAndItsSalaries = new HashMap<>();
        Map<String, LinkedList<Employee>> departmentAndEmployeesInIt = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] lineParams = reader.readLine().split(" ");

            String name = lineParams[0];
            Double salary = Double.parseDouble(lineParams[1]);
            String position = lineParams[2];
            String department = lineParams[3];

            String email = "n/a";
            String age = "-1";

            if (lineParams.length == 5) {
                Pattern pattern = Pattern.compile("^-*\\d+$");
                Matcher matcher = pattern.matcher(lineParams[4]);
//                try {
//                    age = Integer.parseInt(lineParams[4]);
//                } catch (NumberFormatException e) {
//                    email = lineParams[4];
//                    age = -1;
//                }
                if (matcher.find()) {
                    age = lineParams[4];
                } else {
                    email = lineParams[4];
                }
            } else if (lineParams.length == 6){ // I had to make age a String because one test was throwing an exception from these 3 lines.
                email = lineParams[4];
                age = lineParams[5];
            }

            Employee employee = new Employee(name, salary, position, department, email, age);

            if (!departmentAndItsSalaries.containsKey(employee.department)) {
                departmentAndItsSalaries.put(employee.department, new LinkedList<>());
            }
            departmentAndItsSalaries.get(employee.department).add(salary);
            if (!departmentAndEmployeesInIt.containsKey(employee.department)) {
                departmentAndEmployeesInIt.put(employee.department, new LinkedList<>());
            }
            departmentAndEmployeesInIt.get(employee.department).add(employee);
        }

        NavigableMap<Double, String> depAndAverageSalary = new TreeMap<>(); // We assume that no two departments will have the same average salary.
        for (Map.Entry<String, LinkedList<Double>> depListSalary : departmentAndItsSalaries.entrySet()) {
            double avgSalary = 0;
            for (Double salary : depListSalary.getValue()) {
                avgSalary += salary;
            }
            avgSalary /= depListSalary.getValue().size();
            depAndAverageSalary.put(avgSalary, depListSalary.getKey());
        }
        String dep = depAndAverageSalary.lastEntry().getValue();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Highest Average Salary: %s%s", dep, System.lineSeparator()));

        //Collections.sort(departmentAndEmployeesInIt.get(dep), new CustomComparator());
        departmentAndEmployeesInIt.get(dep).stream().sorted((e1, e2) -> e2.salary.compareTo(e1.salary))
                .forEach(e -> sb.append(String.format("%s %.2f %s %s%s", e.name, e.salary, e.email, e.age, System.lineSeparator())));

        System.out.println(sb);
    }

    public static class CustomComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e2.salary.compareTo(e1.salary);
        }
    }
}
