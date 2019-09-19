using System;
using System.Collections.Generic;
using System.Linq;

namespace Linq
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            var scores = new int[] { 97, 92, 81, 60, 69, 12, 95, 15 };

            //var scoresWithLoop = new List<int>();

            //for(int i = 0; i< scores.Length; i++)
            //{
            //    if(scores[i] > 60)
            //    {
            //        scoresWithLoop.Add(scores[i]);
            //        Console.WriteLine(scores[i]);
            //    }
            //}

            //Console.WriteLine();

            //// method syntax
            //var scoreQueryMethods = scores.Where(s => s > 60);
            //foreach (int scoreTemp in scoreQueryMethods)
            //{
            //    Console.WriteLine(scoreTemp);
            //}

            //Console.WriteLine();

            //// query syntax
            //var scoreQuery = from score in scores
            //                 where score > 60
            //                 select score;

            //foreach (int scoreTemp in scoreQuery)
            //{
            //    Console.WriteLine(scoreTemp);
            //}

            var n = new int[] { 1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14 };
            var evenNumbers = n.Where(x => x %2==0);
            foreach (int scoreTemp in evenNumbers)
            {
                Console.WriteLine(scoreTemp);
            }

            Console.WriteLine();

           
            var evenNumbersAverage = n.Where(x => x % 2 == 0).Average();
            Console.WriteLine(evenNumbersAverage);
            //foreach (int scoreTemp in evenNumbers)
            //{
            //    Console.WriteLine(scoreTemp);
            //}

            Console.WriteLine();

            string[] cities = { "ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS" };

            var myCity = from city in cities
                         where city[0] == 'A'
                         && city[city.Length - 1] == 'I'
                         select city;

            foreach (string tempCity in myCity)
            {
                Console.WriteLine(tempCity);
            }



            // Data source
            string[] names = { "Bill", "Steve", "James", "Bohan" };

            // LINQ Query 
            var myLinqQuery = from name in names
                              where name[0] == 'B'
                              select name;

            // Query execution
            foreach (var name in myLinqQuery)
                Console.Write(name + " ");
        }
    }
}
