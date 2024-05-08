package ch03.declarativeVSimperative;

public class BetweenStatic {
    public static int between(int l, int r, int x) {
        return Math.min(Math.max(l, x), r);
    }

    public static int between(IntegerWithMy0wnAlgorithmStatic in) {
        return Math.min(Math.max(in.getA(), in.getB()), in.getC());
    }
}
