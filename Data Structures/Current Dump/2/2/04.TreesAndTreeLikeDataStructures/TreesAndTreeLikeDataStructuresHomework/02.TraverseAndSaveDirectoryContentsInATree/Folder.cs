namespace _02.TraverseAndSaveDirectoryContentsInATree
{
    public class Folder
    {
        private long size;

        public Folder(string name)
        {
            this.Name = name;
        }

        public Folder(string name, File[] files , Folder[] folders)
        {
            this.Name = name;
            this.Files = files;
            this.ChildFolders = folders;
        }

        public string Name { get; set; }

        public File[] Files { get; set; }

        public Folder[] ChildFolders { get; set; }

        public long Size
        {
            get
            {
                if (this.size != 0 && this.Files.Length != 0 && this.ChildFolders.Length != 0)
                {
                    return this.size;
                }

                foreach (var file in this.Files)
                {
                    this.size += file.Size;
                }

                foreach (var folder in this.ChildFolders)
                {
                    this.size += folder.Size;
                }

                return this.size;
            }
        }
    }
}
