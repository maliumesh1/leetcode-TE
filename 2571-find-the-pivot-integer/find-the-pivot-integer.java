class Solution {
    public int pivotInteger(int n) {
        double ans=Math.sqrt((n*(n+1))/2);
//Now we gotta check if it is integer or not.
        double temp=ans;
        int temp2=(int)temp; // if value of ans('m') is 
//integer then temp = ans.
        if(ans==temp2){
            return temp2;
        }
        return -1;
    }
}