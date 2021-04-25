public class PlayerOutOfMapException extends Throwable{
    private final String errorMessage = "Pemain keluar dari map permainan";

    public void showErrorMessage(){
        System.out.println(errorMessage);
    }
}
