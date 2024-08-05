class Solution {
    public String kthDistinct(String[] arr, int k) {
        String[] res = new String[arr.length];
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        for (String s : arr) {
            if (hm.get(s) == 1)
                k--;
            if (k == 0)
                return s;
        }
        return "";

    }

}