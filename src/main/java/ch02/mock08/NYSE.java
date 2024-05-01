package ch02.mock08;

public class NYSE implements Exchange {
    private final String secret;
    public NYSE(String secret) {
        this.secret=secret;
    }

    @Override
    public double rate(String target) {
        return 4L;
    }

    @Override
    public double rate(String source, String target) {
        //뉴욕거래소의 http 결과값을 가정한다.
        return 3L;
    }
}