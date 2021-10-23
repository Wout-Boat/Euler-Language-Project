using System;

namespace EulerProblems
{
    class Program
    {
        static void Main(string[] args)
        {
            var watch = new System.Diagnostics.Stopwatch();

            watch.Start();
            for (var i = 0; i < 1000; i++)
            {
                Problem();
            }
            watch.Stop();

            Console.WriteLine($"Function Took: {watch.Elapsed}");
        }

        static void Problem()
        {
            int a = 1, b = 2, sum = 2, c = 0;

            while (c < 4_000_000)
            {
                c = a + b;
                if (c % 2 == 0)
                {
                    sum += c;
                }

                a = b;
                b = c;
            }
            Console.WriteLine(sum);
        }
    }
}