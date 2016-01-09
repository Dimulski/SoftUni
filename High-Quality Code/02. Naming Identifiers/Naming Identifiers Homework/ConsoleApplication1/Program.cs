using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            var m = new double[,] { { 1, 3 }, { 5, 7 } };
            var _mm = new double[,] { { 4, 2 }, { 1, 5 } };
            var r = mm(m, _mm);

            for (int ii = 0; ii < r.GetLength(0); ii++)
            {
                for (int jj = 0; jj < r.GetLength(1); jj++)
                {
                    Console.Write(r[ii, jj] + " ");
                }
                Console.WriteLine();
            }

        }

        static double[,] mm(double[,] _, double[,] __)
        {
            if (_.GetLength(1) != __.GetLength(0))
            {
                throw new Exception("Error!");
            }

            var _______ = _.GetLength(1);
            var ___ = new double[_.GetLength(0), __.GetLength(1)];
            for (int ____ = 0; ____ < ___.GetLength(0); ____++)
                for (int _____ = 0; _____ < ___.GetLength(1); _____++)
                    for (int ______ = 0; ______ < _______; ______++)
                        ___[____, _____] += _[____, ______] * __[______, _____];
            return ___;
        }
    }
}