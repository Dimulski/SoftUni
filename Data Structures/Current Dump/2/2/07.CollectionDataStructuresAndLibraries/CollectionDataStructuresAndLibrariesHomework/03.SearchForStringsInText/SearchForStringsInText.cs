namespace _03.SearchForStringsInText
{
    using System;
    using System.Collections.Generic;
    using System.IO;

    public class SearchForStringsInText
    {
        private static string textFilePath = "../../text.txt";

        public static void Main()
        {
            var strings = ReadSearchedStrings();
            var numberOfAppearances = new Dictionary<string, ulong>();
            foreach (var currString in strings)
            {
                numberOfAppearances.Add(currString, 0);
            }
            
            using (StreamReader reader = new StreamReader(textFilePath))
            {
                string currLine = reader.ReadLine();
                while (currLine != null)
                {
                    foreach (var currString in strings)
                    {
                        string line = currLine.ToLower();
                        string stringToSearch = currString.ToLower();
                        int index = line.IndexOf(stringToSearch);
                        while (index != -1)
                        {
                            numberOfAppearances[currString]++;

                            line = line.Substring(index + stringToSearch.Length);
                            index = line.IndexOf(stringToSearch);
                        }
                    }

                    currLine = reader.ReadLine();
                }
            }

            foreach (var currString in numberOfAppearances.Keys)
            {
                Console.WriteLine("{0} -> {1}", currString, numberOfAppearances[currString]);
            }
        }

        private static IList<string> ReadSearchedStrings()
        {
            IList<string> strings = new List<string>();

            int numberOfStrings = int.Parse(Console.ReadLine());
            for (int i = 0; i < numberOfStrings; i++)
            {
                string @string = Console.ReadLine();
                strings.Add(@string);
            }

            return strings;
        }
    }
}
