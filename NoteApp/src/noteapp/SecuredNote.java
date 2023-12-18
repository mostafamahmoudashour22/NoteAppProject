
package noteapp;

public class SecuredNote extends Note implements Lockable{
    private String password;
    private Image image;
    
    public SecuredNote(String path, String title, String content, Image image, String password) {
        setPath(path);
        setTitle(title);
        edit(content);
        this.image = image;
        this.password = password;
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
