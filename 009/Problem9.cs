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
        private static void Problem()
        {
            var a = 0;
            var b = 0;
            var c = 0;
            const int s = 1000;
            var found = false;
            for (a = 1; a < s / 3; a++)
            {
                for (b = a; b < s / 2; b++)
                {
                    c = s - a - b;

                    if ((a * b) + (b * b) == c * c)
                    {
                        found = true;
                        break;
                    }
                }

                if (found)
                {
                    break;
                }
            }
            Console.WriteLine(a * b * c);
        }
    }
}