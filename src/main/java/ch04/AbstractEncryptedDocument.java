package ch04;

public class AbstractEncryptedDocument extends AbstractDocument{
    public AbstractEncryptedDocument(String content) {
        super(content);
    }

    @Override
    public byte[] content() {
        return new byte[0];
    }
}
