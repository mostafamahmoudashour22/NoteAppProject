
package noteapp;

public class Signup {
    private DB database;
    
    public Signup(DB database){
        this.database = database;
    }
    
    public void addUser(String userName, String password, String accountName) {
        // Check if the username is already taken
        if (database.checkInfo(userName, password)) {
            System.out.println("Error: Username already exists. Please choose a different username.");
            return;
        }

        // Add the new user to the database
        Account newAccount = new Account();
        newAccount.userName = userName;
        newAccount.password = password;
        newAccount.setAccountName(accountName);

        // Add the account to the database
        database.addAccount(userName, newAccount);

        System.out.println("User added successfully.");
    }
    
    public boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
