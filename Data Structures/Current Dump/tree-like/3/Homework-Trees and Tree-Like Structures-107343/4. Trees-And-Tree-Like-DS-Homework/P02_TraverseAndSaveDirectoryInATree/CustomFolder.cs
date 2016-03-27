namespace P02_TraverseAndSaveDirectoryInATree
{
    public class CustomFolder
    {
        public CustomFolder(string name, CustomFile[] files = null, params CustomFolder[] folders)
        {
            this.Name = name;
            this.Files = files;
            this.Folders = folders;
        }

        public string Name { get; set; }

        public CustomFile[] Files { get; private set; }

        public CustomFolder[] Folders { get; private set; }
    }
}

/*
private long size;
public long Size
{
    get
    {
        // Return folder size if is already calculated
        if (this.size != 0 || (this.Files.Count == 0 && this.Folders.Count == 0))
        {
            return this.size;
        }

        foreach (CustomFile file in this.Files)
        {
            this.size += file.Size;
        }

        foreach (CustomFolder subFolder in this.Folders)
        {
            // Calculate each subFolder size recursively
            this.size += subFolder.Size;
        }

        return this.size;
    }
}
*/