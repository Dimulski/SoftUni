package bg.softuni.repository;

import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorySorters {
    public static void printSortedStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String comparisonType,
            int numberOfStudents) {
        comparisonType = comparisonType.toLowerCase();

        if (!comparisonType.equals("ascending") && !comparisonType.equals("descending")) {
            OutputWriter.displayException(ExceptionMessages.INVALID_COMPARISON_QUERY);
            return;
        }

        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator = (x, y) -> {
            double value1 = x.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble();
            double value2 = y.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble();
            return Double.compare(value1, value2);
        };

        List<String> sortedStudents = courseData.entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }


        printStudents(courseData, sortedStudents);
    }

    private static void printStudents(HashMap<String, ArrayList<Integer>> courseData, List<String> sortedStudents) {
        for (String student : sortedStudents) {
            OutputWriter.printStudent(student, courseData.get(student));
        }
    }
}

