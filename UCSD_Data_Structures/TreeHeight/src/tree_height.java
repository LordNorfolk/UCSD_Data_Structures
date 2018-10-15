import java.util.*;
import java.io.*;
import java.lang.Thread;


public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }


    public class TreeHeight {
        int n;
        int parent[];
        int cache[];
        int maxHeight;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            cache = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
                cache[i] = 0;
            }
        }

        int computePath(int child_value) {

            if (parent[child_value] == -1) {
                return 1;
            }

            if (cache[child_value] != 0) {
                return cache[child_value];
            }

            cache[child_value] = 1 + computePath(parent[child_value]);
            return cache[child_value];

        }


        int computeHeight() {
            // Replace this code with a faster implementation

            for (int p = 0; p < n; p++){
                maxHeight = Math.max(maxHeight, computePath(p));
            }

            return maxHeight;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
