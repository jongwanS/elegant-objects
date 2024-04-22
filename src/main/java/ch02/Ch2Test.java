package ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Ch2Test {

    @Test
    @DisplayName("Cash constructor without Equals and Hashcode")
    public void cashConstructorWithout(){
        CashWithoutEqualsAndHashCode x = new CashWithoutEqualsAndHashCode(29,95,"USD");
        CashWithoutEqualsAndHashCode y = new CashWithoutEqualsAndHashCode(29,95,"USD");
        Assertions.assertNotEquals(x,y);
    }

    @Test
    @DisplayName("Cash constructor")
    public void cashConstructor(){
        Cash x = new Cash(29,95,"USD");
        Cash y = new Cash(29,95,"USD");
        Assertions.assertEquals(x.hashCode(),y.hashCode());
        Assertions.assertEquals(x,y);
    }

    @Test
    @DisplayName("Cash Interface")
    public void cashInterface(){
        Employee employee = new Employee(new DefaultCash());
        Assertions.assertEquals(Integer.MAX_VALUE,employee.toCents());

        Employee employeeUsd = new Employee(new UsdCash());
        Assertions.assertEquals(Integer.MIN_VALUE,employeeUsd.toCents());
    }

    @Test
    @DisplayName("withoutHashCode")
    public void withoutHashCode(){
        HashSet<Cash> set = new HashSet<>();

        Cash x = new Cash(29,95,"USD");
        Cash y = new Cash(29,95,"USD");

        set.add(x);
        set.add(y);

        Assertions.assertEquals(1,set.size());
        Assertions.assertNotEquals(2,set.size());
    }

    @Test
    @DisplayName("CashIdentityMutability")
    public void CashIdentityMutability(){
        Map<CashIdentityMutability, String> map = new HashMap<>();

        CashIdentityMutability five = new CashIdentityMutability(5);
        CashIdentityMutability ten = new CashIdentityMutability(10);

        map.put(five,"five");
        map.put(ten,"ten");
        //~~~ 장황한 소스 어딘가에서
        //map.put(five.mul(2),"five");

        Assertions.assertEquals(map.get(five), "five");
    }

    @Test
    @DisplayName("CashIdentityMutabilityChangeVariable")
    public void CashIdentityMutabilityChangeVariable(){
        Map<CashIdentityMutabilityChangeVariable, String> map = new HashMap<>();

        CashIdentityMutabilityChangeVariable five = new CashIdentityMutabilityChangeVariable(5);
        CashIdentityMutabilityChangeVariable ten = new CashIdentityMutabilityChangeVariable(10);

        map.put(five,"five");
        map.put(ten,"ten");
        //~~~ 장황한 소스 어딘가에서
        five.mul(2);

        Assertions.assertNotEquals(map.get(five), "five");
    }

    @Test
    @DisplayName("CashIdentityMutabilityWithoutEqualsAndHashcode")
    public void CashIdentityMutabilityWithoutEqualsAndHashcode(){
        Map<CashIdentityMutabilityWithoutEqualsAndHashcode, String> map = new HashMap<>();

        CashIdentityMutabilityWithoutEqualsAndHashcode five = new CashIdentityMutabilityWithoutEqualsAndHashcode(5);
        CashIdentityMutabilityWithoutEqualsAndHashcode ten = new CashIdentityMutabilityWithoutEqualsAndHashcode(10);

        map.put(five,"five");
        map.put(ten,"ten");
        five.mul(2);

        Assertions.assertEquals(map.get(five), "five");
        Assertions.assertEquals(map.get(ten), "ten");
    }

    @Test
    @DisplayName("CashIdentityMutabilityMap")
    public void CashIdentityMutabilityMap(){
        CashIdentityMutability five = new CashIdentityMutability(5);
        CashIdentityMutability ten = new CashIdentityMutability(10);
        Map<CashIdentityMutability, String> immutableMap = Map.of(five, "five", ten, "ten");
        Assertions.assertThrows(UnsupportedOperationException.class,()-> {
            immutableMap.put(new CashIdentityMutability(15),"fifteen");
        });
    }

    @Test
    @DisplayName("CashIdentityMutabilityArray")
    public void CashIdentityMutabilityArray(){
        CashIdentityMutability five = new CashIdentityMutability(5);
        CashIdentityMutability ten = new CashIdentityMutability(10);

        CashIdentityMutabilitys immutableArray = new CashIdentityMutabilitys(List.of(five,ten));
        Assertions.assertThrows(UnsupportedOperationException.class,()-> {
            immutableArray.getCashIdentityMutability().add(new CashIdentityMutability(15));
        });
    }

    @Test
    @DisplayName("CashFailureAtomicityChangeVariable")
    public void CashFailureAtomicityChangeVariable(){

        CashFailureAtomicityChangeVariable cash = new CashFailureAtomicityChangeVariable(10,50);
        Assertions.assertThrows(RuntimeException.class,()-> {
            cash.mul(2);
        });
        Assertions.assertEquals(20, cash.getDollars()); // 예상되는 dollars 값
        Assertions.assertNotEquals(100, cash.getCents());   // 예상되는 cents 값
    }

    @Test
    @DisplayName("CashFailureAtomicityImmutableVariable")
    public void CashFailureAtomicityImmutableVariable(){

        CashFailureAtomicityImmutableVariable cash = new CashFailureAtomicityImmutableVariable(10,50);
        Assertions.assertThrows(RuntimeException.class,()-> {
            cash.mul(2);
        });
        Assertions.assertEquals(10, cash.getDollars()); // 예상되는 dollars 값
        Assertions.assertEquals(50, cash.getCents());   // 예상되는 cents 값
    }

    public static void main(String[] args) {
        // HashMap 생성
        HashMap<Student, String> studentMap = new HashMap<>();

        Student student1 = new Student(1);
        Student student2 = new Student(2);

        // 두 학생이 같은 해시 코드를 가지도록 함
        System.out.println("HashCode of student1: " + student1.hashCode());
        System.out.println("HashCode of student2: " + student2.hashCode());

        studentMap.put(student1, "John");
        studentMap.put(student2, "Doe");

        // 해시 충돌 발생으로 두 학생이 같은 해시 버킷에 매핑되었을 것
        System.out.println("Student 1's name: " + studentMap.get(student1));
        System.out.println("Student 2's name: " + studentMap.get(student2));
    }

    static class Student {
        private int id;

        public Student(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            // 모든 학생의 hashCode를 1로 설정하여 충돌을 일으킴
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Student student = (Student) obj;
            return id == student.id;
        }
    }
}

