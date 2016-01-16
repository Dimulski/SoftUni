using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Abstraction
{
    /// <summary>
    /// Inheritors of this interface are capable of creating figures
    /// </summary>
    public interface IFigure
    {
        /// <summary>
        /// Calculate Figure perimeter
        /// </summary>
        /// <returns>floating - point value</returns>
        double CalculatePerimeter();

        /// <summary>
        /// Calculate Figure surface
        /// </summary>
        /// <returns>floating - point value</returns>
        double CalculateSurface();
    }
}
