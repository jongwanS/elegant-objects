package ch02.inf;

class NYSE implements Exchange{
    @Override
    public float rate(String source, String target) {
        if("EUR".equals(source) && "USD".equals(target))
            return 1.3F;
        return 1;
    }
}
