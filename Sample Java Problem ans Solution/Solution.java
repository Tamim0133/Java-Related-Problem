import java.util.Scanner;

public class Solution
 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // testcases

        while (t-- > 0) {
            int n = scanner.nextInt(); // no of bus
            int[][] arr = new int[n][100];
            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt(); // no of stoppage for each bus
                for (int j = 0; j < m; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            int p = scanner.nextInt();
            int x = scanner.nextInt();

            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int total_time = 0, time_passed_before_bus_came = 0;
                boolean bus_came = false;

                for (int j = 1;; j++) {
                    if (arr[i][j] == p) {
                        bus_came = true;
                    }
                    if (!bus_came) {
                        time_passed_before_bus_came += Math.abs(arr[i][j] - arr[i][j - 1]);
                    }

                    total_time += Math.abs(arr[i][j] - arr[i][j - 1]);

                    if (arr[i][j + 1] == 0) {
                        total_time += arr[i][j];
                        break;
                    }
                }

                if (bus_came && time_passed_before_bus_came >= x) {
                    total_time -= x;
                    ans = Math.min(ans, total_time);
                }
            }
            if (ans == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(ans);
        }
        scanner.close();
    }
}
