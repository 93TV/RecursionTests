import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {


    public static void main(String[] args) {


        Predicate<String> checkLength = str -> str.length() > 5;
        System.out.println((checkLength.test("thibault")));
        System.out.println((checkLength.test("abc")));


        Persoon persoon = new Persoon();
        Consumer<Persoon> setName = p -> p.setNaam("Freddy");
        setName.accept(persoon);
        System.out.println(persoon.getNaam());

        Function<Integer, String> getInt = i -> i * 10 + " = " + i +" multiplied by 10";
        System.out.println(getInt.apply(5));

        Supplier<Double> getRandomDouble = () -> Math.random();
        System.out.println(getRandomDouble.get());
    }


}