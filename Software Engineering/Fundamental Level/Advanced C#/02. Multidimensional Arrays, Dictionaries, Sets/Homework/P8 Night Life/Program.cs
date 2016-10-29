// Being a nerd means writing programs about night clubs instead of actually going to ones. Spiro is a nerd and he decided to summarize some info about the most popular night clubs around the world. 
// He's come up with the following structure – he'll summarize the data by city, where each city will have a list of venues and each venue will have a list of performers. Help him finish the program, so he can stop staring at the computer screen and go get himself a cold beer.
// You'll receive the input from the console. There will be an arbitrary number of lines until you receive the string "END". Each line will contain data in format: "city;venue;performer". If either city, venue or performer don't exist yet in the database, add them. If either the city and/or venue already exist, update their info.
// Cities should remain in the order in which they were added, venues should be sorted alphabetically and performers should be unique (per venue) and also sorted alphabetically.
// Print the data by listing the cities and for each city its venues (on a new line starting with "->") and performers (separated by comma and space). Check the examples to get the idea. And grab a beer when you're done, you deserve it. Spiro is buying.

using System;
using System.Collections.Generic;

namespace P8_Night_Life
{
    class NightLife
    {
        static void Main()
        {
            Dictionary<string, SortedDictionary<string, SortedSet<string>>> nightLifeDictionary = new Dictionary<string, SortedDictionary<string, SortedSet<string>>>();

            string[] eventTokens;
            string city = String.Empty;
            string venue = String.Empty;
            string performer = String.Empty;
            string eventInformation = Console.ReadLine();

            while (eventInformation != "END")
            {
                eventTokens = eventInformation.Split(new char[] { ';' }, StringSplitOptions.RemoveEmptyEntries);

                city = eventTokens[0];
                venue = eventTokens[1];
                performer = eventTokens[2];

                if (!nightLifeDictionary.ContainsKey(city))
                {
                    nightLifeDictionary[city] = new SortedDictionary<string, SortedSet<string>>();
                }
                if (!nightLifeDictionary[city].ContainsKey(venue))
                {
                    nightLifeDictionary[city][venue] = new SortedSet<string>();
                }
                nightLifeDictionary[city][venue].Add(performer);

                eventInformation = Console.ReadLine();
            }

            foreach (var cityPair in nightLifeDictionary)
            {
                Console.WriteLine(cityPair.Key);
                foreach (var venuePair in cityPair.Value)
                {
                    Console.WriteLine("->{0}: {1}", venuePair.Key, String.Join(", ", venuePair.Value));
                }
            }
        }
    }
}