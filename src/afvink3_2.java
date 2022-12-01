import java.io.*;
import java.util.*;

public class afvink3_2 {
    private static BufferedReader inFile;
    private static ArrayList<String> geneArr;
    private static Map<String, ArrayList> map = new HashMap<>();
    public static void main(String[] args) {
        afvink3_2 chrList = new afvink3_2();
        nestedList();
    }

    /**
     * Open a file with info about homo_sapiens genes
     * Add genes of a chromosome in a list that is nested in a list of chromosomes
     */
    public static void nestedList() {
        try {
            String line;
            // to open a file
            inFile = new BufferedReader(new FileReader(
                    "C:\\Users\\daria\\OneDrive\\Bureaublad\\Homo_sapiens.txt"));
            // loop through the lines of a file
            while ((line=inFile.readLine())!=null){
                String chr = line.split("\t")[6];
                String gene = line.split("\t")[2];
                // check if the chromosome is already used
                if(map.containsKey(chr)){
                    // the value of a map (the array list of genes) will be grabbed and edited by adding a new gene
                    geneArr = map.get(chr);
                    geneArr.add(gene);
                } else {
                    // if the chromosome is not used yet a new gene list will be created
                    // and the new key+value will be added to a map
                    geneArr = new ArrayList<>();
                    geneArr.add(gene);
                    map.put(chr, geneArr);
                }
            }

//            System.out.println(map.get("12"));

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("File can not be read");
        } catch (Exception e) {
            System.out.println("Undefined error: "+e);
        }
    }
}
