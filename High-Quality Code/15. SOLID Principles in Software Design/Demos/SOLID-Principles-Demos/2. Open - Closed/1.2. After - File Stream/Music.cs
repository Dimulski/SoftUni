namespace OpenClosedFileDownloadAfter
{
    using OpenClosedFileDownloadAfter.Contracts;

    public class Music : IStreamResult
    {
        public int Length { get; set; }

        public int BytesSent { get; set; }

        public string Artist { get; set; }

        public string Album { get; set; }
    }
}
