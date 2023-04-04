package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaCollections {
    public static void main(String[] args) {
       // arrayList();
       // linkedList();
       // hashMap();
       // linkedHashMap();
       // treeMap();
       // set();
        // hashCodeEquals();
        //  comparator();
        // comparable();
         // queueLinkedList();
       // stack();
        iterator();
    }

    private static void iterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        for (int x : list)
            System.out.println(x);
        while (iterator.hasNext()) {
             iterator.remove();
            System.out.println(iterator.next());

        }

        System.out.println(list);
    }
    private static void stack() {
        Stack<Integer>  stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        while (!stack.empty())
            System.out.println(stack.pop());
    }
    private static void queueLinkedList() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(1);
        queue.add(2);
        queue.offer(2);
        System.out.println(queue);

        for (Integer item : queue) {
            System.out.println(item);
        }
        System.out.println(queue.poll());


        Queue<Integer> queue1 = new ArrayBlockingQueue<>(10);
        queue1.add(3);
        queue1.add(1);
        queue1.add(2);
        queue1.offer(2);
        queue1.remove();
        System.out.println(queue1.peek());
        System.out.println(queue1);

        for (Integer item : queue1) {
            System.out.println(item);
        }
        System.out.println(queue.poll());
    }
    private static void comparable() {
        List<Person> peopleList = new ArrayList<>();
        Set<Person> peopleSet = new TreeSet<>();
        addElements(peopleSet);
        addElements(peopleList);

        Collections.sort(peopleList);
        System.out.println(peopleSet);
        System.out.println(peopleList);

    }
    private static void addElements(Collection collection){
        collection.add(new Person(1, "bob") );
        collection.add(new Person(2, "tom") );
        collection.add(new Person(3, "adam") );
        collection.add(new Person(4, "george") );
    }
    private static void comparator() {
        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("bird");
        animals.add("dog");
        Collections.sort(animals, new StringLengthComparator());
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return -1;
                else if (o1 < o2) return 1;
                return 0;
            }
        });
        System.out.println(numbers);
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "bob"));
        people.add(new Person(3, "marti"));
        people.add(new Person(2,"adam"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getId() > o2.getId() ) return  1;
                else if (o1.getId() < o2.getId())return  -1;
                return 0;
            }
        });

        System.out.println(people);
    }
    private static void set() {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");

        treeSet.add("3");
        treeSet.add("4");
        treeSet.add("5");
        treeSet.add("6");
        System.out.println(hashSet);
        for (String name : hashSet) {
            System.out.println(name);
        }
        System.out.println(hashSet.contains("tom"));
        hashSet.isEmpty();

        // union
        Set<String> union = new HashSet<>(hashSet);
        union.addAll(treeSet);
        System.out.println(union);

        // intersection
        Set<String> intersection = new HashSet<>(hashSet);
        intersection.retainAll(treeSet);
        System.out.println(intersection);

        // difference
        Set<String> difference = new HashSet<>(hashSet);
        difference.removeAll(treeSet);
        System.out.println(difference);
    }
    private static void hashCodeEquals() {
        Set<Person>  set = new HashSet<>();
        Person person1 = new Person(1, "tom");
        Person person2 = new Person(1, "tom");
        set.add(person1);
        set.add(person2);
        System.out.println(set);
    }
    private static void linkedHashMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3,"3");
        map.put(1, "1");
        map.put(2,"2");
        System.out.println(map);
    }
    private static void treeMap() {
        Map<Integer,String > map = new TreeMap<>();
        map.put(3,"3");
        map.put(1, "1");
        map.put(2,"2");
        System.out.println(map);
    }
    private static void hashMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(3,"3");
        map.put(1, "1");
        map.put(2,"2");
        System.out.println(map);
        for(Map.Entry<Integer,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
    private static void arrayList() {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            arr.add(i);
        }
        System.out.println(arr);
        System.out.println(arr.get(1));
        System.out.println(arr.size());

        for (int i: arr) {
            System.out.print(i);
        }
        arr.remove(0);
        System.out.println(arr);
    }
    private static void linkedList() {
        List<Integer>linkedList= new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(10);
        myLinkedList.add(20);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));
        myLinkedList.remove(1);
        measureTime(linkedList);
        measureTime(arrayList);
    }
    private static void measureTime( List<Integer> list) {

       long start = System.currentTimeMillis();
       for(int i = 0; i < 100000; i++ ) {
           list.add(0, i);
       }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
   }
}

class BackwardsIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) return -1;
        else if (o1 < o2) return 1;
        return 0;
    }
}
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()) {
            return 1;
        } else if(o1.length() < o2.length()){
            return -1;
        }
        else return 0;
    }
}