class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        int[] freq = new int[1001];
        for (int s : skill) {
            sum += s;
            freq[s]++;
        }
        int teams = skill.length / 2;
        if (sum % teams != 0)
            return -1;

        int target = sum / teams;
        long ans = 0;
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == 0)
                continue;
            if (freq[target - i] != freq[i])
                return -1;
            ans += (long) freq[i] * (i * (target - i));
        }
        return ans / 2;
    }

}