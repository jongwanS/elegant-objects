package ch02.inf;

interface Exchange {
    float rate(String source, String target);

    final class Smart {
        private final Exchange origin;
        public Smart(Exchange origin) {
            this.origin = origin;
        }
        public float toUsd(String source) {
            return this.origin.rate(source, "USD");
        }
        public float eurToUsd() {
            if(this.origin instanceof NYSE){
                throw new RuntimeException();
            }
            return this.toUsd("EUR");
        }
    }

    final class Fast implements Exchange {
        private final Exchange originFast;

        public Fast(Exchange originFast) {
            this.originFast = originFast;
        }

        @Override
        public float rate(String source, String target) {
            final float rate;
            if (source.equals(target)) {
                rate = 1.0f;
            } else {
                rate = this.originFast.rate(source, target);
            }
            return rate;
        }
        public float toUsd(String source) {
            return this.originFast.rate(source, "USD");
        }
    }
}
