import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {


    public static void main(String[] args) {
        List<Persoon> personen = new ArrayList<>();
        personen.add(new Persoon("Thibault", 29, Geslacht.MAN));
        personen.add(new Persoon("Joni", 32, Geslacht.MAN));
        personen.add(new Persoon("Frederik", 26, Geslacht.MAN));
        personen.add(new Persoon("Wassim", 22, Geslacht.NONBINAIR));
        personen.add(new Persoon("Thibe", 19, Geslacht.MAN));
        personen.add(new Persoon("Lotte", 27, Geslacht.VROUW));
        personen.add(new Persoon("Ibi", 29, Geslacht.VROUW));
        personen.add(new Persoon("Antje", 25, Geslacht.VROUW));

        List<Integer> getallen = Arrays.asList(1, 2, 3, 4, 5);

        int factorial = getallen.stream().reduce(1, (a, b) -> a * b);
        System.out.println(factorial);

        getallen.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

        getallen.stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);


        List<Integer> kwadraten = getallen.stream()
                .map(x -> x * x).toList();

        kwadraten.forEach(System.out::println);


        List<Persoon> personenStream1 = personen.stream()
                .filter(persoon -> persoon.getGeslacht() == Geslacht.MAN)
                .sorted(Comparator.comparing(Persoon::getLeeftijd))
                .toList();

        personenStream1.forEach(System.out::println);

        Boolean areAllNonBinary = personen.stream()
                .allMatch(persoon -> persoon.getGeslacht() == Geslacht.NONBINAIR);

        System.out.println(areAllNonBinary);

        Map<Geslacht, List<Persoon>> personenMap = personen.stream()
                .collect(Collectors.groupingBy(Persoon::getGeslacht));

        personenMap.forEach((geslacht, personen1) -> {
            System.out.println(geslacht);
            personen1.forEach(System.out::println);
        });

        boolean allMen = personen.stream()
                .allMatch(persoon -> persoon.getGeslacht() == Geslacht.MAN);
        System.out.println(allMen);

        boolean anyMen = personen.stream()
                .anyMatch(persoon -> persoon.getGeslacht() == Geslacht.MAN);
        System.out.println(anyMen);

        boolean noneBinary = personen.stream()
                .noneMatch(persoon -> persoon.getGeslacht() == Geslacht.NONBINAIR);
        System.out.println(noneBinary);

        List<Persoon> allNonBinary = personen.stream()
                .map(persoon -> persoon =
                        new Persoon(persoon.getNaam(), persoon.getLeeftijd(), Geslacht.NONBINAIR)).toList();

        allNonBinary.forEach(System.out::println);

        int aantalVrouwen = (int) personen.stream()
                .filter(persoon -> persoon.getGeslacht() == Geslacht.VROUW)
                .count();
        System.out.println(aantalVrouwen);


        IntStream.iterate(0, i -> i + 1).forEach(System.out::println);

    }


}

