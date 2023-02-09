public class SquareRootProblemBinarySearch {
    public static void main(String[] args) {
        System.out.println(getSquareRoot(49));
    }

    private static long getSquareRoot(long N) {
        if (N == 0) return 0;

        long start = 0;
        long end = (long)1e8;
        int answer = 0;

        while (start <= end) {
            long medium = start + (end - start)/2;
            if (medium * medium == N) {
                return medium;
            } else if (medium * medium < N) {
                answer = (int)medium;
                start = medium + 1;
            } else {
                end = medium - 1;
            }
        }
        return answer;
    }

}
