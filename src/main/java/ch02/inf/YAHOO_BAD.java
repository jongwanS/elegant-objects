package ch02.inf;

public class YAHOO_BAD implements ExchangeBad{
    @Override
    public float rate(String target) {
        return 1;
    }
    @Override
    public float rate(String source, String target) {
        if("EUR".equals(source) && "USD".equals(target))
            return 1.3F;
        return 1;
    }
}
