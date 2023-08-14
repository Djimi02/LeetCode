public class MergeIntervals {
    private boolean mergeIntervals(int[][] intervals) {
        boolean changed = false;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] == null) {
                continue;
            }

            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j = 0; j < intervals.length; j++) {
                if (intervals[i] == null || i == j || intervals [j] == null) {
                    continue;
                }

                int startNext = intervals[j][0];
                int endNext = intervals[j][1];

                if ((startNext <= end && end <= endNext) || (startNext <= start && start <= endNext) || (start <= startNext && end >= endNext)) {
                    intervals[i][0] = Math.min(start, startNext);
                    start = intervals[i][0];

                    intervals[i][1] = Math.max(end, endNext);
                    end = intervals[i][1];

                    intervals[j] = null;

                    changed = true;
                }
            }
        }
        return changed;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        int counter = 0;
        
        while (mergeIntervals(intervals)) {
            
        }

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] == null) {
                counter++;
            }
        }

        int[][] output = new int[intervals.length - counter][2];
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] == null) {
                continue;
            }

            output[j] = intervals[i];
            j++;
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] array = new int[][] {{1, 4}, {4, 5}};
        int[][] result = new MergeIntervals().merge(array);

        for (int i = 0; i < result.length; i++) {
            System.out.println("Interval:" + result[i][0] + " - " + result[i][1]);
        }
    }
}
