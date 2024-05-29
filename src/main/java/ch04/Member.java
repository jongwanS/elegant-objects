package ch04;

import java.io.IOException;

public class Member {
    private String name;

    public Member(String name) throws Exception {

        if(1==1){
            chain1();
        }
        this.name = name;
    }

    private void chain1() throws Exception {

        try {
            chain2();
        }catch (Exception e){
            throw new Exception("chain1", e);
        }
    }

    private void chain2() throws Exception {
        try {
            throw new IOException("chain2 io exception");
        }catch (IOException e){
            throw new Exception("chain2",e);
        }
    }
}
