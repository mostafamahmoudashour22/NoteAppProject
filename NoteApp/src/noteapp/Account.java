
package noteapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Account {
    private String accountName;
    public String userName;
    private Image imageProfile;
    public String password;
    public String questionCheck;
    public String answerCheck;
    private HashMap<String, Note> notes;
    private HashMap<String, SecuredNote> securedNotes;
    
    public void setAccountName(String accName){
        this.accountName = accName;
    }
    
    public void changeImageProfile(Image newImageProfile){
        this.imageProfile = newImageProfile;
    }
    
    public String getUserName(){
        return userName;
    }
    
    
    public String getPassword(){
        return password;
    }
    
    public void addNote(String noteTitle, Note note){
        notes.put(noteTitle, note);
    }
    
    public void deleteNote(String noteTitle){
        notes.remove(noteTitle);
    }
    
    public void addSecuredNote(String noteTitle, SecuredNote securedNote){
        securedNotes.put(noteTitle, securedNote);
    }
    
    public void deleteSecuredNote(String noteTitle){
        securedNotes.remove(noteTitle);
    }
    
    
     public void setQuestionCheck(String question, String answer) {
        this.questionCheck = question;
        this.answerCheck = answer;
    }


    public void showInfos() {
        System.out.println("Account Information:");
        System.out.println("Account Name: " + accountName);
        System.out.println("Username: " + userName);
        System.out.println("Image Profile Path: " + (imageProfile != null ? imageProfile.getPath() : "N/A"));
        System.out.println("Question Check: " + questionCheck);
        System.out.println("Answer Check: " + answerCheck);
    }

    // Method to change the password with  question check
    public void changePassword(String newPassword) {
        Scanner scanner = new Scanner(System.in);

        // Check if the question is set
        if (questionCheck == null || answerCheck == null) {
            System.out.println("Error: Security question and answer are not set.");
            return;
        }

        // Ask the question
        System.out.println("Security Question: " + questionCheck);
        System.out.print("Your Answer: ");
        String userAnswer = scanner.nextLine();

        // Check if the user's answer matches the stored answer
        if (userAnswer.equals(answerCheck)) {
            this.password = newPassword;
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Error: Incorrect answer to the security question. Password not changed.");
        }
    }
}
