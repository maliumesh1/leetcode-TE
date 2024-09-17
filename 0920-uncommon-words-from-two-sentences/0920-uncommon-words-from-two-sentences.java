class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] l1 = s1.split(" ");
        String[] l2 = s2.split(" ");
        Set<String> set = new HashSet<>();
        Set<String> setToRemove = new HashSet<>();
        for (String l : l1)
            if (set.contains(l))
                setToRemove.add(l);
            else
                set.add(l);
        for (String l : l2)
            if (set.contains(l))
                setToRemove.add(l);
            else
                set.add(l);
        set.removeAll(setToRemove);
        return set.toArray(new String[set.size()]);

    }

}