package ch04;

public class FinalDocument {
    private String content;

    public FinalDocument(String content) {
        this.content = content;
    }

    // final 메서드는 오버라이딩될 수 없습니다.
    public final int length() {
        return this.content.length();
    }

    // final 메서드는 오버라이딩될 수 없습니다.
    public final byte[] content() {
        return content.getBytes();
    }
}
