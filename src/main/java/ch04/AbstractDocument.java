package ch04;

public abstract class AbstractDocument {
    private String content;

    public AbstractDocument(String content) {
        this.content = content;
    }

    // abstract 메서드는 하위 클래스에서 반드시 구현해야 합니다.
    public abstract byte[] content();

    public int length() {
        return this.content.length();
    }
}
