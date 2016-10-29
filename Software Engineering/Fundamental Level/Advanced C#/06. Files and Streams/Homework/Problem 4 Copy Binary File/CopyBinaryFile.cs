// Write a program that copies the contents of a binary file (e.g. image, video, etc.) to another using FileStream.
// You are not allowed to use the File class or similar helper classes.

using System.IO;

namespace Problem_4_Copy_Binary_File
{
    class CopyBinaryFile
    {
        static void Main()
        {
            using (var source = new FileStream("the irony.jpg", FileMode.Open))
            {
                using (var destination = new FileStream("but not quite.txt", FileMode.Create))
                {
                    byte[] buffer = new byte[4096];
                    while (true)
                    {
                        int readBytes = source.Read(buffer, 0, buffer.Length);
                        if (readBytes == 0)
                        {
                            break;
                        }
                        destination.Write(buffer, 0, readBytes);
                    }
                }
            }
        }
    }
}
