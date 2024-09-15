import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = (int) (1e9 + 7);
    private static FastReader in;
    private static FastWriter out;

    public static void main(String[] args) {
        try {
            in = new FastReader();
            out = new FastWriter();
            int TC = in.nextInt();
            while (TC-- > 0) {
                solve();

            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() throws IOException {
        // do it here bro ()
        // and remember "It's over 9,000!"
        int n = ni();
        long [] arr = na(n);
        printArray(arr);
    }

    // Sorting methods
    public static void sortDesc(long[] arr) {
        Arrays.sort(arr);
        reverseArray(arr);
    }

    public static void sortAsc(long[] arr) {
        Arrays.sort(arr);
    }

    // Binary search methods
    private static int upperBound(long[] arr, long value) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= value) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private static int lowerBound(long[] arr, long value) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < value) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private static int binarySearch(long[] arr, long value) {
        return Arrays.binarySearch(arr, value);
    }

    // Math utility methods
    public static long abs(long value) {
        return Math.abs(value);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static long max(long a, long b) {
        return Math.max(a, b);
    }

    public static long min(long a, long b) {
        return Math.min(a, b);
    }

    public static boolean equal(long a, long b) {
        return a == b;
    }

    // Array utility methods
    public static void reverseArray(long[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            long temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void printArray(long[] arr) throws IOException {
        for (long num : arr) {
            out.print(num + " ");
        }
        out.println("");
    }

    // String utility methods
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String convertBase(long number, int base) {
        return Long.toString(number, base);
    }

    // Utils: Sieve of Eratosthenes
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // Fast I/O classes
    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append(object.toString());
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    // Input macros
    private static int ni() { return in.nextInt(); }
    private static long nl() { return in.nextLong(); }
    private static double nd() { return in.nextDouble(); }
    private static String ns() { return in.next(); }
    private static String nln() { return in.nextLine(); }

    // input for arrays
    private static long[] na(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nl();
        return a;
    }

    // Output macros
    private static void print(Object... objects) throws IOException {
        for (Object obj : objects) {
            out.print(obj + " ");
        }
    }

    private static void println(Object... objects) throws IOException {
        print(objects);
        out.println("");
    }
}