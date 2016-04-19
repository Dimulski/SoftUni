namespace Part2EightQueensPuzzle
{
    using System;

    public class EightQueensPuzzleMain
    {
        public static void Main()
        {
            EightQueens.PutQueens(0);
            Console.WriteLine("Solutions found: " + EightQueens.SolutionsFound);
        }
    }
}
