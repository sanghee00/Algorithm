

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];

            if (n < 4) {
                int[] dp1 = new int[4];
                dp1[0] = 0;
                dp1[1] = 1;
                dp1[2] = 2;
                dp1[3] = 4;
                System.out.println(dp1[n]);
            } else {
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                for (int j = 4; j <= n; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }
                System.out.println(dp[n]);

            }


        }
    }
}

