package DSA;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPICoding {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        filterEvens(numbers1);
        List<Integer> numbers2 = Arrays.asList(10, 20, 30, 40, 50);
        findMax(numbers2);
        List<Integer> numbers3 = Arrays.asList(3, 5, 1, 4, 2);
        sortList(numbers3);
        List<String> names1 = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        countStringsWithPrefix(names1, "A");
        String input = "swiss";
        firstNonRepeatedChar(input);
        List<String> names2 = Arrays.asList("java", "stream", "api");
        toUpperCase(names2);
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        sumInTheList(numbers4);
        List<String> strings = Arrays.asList("Java", "Stream API", "Lambda");
        mactchingString(strings);
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        findDuplicates(numbers5);
        List<String> words1 = Arrays.asList("Java", "Stream", "API", "Code", "Fun");
        groupStringsByLength(words1);
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        flattenList(listOfLists);
        List<String> words2 = Arrays.asList("Stream", "API", "is", "powerful");
        concatenateWords(words2);
        List<String> words3 = Arrays.asList("Java", "Stream", "API", "Development");
        longestWord(words3);

    }

    private static void longestWord(List<String> words3) {
        String longestWord = words3.stream().reduce("", (s1,s2) -> s1);
    }

    private static void concatenateWords(List<String> words2) {
        String concatenateWords = words2.stream().reduce("", (s1,s2) -> s1+ " " +s2).trim();
        System.out.println(concatenateWords);
    }

    private static void flattenList(List<List<Integer>> listOfLists) {
        List<Integer> flatList = listOfLists.stream().flatMap(List::stream).toList();
        System.out.println(flatList);
    }

    private static void groupStringsByLength(List<String> words) {
        Map<Integer, List<String>> groupStringsByLength = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupStringsByLength);
    }

    private static void findDuplicates(List<Integer> numbers5) {
        Set<Integer> duplicateNums = numbers5.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(r -> r.getKey())
                .collect(Collectors.toSet());
        System.out.println(duplicateNums);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers5.stream().filter(i -> !seen.add(i))
                        .collect(Collectors.toSet());
        System.out.println(duplicates);
    }

    private static void mactchingString(List<String> strings) {
        boolean mactchingString = strings.stream().anyMatch(s -> s.contains("API"));
        System.out.println(mactchingString);
    }

    private static void sumInTheList(List<Integer> numbers4) {
        int summing = numbers4.stream().mapToInt(Integer::intValue).sum();
        System.out.println(summing);
    }

    private static void toUpperCase(List<String> names2) {
        System.out.println(names2.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }

    private static void firstNonRepeatedChar(String input) {
        Optional<Character> firstNonRepeatedChar = input.chars().mapToObj(c -> (char)c).filter(c -> input.indexOf(c) == input.lastIndexOf(c)).findFirst();
        System.out.println(firstNonRepeatedChar.orElse(null));
    }

    private static void countStringsWithPrefix(List<String> names, String a) {
        List<String> nameList = names.stream().filter(name -> name.startsWith("A")).toList();
        long count = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(nameList + " " + "count = " + count);
    }

    private static void sortList(List<Integer> numbers3) {
        numbers3.sort((a,b) -> Integer.compare(b, a));
        System.out.println(numbers3);
        numbers3.sort(Comparator.reverseOrder());
        System.out.println(numbers3);
    }

    private static void findMax(List<Integer> numbers2) {
        System.out.println(numbers2.stream().max(Integer::compare).orElseThrow());
    }

    public static void filterEvens(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(nums -> nums % 2 == 0).collect(Collectors.toList()));
    }
}
