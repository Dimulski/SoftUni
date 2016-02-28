namespace Problem3SoftuniNumerals
{
    using System;
    using System.Collections.Generic;
    using System.Numerics;
    using System.Text;
    using System.Text.RegularExpressions;

    class SoftuniNumeralsMain
    {
        static void Main()
        {
            string input = Console.ReadLine();

            Dictionary<string, int> dictionary = new Dictionary<string, int>();

            dictionary.Add("aa", 0);
            dictionary.Add("aba", 1);
            dictionary.Add("bcc", 2);
            dictionary.Add("cc", 3);
            dictionary.Add("cdc", 4);

            Regex expression = new Regex("aa|aba|bcc|cc|cdc");

            StringBuilder sb = new StringBuilder();

            foreach (Match match in expression.Matches(input))
            {
                sb.Append(dictionary[match.ToString()]);
            }

            BigInteger number = BigInteger.Parse(sb.ToString());

            var result = FromBase(number, 5);
            Console.WriteLine(result);
        }

        public static BigInteger FromBase(BigInteger value, int @base)
        {
            string number = value.ToString();
            BigInteger n = 1;
            BigInteger r = 0;

            for (int i = number.Length - 1; i >= 0; --i)
            {
                r += n * (number[i] - '0');
                n *= @base;
            }

            return r;
        }
    }
}
