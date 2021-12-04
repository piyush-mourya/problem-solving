// https://leetcode.com/problems/reshape-the-matrix/

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if( m*n != r*c ){
            return mat;
        }
        int [][] newMat = new int[r][c];
        int[] arr = new int[m*n];
        int k = 0;
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0 ; j < n ; j++ ){
                arr[k] = mat[i][j];
                k++;
            }
        }
        k = 0 ;
        for(int i = 0 ; i < r ; i++ ){
            for(int j = 0 ; j < c ; j++ ){
                newMat[i][j] = arr[k];
                k++;
            }
        }
        return newMat;
    }
}
