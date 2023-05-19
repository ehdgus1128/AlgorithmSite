import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] isUsed;
    static int m;
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        isUsed = new boolean[n+1];

        nandm(0);
        bw.close();
    }

    private static void nandm(int k) throws IOException{
        if (k == m) {
            for (int i = 1; i < k+1; i++) {
            	System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n+1; i++) {
//        	System.out.println(i + " " + k + " ");
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[k+1] = i;
//                System.out.print(Arrays.toString(isUsed)+" ");
//                System.out.print(Arrays.toString(arr));
                nandm(k + 1);

                isUsed[i] = false;
            }
//            System.out.println();
        }
    }
}