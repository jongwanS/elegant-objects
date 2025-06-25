package ch04;

class EncryptedDocument extends Document {
    public EncryptedDocument(String content) {
        super(content);
    }

    @Override
    public byte[] content(){
        //문서를 읽어, 복호화 하여 반환
        return new byte[0];
    }
}