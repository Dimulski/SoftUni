namespace OpenClosedFileDownloadAfter
{
    using OpenClosedFileDownloadAfter.Contracts;

    public class Progress
    {
        private IStreamResult streamResult;

        public Progress(IStreamResult streamResult)
        {
            this.streamResult = streamResult;
        }

        public int CalcCurrentPercent()
        {
            return this.streamResult.BytesSent * 100 / this.streamResult.Length;
        }
    }
}
