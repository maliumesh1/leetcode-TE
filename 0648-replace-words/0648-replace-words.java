class Trie{
    Trie[] children;
    boolean isWord;
    public Trie(){
        this.children=new Trie[26];
        this.isWord=false;
    }
    public void add(String word){
        Trie root=this;
        for(char c : word.toCharArray()){
            if(root.children[c-'a']==null){
                root.children[c-'a']=new Trie();
            }
            root=root.children[c-'a'];
        }
        root.isWord=true;
    }
    public String prefix(String word){
        Trie root=this;
        for(int i=0;i<word.length();i++){
        char  c=word.charAt(i);
            if(root.children[c-'a']==null){
                return word;
            }
            root=root.children[c-'a'];
            if(root.isWord)return word.substring(0,i+1);
        }
        return word;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root= new Trie();
        for(String w : dictionary)root.add(w);

        String arr[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
           String temp = arr[i];
           String pre = root.prefix(temp);
           sb.append(pre);
          if(i==arr.length-1)continue;
            sb.append(" ");
        }
        return sb.toString();
    }
}