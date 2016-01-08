using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main()
        {
            var firstDoubleJaggedArray = new double[,] { { 1, 3 }, { 5, 7 } };
            var secondDoubleJaggedArray = new double[,] { { 4, 2 }, { 1, 5 } };
            var r = mm(firstDoubleJaggedArray, secondDoubleJaggedArray);

            for (int i = 0; i < r.GetLength(0); i++)
            {
                for (int jj = 0; jj < r.GetLength(1); jj++)
                {
                    Console.Write(r[i, jj] + " ");
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