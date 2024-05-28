package ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ch04Test1 {
    public static <T> int size(Iterable<T> items) {
        if (items instanceof Collection) {
            return Collection.class.cast(items).size();
        }
        int size = 0;
        for (T item : items) {
            ++size;
        }
        return size;
    }


    public static void main(String[] args) {
        int test = size(Arrays.asList("1"));
        System.out.println(test);
        ArrayList<String> a = new ArrayList<>();
    }
}
