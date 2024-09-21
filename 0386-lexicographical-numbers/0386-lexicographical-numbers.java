class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        generate(res, 1, n);
        return res;
    }

    public void generate(List<Integer> res, int start, int n) {
        if (start > n) {
            return;
        }
        res.add(start);
        generate(res, start * 10, n);
        if (start % 10 < 9) {
            generate(res, start + 1, n);
        }
    }
}