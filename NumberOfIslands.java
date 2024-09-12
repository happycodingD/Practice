package Amazon;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int numsIsland = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    numsIsland += countIsland(i, j, grid);
                }
            }
        }
        return numsIsland;
    }

    public static int countIsland(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        countIsland(i+1, j, grid);
        countIsland(i, j+1, grid);
        countIsland(i-1, j, grid);
        countIsland(i, j-1, grid);
        return 1;
    }

    public static void main(String args[]) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println((numIslands(grid)));
    }
}
