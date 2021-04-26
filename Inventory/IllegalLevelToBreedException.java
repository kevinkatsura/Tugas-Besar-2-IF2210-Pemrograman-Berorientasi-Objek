public class IllegalLevelToBreedException extends Throwable{
    private final String errorMessage = "Level kedua engimon ini belum mencukupi untuk dikawinkan";
    public void showErrorMessage(){
        System.out.println(errorMessage);
    }
}
