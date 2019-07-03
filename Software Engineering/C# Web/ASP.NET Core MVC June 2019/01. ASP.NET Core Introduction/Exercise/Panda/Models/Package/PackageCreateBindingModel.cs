namespace Panda.Models.Package
{
    public class PackageCreateBindingModel
    {
        public string Description { get; set; }

        public decimal Weight { get; set; }

        public string ShoppingAddress { get; set; }

        public string Recipient { get; set; }
    }
}
