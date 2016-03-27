namespace _02.TraverseАndSaveDirectory
{
    using System;
    using System.Collections.Generic;
    using System.IO;

    using File = _02.TraverseSaveDirectoryContentsInTree.File;

    public static class TraverseАndSaveDirectory
    {
        private const string StartDirectory = @"C:\Program Files";
        private static IDictionary<string, Folder> folders;

        public static void Main()
        {
            folders = new Dictionary<string, Folder>();
            TraverseFolders();
            var sampleFolder = GetFolderByPath(@"C:\Program Files");
            Console.WriteLine("Total size of {0} folder is: {1} bytes.", sampleFolder.Name, sampleFolder.Size);
        }

        private static void TraverseFolders(string startDirectory = StartDirectory)
        {
            var folderProcessor = new Queue<string>();
            folderProcessor.Enqueue(startDirectory);

            while (folderProcessor.Count > 0)
            {
                var currentFolderPath = folderProcessor.Dequeue();
                var currentFolder = GetFolderByPath(currentFolderPath);

                var dirInfo = new DirectoryInfo(currentFolderPath);

                var currentFiles = dirInfo.GetFiles();
                foreach (var currentFile in currentFiles)
                {
                    File file = new File(currentFile.Name, currentFile.Length);
                    currentFolder.Files.Add(file);
                }

                var currentDirs = dirInfo.GetDirectories();

                foreach (var currentDir in currentDirs)
                {
                    var folder = new Folder(currentDir.FullName);
                    folders[currentDir.FullName] = folder;
                    currentFolder.Folders.Add(folder);

                    folderProcessor.Enqueue(currentDir.FullName);
                }
            }
        }

        private static Folder GetFolderByPath(string folderPath)
        {
            if (!folders.ContainsKey(folderPath))
            {
                folders[folderPath] = new Folder(folderPath);
            }

            return folders[folderPath];
        }
    }
}
