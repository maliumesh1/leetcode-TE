class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t))
            return 0;
        char chS[] = s.toCharArray();
        char chT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for(; i < m; i++)
        {
            if(chS[i] == chT[j])
                j++;
            
            if(j == n)
                return 0;
        }
        return n - j;
        
    }
}