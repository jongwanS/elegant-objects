package ch02.mock08;

public interface Exchange{
    double rate(String target);
    double rate(String source, String target);

    final class Fake implements Exchange{
        @Override
        public double rate(String target) {
            return 4L;
        }

        @Override
        public double rate(String source, String target) {
            return 3L;
        }
    }
}