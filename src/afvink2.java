import java.util.Random;

public class afvink2{
    // grotte van de board
    private static int n = 25;
    // aantal generaties
    private static int g = 100;
    // declaratie en initialisatie van een array
    private static int[][] arr_game = new int[n][n];
    private static int[][] future;
    private static Random r = new Random();

    public static void main(String[] args) {
        randomList();
        originalGeneration(arr_game, n);
    }

    public static void randomList(){
        for (int y=0;y<n;y++) {
            for (int x=0;x<n;x++) {
                arr_game[x][y] = r.nextInt(2);
            }
        }
    }

    static void originalGeneration(int arr_game[][], int n){
        System.out.println("Original generation(1)");
        for (int y=0;y<n;y++) {
            for (int x=0;x<n;x++) {
                if(arr_game[y][x]==0)
                    System.out.print("  ");
                else
                    System.out.print("o ");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(arr_game, n, g);
    }

    static void nextGeneration(int arr_game[][], int n, int g){
        int p=2;
        while(p<=g)
        {
            future = new int[n][n];
            for(int l=0;l<n;l++){
                for(int m=0;m<n;m++){
                    int aliveNeighbours = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if ((l+i>=0&&l+i<n) && (m+j>=0&&m+j<n)) {
                                aliveNeighbours+=arr_game[l + i][m + j];
                            }
                        }
                    }
                    aliveNeighbours-=arr_game[l][m];
                    if ((arr_game[l][m]==1)&&(aliveNeighbours<2)){
                        future[l][m]=0;
                    }
                    else if ((arr_game[l][m]==1)&&(aliveNeighbours>3)){
                        future[l][m]=0;
                    }
                    else if ((arr_game[l][m]==0)&&(aliveNeighbours==3)){
                        future[l][m]=1;
                    }
                    else{
                        future[l][m]=arr_game[l][m];
                    }
                }
            }
            try {
            Thread.sleep(800);
            } catch (InterruptedException e) {
            throw new RuntimeException(e);
            }
            System.out.println("\n\nNext Generation"+"("+p+")");
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(future[i][j]==0)
                        System.out.print("  ");
                    else
                        System.out.print("o ");
                }
                System.out.println();
            }
            p++;
            arr_game=future;
        }
    }
}

