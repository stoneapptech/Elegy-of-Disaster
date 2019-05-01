package exceptions;

public class ChooseZeroException extends Exception {
    public ChooseZeroException() {
        super("User has chosen 0");
    }
}
