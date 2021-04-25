public class OccupiedCellException extends Throwable {
    private final String errorMessage = "Cell ini sudah ditempati";
    public void showErrorMessage(){
        System.out.println(errorMessage);
    }
}
