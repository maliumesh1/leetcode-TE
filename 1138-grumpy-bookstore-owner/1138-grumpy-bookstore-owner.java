class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int sum = 0;
    
    int n = customers.length;
    for(int i = 0; i < n; i++) {
        sum = sum + customers[i] * (1-grumpy[i]);
        grumpy[i] = customers[i] * grumpy[i];
    }
    
    int max = 0;
    for(int i = 0; i < minutes; i++) {
        max += grumpy[i];
    }
        
    int save = max;
    for(int i = minutes; i < n; i++) {
        save = save + grumpy[i] - grumpy[i-minutes];
        max = save > max ? save : max;
    }
    
    return sum + max;
 }
}