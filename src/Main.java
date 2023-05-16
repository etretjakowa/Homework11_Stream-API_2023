import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        Задача 1
        Stream<Employees> employeesStream = Stream.of(new Employees("Сергей", 29),
                new Employees("Иван", 45),
                new Employees("Наталья", 36),
                new Employees("Ольга", 28),
                new Employees("Дмиитрий", 42),
                new Employees("Татьяна", 44));

        BiConsumer<Employees, Employees> biConsumer = (min, max) -> System.out.println(min.toString() + max.toString());
        Comparator<Employees> employeesComparator = Comparator.comparing(Employees::getAge).thenComparing(Employees::getName);
        findMinMax(employeesStream, employeesComparator, biConsumer);

//        Задача 2
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(21);
//        list1.add(454);
//        list1.add(35);
//        list1.add(75);
//        list1.add(159);
//        list1.add(48);
//        list1.add(96);
//        list1.add(79);
//
//findsEvenNumber(list1);

        findsEvenNumber(List.of(444, 5, 88, 79, 1, 2, 56, 97, 15, 97));
    }

//        Задача 1
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }

    }

//        Задача 2
  public static void findsEvenNumber(List<Integer> list){
      Stream<Integer> stream = list.stream();
      Predicate<Integer> predicate = (n) -> (n % 2) == 0;
      Stream<Integer> filterStream = stream.filter(predicate);
      System.out.println("Количество чётных чисел = " + filterStream.count());
    }
}