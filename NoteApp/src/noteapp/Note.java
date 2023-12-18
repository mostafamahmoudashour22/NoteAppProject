
package noteapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Note implements Sketchable{
    private String path;
    private String title;
    private String content;
    private Image images;
    
    // GUI Components For Sketching
    private JFrame sketchFrame;
    private SketchPanel sketchPanel;
    private int lastX, lastY;
    
    
    public void setPath(String path){
        this.path = path;
    }
    
    public String getPath(){
        return path;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void edit(String newContent){
        this.content = newContent;
    }
    
    public void save(){
        try(PrintWriter writer = new PrintWriter(new FileWriter(path))){
            writer.println("Title: " + title);
            writer.println("Content: " + content);
            writer.println("Image Path: " + (images != null ? images.getPath() : "N/A"));
            
            System.out.println("Note saved Successfully.");
        }catch(IOException e){
            System.out.println("Error saving note: " + e.getMessage());
        }
    }
    
    public void load(){
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            title = extractValue(reader.readLine());
            content = extractValue(reader.readLine());
            String imagePath = extractValue(reader.readLine());

            if (!imagePath.equals("N/A")) {
                images = new Image();
                images.setPath(imagePath);
                // Load other image details as needed
            }

            System.out.println("Note loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading note: " + e.getMessage());
        }
    }
    
    private String extractValue(String line) {
        return line.split(": ")[1];
    }
    
    public void sketch() {
        setupSketchingFrame();
    }
    
    private void setupSketchingFrame() {
        sketchFrame = new JFrame("Freehand Sketch");
        sketchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        sketchPanel = new SketchPanel();
        sketchFrame.add(sketchPanel);

        sketchFrame.setSize(400, 400);
        sketchFrame.setLocationRelativeTo(null);
        sketchFrame.setVisible(true);
    }
    
    private class SketchPanel extends JPanel {
        public SketchPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    lastX = e.getX();
                    lastY = e.getY();
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    Graphics g = getGraphics();
                    g.drawLine(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
            });
        }
    }
}
