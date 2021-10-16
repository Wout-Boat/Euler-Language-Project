using System;
using System.Numerics;
using System.Text;
using Microsoft.VisualBasic.CompilerServices;

namespace EulerProblems
{
    class Program
    {
        private static readonly string[] ones =
            {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        private static readonly string[] teens =
            {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        private static readonly string[] tens =
            {"", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        static void Main(string[] args)
        {
            var watch = new System.Diagnostics.Stopwatch();

            watch.Start();
            Problem();
            watch.Stop();

            Console.WriteLine($"Function Took: {watch.Elapsed}");
        }

        // This function returns a string of a given number num
        // It is functiontional from 1-1000 and does not have spaces
        static string numToString(int num)
        {
            if (num == 1000)
            {
                return "OneThousand";
            }

            if (num < 10)
            {
                return ones[num - 1];
            }

            StringBuilder output = new StringBuilder();

            if (num >= 100)
            {
                var hundresSpot = num / 100;
                var remainder = num % 100;
                output.Append(ones[hundresSpot - 1]);
                output.Append("Hundred");
                if (remainder == 0)
                {
                    return output.ToString();
                }

                output.Append("And");
                num = remainder;
            } // End Hundreds

            if (num >= 10)
            {
                if (num < 20)
                {
                    output.Append(teens[num - 10]);
                    return output.ToString();
                }

                var tensSpot = num / 10;
                var remainder = num % 10;
                output.Append(tens[tensSpot - 1]);
                if (remainder == 0)
                {
                    return output.ToString();
                }

                num = remainder;
            } // End Tens

            output.Append(ones[num - 1]);
            return output.ToString();
        }

        static int NumLength(int num)
        {
            return numToString(num).Length;
        }

        private static void Problem()
        {
            var sum = 0;
            for (var i = 1; i < 1001; i++)
            {
                sum += NumLength(i);
            }
            Console.WriteLine(sum);
        }
    }
}