
public class Knapsack {
	// This function returns a max of two integers based on the possible picks by the thief.
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
 
       /** This function evaluates and returns the maximum value (W)
     *  that can be put in the knapsack**/
    static void printknapSack(int W, int wt[],
                             int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
 
       // Construct a table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] +
                              K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
 
        // Keeps the value results of the knapsack.
        int result = K[n][W];
        System.out.println("Total value: " +result);
 
        w = W;
        for (i = n; i > 0 && result > 0; i--) {
 
            /** Determine whether the result comes from the top evaluation,
             (K[i-1][w]) or from (val[i-1] + K[i-1]
             [w-wt[i-1]]) creating the knapsack table. 
             coming from the table means
             the item is included, and should not be repeated.**/
            if (result == K[i - 1][w])
                continue;
            else {
 
                // The item here is already included.
                System.out.print(wt[i - 1] + " ");
 
                //Deduct the value of the weight that's already included.
                result = result - val[i - 1];
                w = w - wt[i - 1];
            }
        }
    }
 
   // Algorithm portion that runs the program to test above function
    public static void main(String arg[])
    {
        int val[] = { 10, 5, 30, 8, 12, 30, 50, 10, 2, 10, 40, 80, 100, 25, 10, 5};
        int wt[] = { 1, 4, 6, 2, 5, 10, 8, 3, 9, 1, 4, 2, 5, 8, 9, 1 };
        int W = 20;
        int n = val.length;
        
        printknapSack (W, wt, val, n);
        System.out.println(",are the Knapsack items picked\nfor total weight of "+ W);
    }
}