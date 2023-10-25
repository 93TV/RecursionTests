import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVanStreams {

    public static void main(String[] args) {

        List<List<Integer>> data = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        int totalSum = data.stream()
                .flatMap(List::stream) // Stream van alle getallen
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Totaal: " + totalSum);



        data.stream().flatMap(List::stream).forEach(System.out::println);

        List<List<String>> tekstData = Arrays.asList(
                Arrays.asList("Java is cool", "Hello, world!"),
                Arrays.asList("Stream example", "Functional programming")
        );

        String trefwoord = "Java";

        List<String> overeenkomendeRegels = tekstData.stream()
                .flatMap(List::stream) // Stream van alle tekstregels
                .filter(regel -> regel.contains(trefwoord))
                .toList();

        System.out.println("Regels met trefwoord '" + trefwoord + "': " + overeenkomendeRegels);


    }






}
