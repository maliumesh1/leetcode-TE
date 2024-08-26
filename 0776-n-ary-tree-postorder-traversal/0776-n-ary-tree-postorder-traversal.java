
class Solution {
    List<Integer> li = new ArrayList<>();

    void trav(Node n) {
        for (int i = 0; i < n.children.size(); i++)
            trav(n.children.get(i));
        li.add(n.val);
    }

    public List<Integer> postorder(Node root) {
                                                                                                        if(root==null)return li;
                                                                                                                trav(root);
                                                                                                                        return li;
                                                                                                                            }
}
