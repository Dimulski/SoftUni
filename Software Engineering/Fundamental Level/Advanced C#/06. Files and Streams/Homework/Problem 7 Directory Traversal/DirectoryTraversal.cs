//Traverse a given directory for all files with the given extension.Search through the first level of the directory only and
// write information about each found file in report.txt. The files should be grouped by their extension. Extensions should be
// ordered by the count of their files (from most to least). If two extensions have equal number of files, order them by name.
// Files under an extension should be ordered by their size.
// report.txt should be saved on the Desktop. Ensure the desktop path is always valid, regardless of the user.

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Problem_7_Directory_Traversal
{
    class DirectoryTraversal
    {
        static void Main()
        {
            string[] files = Directory.GetFiles(Directory.GetCurrentDirectory());
            var dir = new Dictionary<string, Dictionary<string, double>>();
            foreach (var file in files)
            {
                var info = new FileInfo(file);
                string extension = info.Extension;
                string name = info.Name;
                double size = info.Length;
                if (!dir.Keys.Contains(extension))
                {
                    dir.Add(extension, new Dictionary<string, double>());
                }
                dir[extension].Add(name, size);
            }

            var sortedOutput = dir
                .OrderByDescending(filesCount => filesCount.Value.Keys.Count)
                .ThenBy(extension => extension.Key)
                .ThenBy(size => size.Value.Values);

            string desktop = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            using (StreamWriter writer = new StreamWriter(desktop + @"\" + "report.txt"))
            {
                foreach (var ext in sortedOutput)
                {
                    writer.WriteLine(ext.Key);
                    foreach (var file in ext.Value)
                    {
                        writer.WriteLine("--{0} - {1:F3}kb", file.Key, file.Value / 1024);
                    }
                }
            }
        }
    }
}