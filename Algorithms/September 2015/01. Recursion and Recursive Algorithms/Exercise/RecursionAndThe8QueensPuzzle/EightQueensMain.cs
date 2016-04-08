using System;

namespace RecursionAndThe8QueensPuzzle
{
    class EightQueensMain
    {
        static void Main()
        {
            EightQueens.PutQueens(0);
            Console.WriteLine("Solutions found: " + EightQueens.solutionsFound);
        }
    }
}
