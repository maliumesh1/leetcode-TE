class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] numbers = countingSort(intervals); 
        Map<Integer, Integer> set = new HashMap<>();
        int index = 0;
        int tracker = 0; 
        
        for(int i = 0; i< numbers.length; i++){
            if(numbers[i][0] <= numbers[tracker][1]){
                if(numbers[i][1] > numbers[tracker][1]){
                    numbers[tracker][1] = numbers[i][1];
                }
                index = tracker;
            }else{
                index = i;
                tracker = i;
            }
            if(set.containsKey(numbers[index][0])){
                int max = set.get(numbers[index][0]) <= numbers[index][1] ? numbers[index][1] : set.get(numbers[index][0]);
                set.put(numbers[index][0], max);               
            }else{
                set.put(numbers[index][0], numbers[index][1]); 
            }
        }
        
        int[][] output = new int[set.size()][2];
        
        index = 0;
        
        for(int i = 0; i < numbers.length; i++){
            if(set.containsKey(numbers[i][0]) && set.get(numbers[i][0]) == numbers[i][1]){
                set.remove(numbers[i][0]);
                output[index][0] = numbers[i][0];
                output[index++][1] = numbers[i][1];
            }     
        }
        
        return output;
        
    }
    
    public int[][] countingSort(int[][] nums){
        int[][] output = new int[nums.length][2];
        int max = 0;        
        
        for(int[] array: nums){
            max = max > array[0] ? max : array[0];
        }
        
        int[] counts = new int[max + 1];
        for(int[] array: nums){
            ++counts[array[0]];
        }
        
        for(int i = 1; i < counts.length; i++){
            counts[i] += counts[i - 1];
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            output[--counts[nums[i][0]]][0] = nums[i][0];
            output[counts[nums[i][0]]][1] = nums[i][1];
        }
        
        return output;
    }
}