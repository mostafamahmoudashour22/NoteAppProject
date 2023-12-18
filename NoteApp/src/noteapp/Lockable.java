
package noteapp;

public interface Lockable {
    boolean checkPassword(String password);
    void changePassword(String newPassword);
}
