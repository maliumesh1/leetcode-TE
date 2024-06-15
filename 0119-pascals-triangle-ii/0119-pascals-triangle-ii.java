class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int i =rowIndex;
        long val = 1;

        for (int j = 0; j <= i; j++) 
        {
            result.add((int) val);
            val = val * (i - j) / (j + 1);
        }
        return result;
    } 
}