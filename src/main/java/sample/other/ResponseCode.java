package sample.other;

public enum ResponseCode {
    NO_ERRORS(-1),
    TWO_ERRORS(-2);

    public final int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
