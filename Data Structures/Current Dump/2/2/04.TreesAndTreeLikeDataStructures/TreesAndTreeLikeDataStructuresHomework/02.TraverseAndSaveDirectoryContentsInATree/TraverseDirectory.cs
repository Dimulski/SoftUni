namespace _02.TraverseAndSaveDirectoryContentsInATree
{
    using System;
    using System.Collections.Generic;
    using System.IO;

    public class TraverseDirectory
    {
        private const string StartDirectory = @"C:\WINDOWS";

        private static Dictionary<string, Folder> folders = new Dictionary<string,Folder>();

        public static void Main()
        {
            var paths = new Queue<string>();
            paths.Enqueue(StartDirectory);
            while (paths.Count > 0)
            {
                var currPath = paths.Dequeue();
                var currFolder = GetFolderByPath(currPath);
                var directoryInfo = new DirectoryInfo(currPath);

                var currFiles = directoryInfo.GetFiles();
                var fileList = new List<File>();
                foreach (var file in currFiles)
                {
                    fileList.Add(new File(file.FullName, file.Length));
                }

                currFolder.Files = fileList.ToArray();

                var currFolders = directoryInfo.GetDirectories();
                var folderList = new List<Folder>();
                foreach (var folder in currFolders)
                {
                    var newFolder = new Folder(folder.FullName);
                    folders.Add(folder.FullName, newFolder);
                    folderList.Add(newFolder);

                    paths.Enqueue(folder.FullName);
                }

                currFolder.ChildFolders = folderList.ToArray();
            }

            var testFolder = GetFolderByPath(StartDirectory);
            Console.WriteLine("Folder: {0}{1}Size in bytes: {2}", testFolder.Name, Environment.NewLine, testFolder.Size);
        }

        private static Folder GetFolderByPath(string path)
        {
            if (!folders.ContainsKey(path))
            {
                folders.Add(path, new Folder(path));
            }

            return folders[path];
        }
    }
}
