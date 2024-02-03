class Solution {
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> regionsArea = new HashMap<>();
        regionsArea.put(0,0);
        
        int n = grid.length;
        int region = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area = floodFill(grid, i, j, region);
                    regionsArea.put(region, area);
                    region++;
                }
            }
        }
        
        int max = regionsArea.getOrDefault(2,0);
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==0){
                    Set<Integer> neighbors = new HashSet<>();
                    neighbors.add(r>0?grid[r-1][c]:0);
                    neighbors.add(c>0?grid[r][c-1]:0);
                    neighbors.add(r<n-1?grid[r+1][c]:0);
                    neighbors.add(c<n-1?grid[r][c+1]:0);
                    int area = 1;
                    for(int neighbor: neighbors){
                        area+=regionsArea.get(neighbor);
                    }
                    if(area>max){
                        max = area;
                    }
                }
            }
        }
        
        return max;
    }
    
    public int floodFill(int[][] grid, int r, int c, int region) {
        int n = grid.length;
        if(r<0||r>=n||c<0||c>=n||grid[r][c]!=1){
            return 0;
        }
        
        grid[r][c] = region;
        
        int sum = 1;
        sum+=floodFill(grid, r, c+1, region);
        sum+=floodFill(grid, r+1, c, region);
        sum+=floodFill(grid, r, c-1, region);
        sum+=floodFill(grid, r-1, c, region);
        
        return sum;
    }
}