class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks){
            map[c-'A']++;
        }

        Arrays.sort(map);
        int maxVal = map[25] - 1;
        int idleSlots = maxVal * n;

        for(int i=24; i>=0; i--){
            idleSlots -= Math.min(map[i], maxVal);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}