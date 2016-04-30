namespace LongestCommonSubsequenceApp
{
    using System;
    using System.Collections.Generic;

    public class LongestCommonSubsequence
    {
        static string _firstStr;
        static string _secondStr;
        private static int[,] _lcs;

        public static void Main()
        {
            Console.WriteLine(FindLongestCommonSubsequence("tree", "team"));
        }

        static void InitializeLCS()
        {
            for (int x = 0; x < _firstStr.Length; x++)
            {
                for (int y = 0; y < _secondStr.Length; y++)
                {
                    _lcs[x, y] = -1;
                }
            }
        }

        public static string FindLongestCommonSubsequence(string firstStr, string secondStr)
        {
            _firstStr = firstStr;
            _secondStr = secondStr;
            _lcs = new int[firstStr.Length, secondStr.Length];

            InitializeLCS();
            CalcLCS(firstStr.Length - 1, secondStr.Length - 1);
            return PrintLCS(firstStr.Length - 1, secondStr.Length - 1);
        }

        static int CalcLCS(int x, int y)
        {
            if (x < 0 || y < 0)
            {
                return 0;
            }

            if (_lcs[x, y] == -1)
            {
                int lcsFirstMinusOne = CalcLCS(x - 1, y);
                int lcsSecondMinusOne = CalcLCS(x, y - 1);
                _lcs[x, y] = Math.Max(lcsFirstMinusOne, lcsSecondMinusOne);
                if (_firstStr[x] == _secondStr[y])
                {
                    int lcsBothMinusOne = 1 + CalcLCS(x - 1, y - 1);
                    _lcs[x, y] = Math.Max(_lcs[x, y], lcsBothMinusOne);
                }
            }

            return _lcs[x, y];
        }

        static string PrintLCS(int x, int y)
        {
            Console.WriteLine("LCS = " + CalcLCS(x, y));

            List<char> lcsLetters = new List<char>();
            while (x >= 0 && y >= 0)
            {
                if ((_firstStr[x] == _secondStr[y]) &&
                    (CalcLCS(x - 1, y - 1) + 1 == _lcs[x, y]))
                {
                    lcsLetters.Add(_firstStr[x]);
                    x--;
                    y--;
                }
                else if (CalcLCS(x - 1, y) == _lcs[x, y])
                {
                    x--;
                }
                else
                {
                    y--;
                }
            }

            lcsLetters.Reverse();
            return string.Join("", lcsLetters);
        }
    }
}
