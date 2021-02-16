import java.util.Random;

public class Optional {
    public static Integer[] viz = new Integer[100];
    //Parcurgem nodurile cu ajutorul matricei, și marcam ca nod vizitat, nodurile care 1 in matricea de adiacenta
    public static void parcurgere(Integer[][] mat, int nr_nodes, int node) {
        viz[node] = 1;
        for (int j = 0; j < nr_nodes; j++) {
            if (mat[node][j] == 1 && viz[j] == 0)
                parcurgere(mat, nr_nodes, j);
        }
    }

    public static boolean verifConex(int m) {
        for (int i = 0; i < m; i++)
            if (viz[i] == 0)
                return false;
        return true;
    }

    public static void afisCompCon(int m) {
        for (int i = 0; i < m; i++)
            if (viz[i] == 1) {
                System.out.print(i + " ");
                viz[i] = 2;
            }
        System.out.println();
    }
    public static void main(String[] args) {
        //Optional
        int m = Integer.parseInt(args[0]);
        if (m % 2 == 0) {
            System.err.println("Introduceti un numar impar!");
        } else {
            Integer[][] myArray = new Integer[m][m];

            Random rand = new Random();
            int rand1 = rand.nextInt(2);
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++) {
                    myArray[i][j] = 0;
                }
            for (int i = 0; i < m - 1; i++)
                for (int j = 1; j < m; j++) {
                    if (i < j) {
                        myArray[i][j] = rand1;
                        myArray[j][i] = rand1;
                        rand1 = rand.nextInt(2);
                    }
                }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (myArray[i][j] == 0) {
                        System.out.print("\u25B2");
                    } else
                        System.out.print("\u25B3");
                }
                System.out.println();
            }
            for (int i = 0; i < m; i++)
                viz[i] = 0;
            parcurgere(myArray, m, 0);
            if (verifConex(m)) {
                System.out.println("Graf conex!");
            } else {
                System.out.println("Graf neconex!");
                System.out.println("Comp conex:\n");
                while (!verifConex(m)) {
                    afisCompCon(m);
                    for (int k = 0; k < m; k++)
                        if (viz[k] == 0) {
                            parcurgere(myArray, m, k);
                            break;
                        }
                }
                afisCompCon(m);

            }
        }
    }

}

