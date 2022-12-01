import java.util.ArrayList;
import java.util.Random;

public class afvink1 {
    // arrayList met willekeurige ints
    private static ArrayList<Integer> al = new ArrayList<>();
    // Grootte van de array met willekeurige getallen
    private static int n = ((int) Math.pow(50,3));
    // Random object om willekeurige ints te genereren
    private static Random r = new Random();

    public static void createLargeArray() {
        for (int i = 0; i < n; i++) {
            al.add(r.nextInt(n));
        }
    }
    public void heapSort()
    {
        int temp;

        for (int i = (al.size() / 2 - 1); i >= 0; i--)                //build the heap
        {
            heapify(al, al.size(), i);
        }

        for (int i = (al.size() - 1); i > 0; i--)//extract elements from the heap
        {
            temp = al.get(0);//move current root to end (since it is the largest)
            al.set(0, al.get(i));
            al.set(i, temp);
            heapify(al, i, 0);//recall heapify to rebuild heap for the remaining elements
        }
    }

    void heapify(ArrayList<Integer> al, int n, int i)
    {
        int MAX = i; // Initialize largest as root
        int left = 2 * i + 1; //index of the left child of ith node = 2*i + 1
        int right = 2 * i + 2; //index of the right child of ith node  = 2*i + 2
        int temp;

        if (left < n && al.get(left) > al.get(MAX))//check if the left child of the root is larger than the root
        {
            MAX = left;
        }

        if (right < n && al.get(right) > al.get(MAX))//check if the right child of the root is larger than the root
        {
            MAX = right;
        }

        if (MAX != i)
        {//repeat the procedure for finding the largest element in the heap
            temp = al.get(i);
            al.set(i, al.get(MAX));
            al.set(MAX, temp);
            heapify(al, n, MAX);
        }
    }

    void display()                 //display the array
    {
        for (int i=0; i<al.size(); ++i) {
            System.out.print(al.get(i)+" ");
        }
    }

    public static void main(String args[])
    {
        afvink1 ob = new afvink1();

        long startTime, endTime;

//        int willekeurigGetal = r.nextInt(n); // willekeurig getal
//        // init van een array met willekeurige getallen

        System.out.println("Init van een array met "+n+" willekeurige ints");
        createLargeArray();

        System.out.println("Sorteren van de array");
        startTime = System.nanoTime();
        ob.heapSort();
        endTime = System.nanoTime();

//        ob.display();

        long tijdSorteren = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Tijd in microseconden: "+(tijdSorteren / 1000)) ;
    }
}
//
//import java.util.ArrayList;
//import java.util.Random;
//
//public class afvink1 {
//    // arrayList met willekeurige ints
//    private static ArrayList<Integer> al = new ArrayList<>();
//    // Grootte van de array met willekeurige getallen
//    private static int n = ((int) Math.pow(10,7));
//    // Random object om willekeurige ints te genereren
//    private static Random r = new Random();
//
//    public static void createLargeArray() {
//        for (int i = 0; i < n; i++) {
//            al.add(r.nextInt(n));
//        }
//    }
//
//    /**
//     * LineairZoeken lineair door een ArrayList zoeken naar een int
//     * @param getal de int die je zoekt in de ArrayList
//     * @return de positie (int) waarop het getal is gevonden
//     */
//    public static int lineairZoeken(int getal) {
//        int index = 0;
//        while (index < n) {
//            if (al.get(index)==getal)
//                return index;
//            else
//                index++;
//        }
//        return -1;
//    }  // lineairzoeken
//
//    /**
//     * binairZoeken vereist dat de ArrayList gesorteerd is
//     * @param grootte de grootte van de ArrayList
//     * @param getal de int die je zoekt in de ArrayList
//     * @return de positie (int) waarop het getal is gevonden
//     */
//    public static int binairZoeken(int grootte, int getal) {
//        int links = 0, rechts = grootte , midden = 0;
//        while (links <= rechts) {
//            midden = (links + rechts) / 2;
//            if (al.get(midden)==getal)
//                return midden;
//            else if (getal > al.get(midden))
//                links = midden + 1;
//            else
//                rechts = midden - 1;
//        }
//        return -1;
//    }  // binairzoeken
//
//    public static void main(String[] args) {
//        long startTime, endTime;
//        int willekeurigGetal = r.nextInt(n); // willekeurig getal
//        // init van een array met willekeurige getallen
//        System.out.println("Init van een array met "+n+" willekeurige ints");
//        createLargeArray();
//
//        System.out.println("Sorteren van de array");
//        //Sorteren om een binary search mogelijk te maken
//        al.sort(null);
//
//        System.out.println("Lineair zoeken naar "+willekeurigGetal);
//        // linear search
//        startTime = System.nanoTime();
//        lineairZoeken(willekeurigGetal);
//        endTime = System.nanoTime();
//        long tijdLineairZoeken = (endTime - startTime);  //divide by 1000000 to get milliseconds.
//        System.out.println("Tijd in microseconden: "+(tijdLineairZoeken / 1000)) ;
//
//        System.out.println("Binair zoeken naar "+willekeurigGetal);
//        // binary search
//        startTime = System.nanoTime();
//        binairZoeken(n, willekeurigGetal);
//        endTime = System.nanoTime();
//        long tijdBinairZoeken = (endTime - startTime);  //divide by 1000000 to get milliseconds.
//        System.out.println("Tijd in microseconden: "+(tijdBinairZoeken / 1000));
//        System.out.println("Binair zoeken is "+(tijdLineairZoeken/tijdBinairZoeken)+" keer sneller");
//    }
//}