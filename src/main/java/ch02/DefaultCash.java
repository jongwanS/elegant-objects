package ch02;

class DefaultCash implements Cash_INF{

    @Override
    public int cents() {
        return Integer.MAX_VALUE;
    }
}
