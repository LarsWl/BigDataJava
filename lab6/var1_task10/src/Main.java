import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1); set1.add(2); set1.add(3);
        set2.add(1); set2.add(2); set2.add(4);

        System.out.printf("Set intersection: %s\n", set_intersection(set1, set2));
        System.out.printf("Set union: %s\n", set_union(set1, set2));
    }

    public static Set<Integer> set_intersection(Set<Integer> a, Set<Integer> b) {
        Set res = new HashSet();

        a.forEach(e -> {
            if (b.contains(e)) {
                res.add(e);
            }
        });

        b.forEach(e -> {
            if (a.contains(e)) {
                res.add(e);
            }
        });

        return res;
    }

    public static Set<Integer> set_union(Set<Integer> a, Set<Integer> b) {
        Set res = new HashSet();

        a.forEach(e ->res.add(e));
        b.forEach(e -> res.add(e));

        return res;
    }
}

