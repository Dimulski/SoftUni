namespace P02_TraverseAndSaveDirectoryInATree
{
    using System;
    using System.Collections.Generic;
    using System.IO;
    using System.Linq;

    public class TraverseAndSaveDirectoryContent
    {
        private const string StartPoint = @"C:\Windows\SystemResources";

        private static SortedDictionary<string, CustomFolder> foldersByName = new SortedDictionary<string, CustomFolder>(); 

        public static void Main()
        {
            CustomFolder rootFolder = FindFolders(new DirectoryInfo(StartPoint));

            Console.WriteLine("All folders info:");
            Console.WriteLine("----------------------------------------");
            PrintFoldersInfo();
            Console.WriteLine();

            Console.WriteLine("All folders and files in the tree:");
            PrintFoldersTree(rootFolder);
            Console.WriteLine();

            Console.WriteLine("All folders in the tree:");
            foreach (var folder in foldersByName)
            {
                Console.WriteLine(folder.Key);
            }

            Console.WriteLine();
        }

        public static CustomFolder FindFolders(DirectoryInfo di)
        {
            string folderName = di.FullName;

            List<CustomFile> customFiles = new List<CustomFile>();
            var files = di.GetFiles();
            foreach (var f in files)
            {
                CustomFile file = new CustomFile(f.Name, f.Length);
                customFiles.Add(file);
            }

            List<CustomFolder> customFolders = new List<CustomFolder>();
            var folders = di.GetDirectories();
            foreach (var f in folders)
            {
                CustomFolder folder = FindFolders(new DirectoryInfo(f.FullName));
                customFolders.Add(folder);
            }

            CustomFolder currentFolder = new CustomFolder(folderName, customFiles.ToArray(), customFolders.ToArray());
            foldersByName.Add(folderName, currentFolder);

            return currentFolder;
        }

        public static void PrintFoldersTree(CustomFolder folder, int indent = 0)
        {
            string folderShortName = FindFolderName(folder.Name);
            Console.WriteLine("{0}{1}", new string('-', indent * 2), folderShortName);
            indent++;

            foreach (var file in folder.Files)
            {
                Console.WriteLine("{0}{1}", new string('-', indent * 2), file.Name);
            }

            foreach (var f in folder.Folders)
            {
                PrintFoldersTree(f, indent);
            }
        }

        public static void PrintFoldersInfo()
        {
            foreach (KeyValuePair<string, CustomFolder> kvp in foldersByName)
            {
                CustomFolder folder = kvp.Value;
                //// string folderShortName = FindFolderName(folder.Name);

                IEnumerable<string> files = folder.Files.Select(file => file.Name);

                List<string> folders = new List<string>();
                foreach (CustomFolder f in folder.Folders)
                {
                    string sortName = FindFolderName(f.Name);
                    folders.Add(sortName);
                }

                long size = 0L;
                FindTreeSize(folder, ref size);

                Console.WriteLine("Folder path: {0}", folder.Name);

                if (files == null || !files.Any())
                {
                    Console.WriteLine("Folder files: none");
                }
                else
                {
                    Console.WriteLine("Folder files: {0}", string.Join(", ", files));
                }

                if (folders == null || !folders.Any())
                {
                    Console.WriteLine("Folder subfolders: none");
                }
                else
                {
                    Console.WriteLine("Folder subfolders: {0}", string.Join(", ", folders));
                }

                Console.WriteLine("Sum of all file sizes in this subtree: {0}", size);
                Console.WriteLine("----------------------------------------");
            }
        }

        public static long FindTreeSize(CustomFolder folder, ref long size)
        {
            size += folder.Files.Sum(file => file.Size);
            
            if (folder.Folders == null || folder.Folders.Length == 0)
            {
                return size + folder.Files.Sum(file => file.Size);
            }

            foreach (CustomFolder f in folder.Folders)
            {
                FindTreeSize(f, ref size);
            }

            return 0;
        }

        public static string FindFolderName(string fullName)
        {
            int index = fullName.LastIndexOf('\\');
            string folderShortName = fullName.Substring(index + 1);

            return folderShortName;
        }
    }
}