public class InvalidCommandException extends Throwable {
    private final String errorMessage = "Command yang anda masukkan salah";

    public void showErrorMessage() {
        System.out.println(errorMessage);
    }
}
