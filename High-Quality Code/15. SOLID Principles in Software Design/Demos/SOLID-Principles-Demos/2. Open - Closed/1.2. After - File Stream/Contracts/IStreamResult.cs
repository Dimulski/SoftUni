namespace OpenClosedFileDownloadAfter.Contracts
{
    public interface IStreamResult
    {
        int Length { get; set; }

        int BytesSent { get; set; }
    }
}
