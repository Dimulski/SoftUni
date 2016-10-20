namespace OpenClosedFileDownloadAfter
{
    using OpenClosedFileDownloadAfter.Contracts;

    public class File : IStreamResult
    {
        public string Name { get; set; }

        public int Length { get; set; }

        public int BytesSent { get; set; }
    }
}
