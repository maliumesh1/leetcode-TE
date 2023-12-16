class Solution 
{
    public boolean isAnagram(String s, String t) 
  {
        if(s.length()!=t.length())
        {
            return false;
        }
    
        int map[]=new int[26];
        for(char x : s.toCharArray())
        {
            map[x-'a']++;
        }
    
        for(char x : t.toCharArray())
        {
            map[x-'a']--;
        }
    
        for(int i:map)
        {
            if (i!=0)
            {
                return false;
            }
        }
    
        return true;
   }
}
