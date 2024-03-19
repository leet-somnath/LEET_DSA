import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = Arrays.asList(3, 3, 3, 34, 3);

        // Filter and forEach
        System.out.println("Even numbers:");
        arr.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));

        // Map in streams
        System.out.println("Mapped values (adding 2):");
        arr.stream().map(x -> x + 2).forEach(x -> System.out.println(x));

        // Collect in streams
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String> result = names.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("Filtered names starting with 'S':");
        System.out.println(result);

        // Sorted in stream
        System.out.println("Sorted elements:");
        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        // Additional Stream methods
        System.out.println("Distinct elements:");
        List<Integer> distinctElements = arr.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctElements);

        System.out.println("Limited elements:");
        List<Integer> limitedElements = arr.stream().limit(3).collect(Collectors.toList());
        System.out.println(limitedElements);

        System.out.println("Skipped elements:");
        List<Integer> skippedElements = arr.stream().skip(2).collect(Collectors.toList());
        System.out.println(skippedElements);

        Optional<Integer> sum = arr.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println("Sum of elements: " + sum.get());
        }

        boolean anyMatch = arr.stream().anyMatch(x -> x > 10);
        System.out.println("Any element greater than 10? " + anyMatch);

        boolean allMatch = arr.stream().allMatch(x -> x < 50);
        System.out.println("All elements less than 50? " + allMatch);

        boolean noneMatch = arr.stream().noneMatch(x -> x == 0);
        System.out.println("No element equal to 0? " + noneMatch);

        Optional<Integer> firstElement = arr.stream().findFirst();
        System.out.println("First element: " + firstElement.orElse(null));

        Optional<Integer> anyElement = arr.stream().findAny();
        System.out.println("Any element: " + anyElement.orElse(null));

        System.out.println("Array representation:");
        Integer[] array = arr.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));

        System.out.println("FlatMap example:");
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<Integer> flatList = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flatList);

        int arraySum = arr.stream().reduce(0, Integer::sum);
        System.out.println("Sum of elements using reduce: " + arraySum);

        Optional<Integer> min = arr.stream().min(Comparator.naturalOrder());
        System.out.println("Minimum element: " + min.orElse(null));

        Optional<Integer> max = arr.stream().max(Comparator.naturalOrder());
    
        System.out.println("Maximum element: " + max.orElse(null));

        long count = arr.stream().count();
        System.out.println("Number of elements: " + count);

        sc.close();
    }
}
