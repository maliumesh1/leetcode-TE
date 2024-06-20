import java.util.Arrays;
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        // int high = position[position.length-1];
        int high = (position[position.length - 1] - position[0]) / (m - 1);
        while(low<=high){
            int mid = (low) + (high-low)/2;
            if(checkIfpossible(position,mid,m)){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return high;
    }
    public boolean checkIfpossible(int[] arr, int dis , int m){
        int last = arr[0];
        m--;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] - last >= dis){
                last = arr[i];
                m--;
            }
            
        }
        if(m<=0){
                return true;
        }

        return false;

    }
}