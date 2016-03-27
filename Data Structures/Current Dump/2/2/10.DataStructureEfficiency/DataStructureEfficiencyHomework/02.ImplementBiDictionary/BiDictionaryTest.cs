namespace _02.ImplementBiDictionary
{
    using System;

    public class BiDictionaryTest
    {
        public static void Main()
        {
            var distances = new BiDictionary<string, string, int>();
            distances.Add("Sofia", "Varna", 443);
            distances.Add("Sofia", "Varna", 468);
            distances.Add("Sofia", "Varna", 490);
            distances.Add("Sofia", "Plovdiv", 145);
            distances.Add("Sofia", "Bourgas", 383);
            distances.Add("Plovdiv", "Bourgas", 253);
            distances.Add("Plovdiv", "Bourgas", 292);

            var distancesFromSofia = distances.FindByKey1("Sofia");
            Console.WriteLine("Distances from Sofia: [{0}]", string.Join(", ", distancesFromSofia));
            // [443, 468, 490, 145, 383]
            var distancesToBourgas = distances.FindByKey2("Bourgas");
            Console.WriteLine("Distances to Burgas: [{0}]", string.Join(", ", distancesToBourgas));
            // [383, 253, 292]
            var distancesPlovdivBourgas = distances.Find("Plovdiv", "Bourgas");
            Console.WriteLine("Distances Plovdiv - Burgas: [{0}]", string.Join(", ", distancesPlovdivBourgas));
            // [253, 292]
            var distancesRousseVarna = distances.Find("Rousse", "Varna");
            Console.WriteLine("Distances Rousse - Varna: [{0}]", string.Join(", ", distancesRousseVarna));
            // []
            var distancesSofiaVarna = distances.Find("Sofia", "Varna");
            Console.WriteLine("Distances Sofia - Varna: [{0}]", string.Join(", ", distancesSofiaVarna));
            // [443, 468, 490]
            var removed = distances.Remove("Sofia", "Varna");
            Console.WriteLine("Removed Sofia - Varna: {0}", removed);
            // true
            var distancesFromSofiaAgain = distances.FindByKey1("Sofia");
            Console.WriteLine("Distances from Sofia: [{0}]", string.Join(", ", distancesFromSofiaAgain));
            // [145, 383]
            var distancesToVarna = distances.FindByKey2("Varna");
            Console.WriteLine("Distances to Varna: [{0}]", string.Join(", ", distancesToVarna));
            // []
            var distancesSofiaVarnaAgain = distances.Find("Sofia", "Varna");
            Console.WriteLine("Distances Sofia - Varna: [{0}]", string.Join(", ", distancesSofiaVarnaAgain));
            // []
        }
    }
}
