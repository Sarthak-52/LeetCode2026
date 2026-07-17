class NumMatrix {

    int[][] matrix;
    int[][] pSum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        pSum = new int[matrix.length][matrix[0].length];
        initializePsum();
    }

    private void initializePsum() {
        pSum[0][0] = matrix[0][0];

        for (int col = 1; col < pSum[0].length; col++) {
            pSum[0][col] = pSum[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < pSum.length; row++) {
            pSum[row][0] = pSum[row - 1][0] + matrix[row][0];
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                pSum[row][col] = pSum[row - 1][col]
                        + pSum[row][col - 1]
                        - pSum[row - 1][col - 1]
                        + matrix[row][col];
            }
        }
    }

    public int sumRegion(int tlr, int tlc, int brr, int brc) {
        int s = getValue(brr, brc);
        int a = getValue(tlr - 1, brc);
        int b = getValue(brr, tlc - 1);
        int c = getValue(tlr - 1, tlc - 1);

        return s - a - b + c;
    }

    private int getValue(int row, int col) {
        if (row < 0 || col < 0)
            return 0;
        return pSum[row][col];
    }
}