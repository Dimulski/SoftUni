namespace P02_TraverseAndSaveDirectoryInATree
{
    public class CustomFile
    {
        public CustomFile(string name, long size)
        {
            this.Name = name;
            this.Size = size;
        }

        public string Name { get; private set; }

        public long Size { get; private set; }
    }
}