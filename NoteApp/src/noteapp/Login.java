
package noteapp;

public class Login implements Lockable{
    private String name;
    private String password;
    
    public Login(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public boolean checkInfo(){
        return DB.checkInfo(name, password);
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
