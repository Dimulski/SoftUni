namespace OpenClosedFileDownloadBefore
{
    public class Progress
    {
        private File file;

        // If we want to stream a Music file, we cannot
        public Progress(File file)
        {
            this.file = file;
        }

        public int CalcCurrentPercent()
        {
            return this.file.BytesSent * 100 / this.file.Length;
        }
    }
}
