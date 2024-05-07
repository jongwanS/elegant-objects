package ch02.abstractandinterface;

public interface Vehicle {
    int start();
    int accelerate();
    //Java 8 부터 추가되었다
    default String commonVehicle(){
        return "공통이닷";
    }
}
