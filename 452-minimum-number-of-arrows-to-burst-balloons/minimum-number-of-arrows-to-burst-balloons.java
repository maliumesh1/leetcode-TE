class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));  

        int ans=1,endPoint=points[0][1];

        for(int i=1;i<points.length;++i)
            if(endPoint < points[i][0])
            {
                ++ans;
                endPoint = points[i][1];
            }

        return ans;
    } 
}