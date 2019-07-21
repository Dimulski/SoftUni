using System.ComponentModel.DataAnnotations;

namespace Panda.Models.Package
{
    public class PackageCreateBindingModel
    {
        [Required]
        [StringLength(100, ErrorMessage = "Description Invalid.", MinimumLength = 5)]
        public string Description { get; set; }

        [Required]
        public double Weight { get; set; }

        [StringLength(100, ErrorMessage = "Shipping Address Invalid.", MinimumLength = 5)]
        public string ShippingAddress { get; set; }

        [Required]
        public string Recipient { get; set; }
    }
}
