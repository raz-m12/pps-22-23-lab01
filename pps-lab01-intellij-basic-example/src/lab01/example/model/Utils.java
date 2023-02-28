package lab01.example.model;

public class Utils {
    public static boolean isWithdrawAllowed(double currentBalance, final double withdrawAmount){
        return currentBalance >= withdrawAmount;
    }

    public static boolean checkUser(AccountHolder that, final int id) {
        return that.getId() == id;
    }
}
