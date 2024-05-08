package ch03.declarativeVSimperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterEven {

    private List<Integer> numbers;
    private List<Integer> evenNumbers;

    public FilterEven(List<Integer> numbers) {
        this.numbers = numbers;
        this.evenNumbers = new ArrayList<>();
    }

    // 짝수를 필터링하는 Predicate
    private Predicate<Integer> isEven = num -> num % 2 == 0;

    // 짝수 필터링 메서드
    public List<Integer> filterEvenNumbers() {
        for (Integer number : numbers) {
            if (isEven.test(number)) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }
}
