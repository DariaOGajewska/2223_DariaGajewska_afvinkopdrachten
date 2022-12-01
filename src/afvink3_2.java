import javax.swing.*;
import java.io.*;

public class afvink3_2 {
    private static String fileName;
    private static BufferedReader inFile;

    public static void main(String[] args) {
        afvink3_2 af = new afvink3_2();
        openFile();
    }
    public static void openFile() {
        // to open a file
        try {
            String line;
            inFile = new BufferedReader(new FileReader("C:\\Users\\daria\\OneDrive\\Bureaublad\\Homo_sapiens.txt"));
            while ((line=inFile.readLine())!=null){
                System.out.println(line+"\n");
            }
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("File can not be read");
        } catch (Exception e) {
            System.out.println("Undefined error");
        }
    }
}
