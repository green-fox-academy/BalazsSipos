using System;

namespace DerekTutorialApp
{
    class Program
    {
        static void Main(string[] args)
        {
            //Console.Write("Input your name: ");
            //string name = Console.ReadLine();
            //Console.WriteLine("Hello " + name);

            var anothorName = "Tom"; // bármi lehet, a beletett adat dönti el, hogy milyen datatype lesz, később már nem változtatható a type
            Console.WriteLine(anothorName.GetTypeCode());

            // Math
            double pi = 3.14;
            int intPi = (int)pi;
            Console.WriteLine(intPi);

            // random egész szám
            Random rand = new Random();
            Console.WriteLine("between 1 and 10 " + rand.Next(1,11));

            // String
            string sampleString = "A bunch of random words";
            Console.WriteLine("Index of bunch: " + sampleString.IndexOf("bunch"));
            Console.WriteLine("2nd word: " + sampleString.Substring(2,6));

            string[] names = new string[3] { "Matt", "Ann", "Dan" };
            Console.WriteLine("Name list " + String.Join( ", ", names));
        }
    }
}
