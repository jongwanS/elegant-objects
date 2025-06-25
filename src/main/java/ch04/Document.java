package ch04;

class Document {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public int length(){
        return this.content.length();
    }
    public byte[] content() {
        //문서를 읽어 바이트 배열로 로드한다.
        return new byte[3];
    }
}
