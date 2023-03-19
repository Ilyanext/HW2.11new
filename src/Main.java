import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> sorted = stream.sorted(order).collect(Collectors.toList());
        if (sorted.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(sorted.get(0), sorted.get(sorted.size() - 1));
        }

    }

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(133, 34, 63, 4, 55, 10);
        findMinMax(stream, (t, u) -> t.compareTo(u), (t, u) -> System.out.println("min= " + t + " max= " + u));
        stream.close();
        System.out.println();

        Stream<Integer> stream2 = Stream.of(44, 65, 1, 98, 63,1,12,11,1234,45,66,77,86);
        List<Integer> chet= stream2
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(chet);

    }
}