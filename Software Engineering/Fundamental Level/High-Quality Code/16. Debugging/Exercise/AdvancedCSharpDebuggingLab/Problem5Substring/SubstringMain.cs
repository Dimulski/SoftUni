namespace Problem5Substring
{
    using System;
    using System.Text;

    public class SubstringMain
    {
        public static void Main()
        {
            string text = Console.ReadLine();
            text += " ";
            int jump = int.Parse(Console.ReadLine());

            char desiredChar = 'p';
            bool hasMatch = false;

            for (int i = 0; i < text.Length; i++)
            {
                if (text[i] == desiredChar)
                {
                    hasMatch = true;

                    int endIndex = jump;

                    if (endIndex > text.Length)
                    {
                        endIndex = text.Length;
                    }

                    string matchedString = text.Substring(i, endIndex + 1);
                    Console.WriteLine(matchedString);
                    i += jump;
                }
            }

            if (!hasMatch)
            {
                Console.WriteLine("no");
            }
        }
    }
}
