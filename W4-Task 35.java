class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Number of tasks having maximum frequency
        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Minimum intervals based on most frequent tasks
        int answer = (maxFreq - 1) * (n + 1) + maxCount;

        // We cannot have fewer intervals than the number of tasks
        return Math.max(answer, tasks.length);
    }
}
