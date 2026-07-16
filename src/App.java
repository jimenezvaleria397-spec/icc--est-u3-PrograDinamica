public class App {
    public static void main(String[] args) throws Exception {
        //runFibonaci();
        //runFibonacciRecPd
        //runFibonaciIterativo();
        Maze maze = new Maze();
    }

    private static void runFibonaci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);


        System.out.println("Finbonaci  de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }
    private static void runFibonaciIterativo() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIter(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);
        System.out.println("===Fibonacci Iterativo =====");

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

    public static long fibonacci(int n , long [] memo){
        if(n <= 1) return n;
        long[] dp = new long [n +1];
        dp[0] = 0; dp[1] = 1;
        for(int i =2; i <= n; i++){
            dp[i] = dp[i -1] + dp[i -2];
        }
        return dp[n];
    }

    public static long getFibonacciPD(int n , long [] memo){
        if(n <= 1){
            return n;
        }
        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = getFibonacciPD(n-1, memo) + getFibonacciPD(n -2, memo); 
        return memo[n];
    }
    private static long getFibonacciIter(int num){ ///reducir de o(n) a o(1);
        if(num <= 1)
            return num;
        long anterior = 0;
        long actual = 1;
        //long[]memo = new long [num +1];
        //memo[0] = 0;
        //memo[1] = 1;
        for (int i = 2; i <= num ; i ++){
            long siguiente = actual + anterior;
            anterior = actual;
            actual = siguiente;
            //memo[i] = memo [ i -1] + memo[i - 2];
        }
        return actual;
    }
    

    }


