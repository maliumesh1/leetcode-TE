class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while ((i <= arr.length - 1) && !((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')
                    || (arr[i] >= '0' && arr[i] <= '9')))
                i++;
            while ((j >= 0) && !((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z')
                    || (arr[j] >= '0' && arr[j] <= '9')))
                j--;
            if (i >= j)
                break;
            if (arr[i] >= 'A' && arr[i] <= 'Z')
                arr[i] += 'a' - 'A';
            if (arr[j] >= 'A' && arr[j] <= 'Z')
                arr[j] += 'a' - 'A';
            if (arr[i++] != arr[j--])
                return false;
        }
        return true;
    }

}