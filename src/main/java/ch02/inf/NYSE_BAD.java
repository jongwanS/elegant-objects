package ch02.inf;

public class NYSE_BAD implements ExchangeBad{
    @Override
    public float rate(String target) {
        return 1;
    }
    @Override
    public float rate(String source, String target) {
        if("EUR".equals(source) && "USD".equals(target))
            throw new RuntimeException();
        return 1;
    }
}
