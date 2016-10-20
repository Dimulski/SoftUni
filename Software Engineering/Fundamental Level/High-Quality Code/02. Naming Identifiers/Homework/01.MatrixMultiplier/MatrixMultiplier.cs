namespace MatrixMultiplier
{
    using System;

    public static class MatrixMultiplier
    {
        public static void Main()
        {
            var matrixA = new double[,]
            {
                { 1, 3 },
                { 5, 7 }
            };

            var matrixB = new double[,]
            {
                { 4, 2 },
                { 1, 5 }
            };

            var multipliedMatrix = MultiplyMatrieces(matrixA, matrixB);

            for (var row = 0; row < multipliedMatrix.GetLength(0); row++)
            {
                for (var col = 0; col < multipliedMatrix.GetLength(1); col++)
                {
                    Console.Write(multipliedMatrix[row, col] + " ");
                }

                Console.WriteLine();
            }
        }

        private static double[,] MultiplyMatrieces(double[,] matrixA, double[,] matrixB)
        {
            if (matrixA.GetLength(1) != matrixB.GetLength(0))
            {
                throw new InvalidOperationException(
                    $"The number of columns in {nameof(matrixA)} is not equals to the number of rows in {nameof(matrixB)}");
            }

            var numOfColsMatrixA = matrixA.GetLength(1);

            var result = new double[matrixA.GetLength(0), matrixB.GetLength(1)];

            for (var row = 0; row < result.GetLength(0); row++)
            {
                for (var col = 0; col < result.GetLength(1); col++)
                {
                    for (var i = 0; i < numOfColsMatrixA; i++)
                    {
                        result[row, col] += matrixA[row, i] * matrixB[i, col];
                    }
                }
            }

            return result;
        }
    }
}
