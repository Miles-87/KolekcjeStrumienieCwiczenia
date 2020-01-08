import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static List<Worker> oldestPeople(List<Worker> workers){
        if(workers == null){
            return null;
        }
        return  workers
                .stream()
                .sorted(Comparator.comparing(/*w -> w.getAge()*/Worker::getAge, Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());
    }
    public static Map<Integer, List<Worker>> groupedByHireYear(List<Worker> workers) {
        if(workers == null){
            return null;
        }
        return workers
                .stream()
                .collect(Collectors.groupingBy(w -> w.getHireDate().getYear()));
    }
    public static List<Worker> betweenGivenAgeRange(List<Worker> workers){
        if(workers == null){
            return null;
        }
        return workers
                .stream()
                .filter(w -> w.isBetweenAge(30,39) && w.hasNameStartingWith("A"))
                .collect(Collectors.toList());
    }
    public static String longestName(List<Worker> workers){
        if(workers == null){
            return null;
        }
        return workers
                .stream()
                .map(Worker::getName)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

    }
    public static boolean salaryBetween(List<Worker> workers, BigDecimal salaryFrom, BigDecimal salaryTo ){
        if(workers == null){
            return false;
        }
        return workers.stream().allMatch( w -> w.getSalary().compareTo(salaryFrom) >= 0 && w.getSalary().compareTo(salaryTo)<=0);
    }

    public static void main(String[] args) {
        List<Worker> workers = Arrays.asList(
                new Worker("ADAM", 30, new BigDecimal("200"), LocalDate.of(2010, 12, 11)),
                new Worker("ZUZIA", 33, new BigDecimal("300"), LocalDate.of(2010, 11, 11)),
                new Worker("IWAN", 20, new BigDecimal("250"), LocalDate.of(2011, 10, 11)),
                new Worker("ANDRZEJ", 25, new BigDecimal("420"), LocalDate.of(2011, 4, 11)),
                new Worker("PAWEL", 27, new BigDecimal("280"), LocalDate.of(2013, 2, 11)),
                new Worker("PIOTR", 21, new BigDecimal("280"), LocalDate.of(2015, 7, 11)),
                new Worker("PAULINA", 35, new BigDecimal("310"), LocalDate.of(2015, 6, 11)),
                new Worker("ANGELA", 37, new BigDecimal("480"), LocalDate.of(2016, 1, 11))
        );


        // 1. zwrocic kolekcje ktora zawiera 3 najstarsze osoby
        System.out.println("------------------ 1 ---------------------");
        oldestPeople(workers).forEach(System.out::println);

        // 2. wykonaj zestawienie, w ktorym pokazesz rok w
        // ktorym zatrudnino pracownika oraz liste pracownikow
        // ktorych zatrudniono wlasnie w tym roku
        System.out.println("------------------ 2 ---------------------");
        groupedByHireYear(workers).forEach((k, v) -> System.out.println(k + "\n" + v));

        // 3. pokaz tylko tych pracownikow, ktorzy wiek z przedzialu <30, 40) i imie zaczynajace sie od "A"
        System.out.println("------------------ 3 ---------------------");
        betweenGivenAgeRange(workers).forEach(System.out::println);

        // 4. wypisz najdluzsze imie sposrod wszystkich imion pracownikow
        System.out.println("------------------ 4 ---------------------");
        System.out.println(longestName(workers));

        // 5. sprawdz czy wszyscy pracownicy maja pensje w podanym jako argument metody zakresie
        System.out.println("------------------ 5 ---------------------");
        System.out.println(salaryBetween(workers, new BigDecimal("0"), new BigDecimal("1000")));


        // TABLICA JAKO STRUMIENIE
        // int[] arr = {45, 23, 67, 11};
        // System.out.println(Arrays.stream(arr).average().orElse(0));
        // jak szybko z tablicy zrobic kolekcje Integer w tym przypadku
        // List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        BigDecimal price1 = new BigDecimal("10");
        BigDecimal price2 = new BigDecimal("10");

        // compareTo
        // < 0 kiedy BigDecimal po lewej jest mniejszy od BigDecimal po prawej
        // > 0 kiedy BigDecimal po lewej jest wiekszy od BigDecimal po prawej
        // = 0 kiedy BigDecimal po lewej jest taki sam jak BigDecimal po prawej
        System.out.println(price1.compareTo(price2));
    }
}
