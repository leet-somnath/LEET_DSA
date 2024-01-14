import java.util.*;

public class Collection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArrayList
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        // common methods
        x.add(5);
        x.add(4);
        y.addAll(x);
        System.out.println("ArrayList y: " + y);

        y.removeAll(x);
        System.out.println("ArrayList y after removeAll(x): " + y);

        x.clear();
        System.out.println("ArrayList x after clear(): " + x);
        System.out.println("Is ArrayList x empty? " + x.isEmpty());
        System.out.println("Size of ArrayList x: " + x.size());

        // sort
        x.add(3);
        x.add(1);
        x.add(6);
        System.out.println("Original ArrayList x: " + x);
        Collections.sort(x);
        System.out.println("Sorted ArrayList x: " + x);

        // reverse
        Collections.reverse(x);
        System.out.println("Reversed ArrayList x: " + x);

        // binarySearch
        int searchKey = 4;
        int index = Collections.binarySearch(x, searchKey);
        System.out.println("Index of " + searchKey + " after sorting: " + index);

        // frequency
        int frequencyOfElement = Collections.frequency(x, 3);
        System.out.println("Frequency of 3 in ArrayList x: " + frequencyOfElement);

        // min
        int minValue = Collections.min(x);
        System.out.println("Minimum value in ArrayList x: " + minValue);

        // max
        int maxValue = Collections.max(x);
        System.out.println("Maximum value in ArrayList x: " + maxValue);

        // HashSet
        HashSet<Integer> z = new HashSet<>();
        z.add(10);
        // common methods
        System.out.println("HashSet z: " + z);
        System.out.println("Is HashSet z empty? " + z.isEmpty());
        System.out.println("Does HashSet z contain 10? " + z.contains(10));
        System.out.println("Size of HashSet z: " + z.size());

        //
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        // Adding elements
        linkedHashSet.add(5);
        linkedHashSet.add(2);
        linkedHashSet.add(8);
        linkedHashSet.add(1);

        // Iterating over elements (in insertion order)
        System.out.println("Elements in LinkedHashSet: " + linkedHashSet);

        // Checking for existence
        System.out.println("Contains 2? " + linkedHashSet.contains(2));

        // Removing elements
        linkedHashSet.remove(2);
        System.out.println("After removing 2: " + linkedHashSet);

        // Size
        System.out.println("Size of LinkedHashSet: " + linkedHashSet.size());

        // Iterating using iterator
        Iterator<Integer> iterator = linkedHashSet.iterator();
        System.out.print("Iteration using iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Clearing the set
        linkedHashSet.clear();
        System.out.println("After clearing the set: " + linkedHashSet);

        // TreeSet maintains in sorted order
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(20);
        treeSet.add(40);
        // common methods
        System.out.println("TreeSet treeSet: " + treeSet);
        System.out.println("First element in TreeSet: " + treeSet.first());
        System.out.println("Last element in TreeSet: " + treeSet.last());
        System.out.println("Element less than or equal to 25: " + treeSet.floor(25));
        System.out.println("Element greater than or equal to 35: " + treeSet.ceiling(35));

        // HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        // common methods
        System.out.println("HashMap hashMap: " + hashMap);
        System.out.println("Is HashMap hashMap empty? " + hashMap.isEmpty());
        System.out.println("Value associated with key 'Two': " + hashMap.get("Two"));
        System.out.println("Contains key 'Four'? " + hashMap.containsKey("Four"));
        System.out.println("Contains value 3? " + hashMap.containsValue(3));

        // TreeMap maintains the sorted order order
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Apple", 5);
        treeMap.put("Banana", 3);
        treeMap.put("Orange", 7);
        // common methods
        System.out.println("TreeMap treeMap: " + treeMap);
        System.out.println("Is TreeMap treeMap empty? " + treeMap.isEmpty());
        System.out.println("Value associated with key 'Banana': " + treeMap.get("Banana"));
        System.out.println("First key in TreeMap: " + treeMap.firstKey());
        System.out.println("Last key in TreeMap: " + treeMap.lastKey());
        // Creating a LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Adding entries
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Two", 2);
        linkedHashMap.put("Three", 3);

        // Iterating over entries (in insertion order)
        System.out.println("Entries in LinkedHashMap: " + linkedHashMap);

        // Checking for existence
        System.out.println("Contains key 'Two'? " + linkedHashMap.containsKey("Two"));
        System.out.println("Contains value 3? " + linkedHashMap.containsValue(3));

        // Getting values
        System.out.println("Value for key 'Three': " + linkedHashMap.get("Three"));

        // Size
        System.out.println("Size of LinkedHashMap: " + linkedHashMap.size());

        // Iterating over entries using entrySet
        System.out.print("Iteration using entrySet: ");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") ");
        }
        System.out.println();
        sc.close();
    }
}
