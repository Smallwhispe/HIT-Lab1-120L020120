package P1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {
    public static String fileindex = "./src/P1/txt/";
    public static boolean isLegalMagicSquare(String filename) throws IOException {
        File file = new File(filename);
        FileReader reader;
        reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        String line;

        int n = 0, m , i ;
        line = bReader.readLine();
        String[] l = line.split("\t");
        m = l.length;
        int[][] square = new int[m][m];
        boolean[] vis = new boolean[m*m+1];
        Arrays.fill(vis, false);
        try {
            for (i = 0; i < m; i++) {
                square[n][i] = Integer.parseInt(l[i].trim());
                if (square[n][i] <= 0)
                    return false;
            }
            n++;
            while ((line = bReader.readLine()) != null) {
                l = line.split("\t");
                for (i = 0; i < m; i++) {
                    square[n][i] = Integer.parseInt(l[i].trim());
                    if (square[n][i] <= 0 || vis[square[n][i]])
                        return false;
                    else
                        vis[square[n][i]] = true;
                }
                n++;
            }
        }catch (RuntimeException e){
            if (e instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("The row and col didn't match");
                return false;
            }
            else if (e instanceof NumberFormatException){
                System.out.println("Delimiters is false");
                return false;
            }
            else{
                return false;
            }
        }
        //ArrayIndexOutOfBoundsException false form
        bReader.close();
        if (n != m)
            return false;

        int sum1 = 0, sum2 = 0, s;
        for (i = 0; i < n; i++) {
            sum1 += square[i][i];
            sum2 += square[n - i - 1][i];
        }
        if (sum1 == sum2)
            s = sum1;
        else
            return false;
        for (i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += square[i][j];
                sum2 += square[j][i];
            }
            if (sum1 != s || sum2 != s)
                return false;
        }
        return true;
    }
    public static boolean generateMagicSquare(int n) throws IOException {

        int[][] square = new int[n][n];
        int row = 0, col = n / 2, i, j, a = n * n;

        for (i = 1; i <= a; i++) {
            square[row][col] = i;
            if (i % n == 0)
                row++;
            else {
                if (row == 0)
                    row = n - 1;
                else
                    row--;
                if (col == (n - 1))
                    col = 0;
                else
                    col++;
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(square[i][j] + "\t");
            System.out.println();
        }
        File file = new File(fileindex + "6.txt");
        file.createNewFile();
        FileWriter out = new FileWriter(file);
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                out.write(square[i][j]+"\t");
            }
            out.write("\r\n");
        }
        out.close();
        return true;
    }
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(isLegalMagicSquare(  fileindex + i + ".txt"));
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n<=0||n%2==0){
            if (n <= 0 )
            System.out.println("The number can't be negative");
            else if (n%2==0)
                System.out.println("The number can't be even");
            n = sc.nextInt();
        }
        generateMagicSquare(n);
        System.out.println(isLegalMagicSquare(fileindex + 6 + ".txt"));
    }
}


