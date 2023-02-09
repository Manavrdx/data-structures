import java.util.List;

public class PainterPartitionProblem {

    public static void main(String[] args) {
        System.out.println(findLargestMinDistanceUsingNormalApproach(List.of(2, 1, 5, 6, 2, 3), 4));
        System.out.println(findLargestMinDistanceUsingBinarySearchApproach(List.of(2, 1, 5, 6, 2, 3), 4));
    }

    private static int findLargestMinDistanceUsingNormalApproach(List<Integer> boards, int k) {
        int sum = 0;
        int max_value = 0;
        int n = boards.size();
        for (Integer board : boards) {
            sum = sum + board;
            max_value = Math.max(max_value, board);
        }

         for(int i = max_value; i <= sum; i++) {
             if(Painters(boards, i, n) <= k) return i;
         }

         return -1;
    }

    public static int findLargestMinDistanceUsingBinarySearchApproach(List<Integer> boards, int k) {
        int sum = 0;
        int max_value = 0;
        int answer = 0;
        int n = boards.size();
        for (Integer board : boards) {
            sum = sum + board;
            max_value = Math.max(max_value, board);
        }

        int start = max_value;
        int end = sum;

        while(start <= end) {
            int medium = start + (end - start)/2;
            int reqPainters = Painters(boards, medium, n);
            if(reqPainters <= k) {
                answer = medium;
                end = medium - 1;
            }
            else{
                start = medium + 1;
            }
        }
        return answer;
    }

    static int Painters(List<Integer> boards, int capacity, int n) {
        int painterNumber = 1;
        int remCapacity = capacity;

        for(int i = 0; i < n; i++) {
            if (boards.get(i) > remCapacity) {
                painterNumber++;
                remCapacity = capacity;
            }
            remCapacity = remCapacity - boards.get(i);
        }
        return painterNumber;
    }
}
