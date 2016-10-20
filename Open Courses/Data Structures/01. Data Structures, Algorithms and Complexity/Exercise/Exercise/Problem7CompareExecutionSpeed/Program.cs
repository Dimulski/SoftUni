namespace Problem7CompareExecutionSpeed
{
    using System;

    class Program
    {
        static void Main()
        {
            var startTime = DateTime.Now;
            for (int i = 0; i < 1000000; i++)
            {
                IsPrimeFast(i);
            }
            var executionTime =
                DateTime.Now - startTime;
            Console.WriteLine("Execution time: {0}",
                executionTime);
        }

        static bool IsPrime(long num)
        {
            for (int i = 2; i < num; i++)
            {
                if (num % i == 0)
                {
                    return false;
                }
            }
            return true;
        }

        static bool IsPrimeFast(long num)
        {
            int maxDivisor = (int)Math.Sqrt(num);
            for (int i = 2; i <= maxDivisor; i++)
            {
                if (num % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
