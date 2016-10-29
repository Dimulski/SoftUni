// Write a program that reads a text file and inserts line numbers in front of each of its lines.
// The result should be written to another text file. Use StreamReader in combination with StreamWriter.

using System.IO;

namespace Problem_2_Line_Numbers
{
    class LineNumbers
    {
        static void Main()
        {
            using (var reader = new StreamReader("ayy lmao.txt"))
            {
                using (var writer = new StreamWriter("dank meme.txt"))
                {
                    string line = reader.ReadLine();
                    while (line != null)
                    {
                        writer.WriteLine(line);
                        line = reader.ReadLine();
                    }
                }
            }
        }
    }
}
