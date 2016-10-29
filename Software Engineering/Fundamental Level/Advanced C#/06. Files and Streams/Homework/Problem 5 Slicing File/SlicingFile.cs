// Write a program that takes any file and slices it to n parts. Write the following methods:
// • Slice(string sourceFile, string destinationDirectory, int parts) - slices the given source file into n parts and saves them in destinationDirectory.
// • Assemble(List<string> files, string destinationDirectory) - combines all files into one, in the order they are passed, and saves the result in destinationDirectory.
// Use FileStreams. You are not allowed to use the File class or similar helper classes.

using System;
using System.IO;

namespace Problem_5_Slicing_File
{
    class SlicingFile
    {
        const string filePath = "file.txt";
        const string assemblePath = "assembled.txt";

        private static void Main()
        {
            Console.Write("n:");
            int parts = int.Parse(Console.ReadLine());
            SliceFile(parts);
            for (int i = 0; i < parts; i++)
            {
                AssembleFiles(i);
            }
        }

        private static void AssembleFiles(int i)
        {
            using (var source = new FileStream(string.Format("Part-{0}.txt", i), FileMode.Open))
            {
                using (var destination = new FileStream(assemblePath, i == 0 ? FileMode.Create : FileMode.Append))
                {
                    var buffer = new byte[source.Length];
                    source.Read(buffer, 0, buffer.Length);
                    destination.Write(buffer, 0, buffer.Length);
                }
            }
        }

        private static void SliceFile(int parts)
        {
            using (var source = new FileStream(filePath, FileMode.Open))
            {
                long sliceSize = source.Length / parts;
                long leftOver = source.Length - sliceSize * parts;
                for (int i = 0; i < parts; i++)
                {
                    using (var destination = new FileStream(string.Format("Part-{0}.txt", i), FileMode.Create))
                    {
                        sliceSize = (i < parts - 1) ? sliceSize : sliceSize + leftOver;
                        var buffer = new byte[sliceSize];
                        source.Read(buffer, 0, buffer.Length);
                        destination.Write(buffer, 0, buffer.Length);
                    }
                }
            }
        }
    }
}