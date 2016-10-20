using System;
using



            System.Collections.Generic;


       using System.Linq;
            using System.Text;
using System.Threading.Tasks;

                namespace Huy_Phuong
                {
                                        internal partial class NhaHat
                                    {
                                    protected internal static string ExecutePrintAllPerformancesCommand()
                                    {
                                        var performances = NhaHat.universal.ListAllPerformances().ToList();
                    var result = String.Empty;
                    if (performances.Any())
    {
        for (int i = 0; i < performances.Count; i++)
        {
            var sb = new StringBuilder();
                    sb.Append(result);
                    if (i > 0)
                    {
                        sb.Append(", ");
                    }
                    string result1 = performances[i].s2.ToString("dd.MM.yyyy HH:mm");
                    sb.AppendFormat(
        "({0}, {1}, {2})", performances
        
        
        
        
        [i].tr32, performances                                                                                                                                                                                                                                  [i].tr23, result1);
    result = sb + "";
                }
                return result;
            }

return "No performances";
}
    }
}
