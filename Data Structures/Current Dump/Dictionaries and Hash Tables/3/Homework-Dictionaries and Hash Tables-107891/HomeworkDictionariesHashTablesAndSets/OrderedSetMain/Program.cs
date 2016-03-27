using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OrderedSetMain
{
    class Program
    {
        static void Main()
        {
            var set = new OrderedSet<int>();
            set.Add(17);
            set.Add(9);
            set.Add(12);
            set.Add(19);
            set.Add(6);
            set.Add(25);
            set.Add(17);

            foreach (var item in set)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("Count is: {0}", set.Count);

            set.Remove(25);

            foreach (var item in set)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine("Count is: {0}", set.Count);
        }
    }
}
