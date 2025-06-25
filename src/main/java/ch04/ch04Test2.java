package ch04;

import java.io.File;
import java.io.IOException;

public class ch04Test2 {

    public static void main(String[] args) {
        length(new File("123"));
    }

    public static int length(File file) {
        if(!file.exists()){
            //호출부가 어떤 예외가 던져질지 예상할 수가 없다.
            throw new IllegalArgumentException("오류야");
        }
        return 1;
    }
}
