
package noteapp;

import java.util.HashMap;

public class DB {
    private static HashMap<String, Account> accounts;

    public static void addAccount(String userName, Account account) {
        accounts.put(userName, account);
    }
    
    public static void deleteAccount(String userName) {
        accounts.remove(userName);
    }
    
    public static boolean checkInfo(String userName, String password) {
        if (accounts.containsKey(userName)) {
            Account account = accounts.get(userName);
            return account.getPassword().equals(password);
        }
        return false;
    }
}
