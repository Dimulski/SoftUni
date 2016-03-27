using System;
using System.Collections.Generic;
using System.Linq;
using Wintellect.PowerCollections;

public class PersonCollection : IPersonCollection
{
    private Dictionary<string, Person> personsByEmail = new Dictionary<string, Person>();
    private Dictionary<string, SortedSet<Person>> personsByEmailDomain = new Dictionary<string, SortedSet<Person>>(); 
    private Dictionary<string, SortedSet<Person>> personsByTownAndName = new Dictionary<string, SortedSet<Person>>();
    private OrderedDictionary<int, SortedSet<Person>> personsByAge = new OrderedDictionary<int, SortedSet<Person>>();
    private Dictionary<string, OrderedDictionary<int, SortedSet<Person>>> personsByTownAndAge =
        new Dictionary<string, OrderedDictionary<int, SortedSet<Person>>>();

    public bool AddPerson(string email, string name, int age, string town)
    {
        if (this.FindPerson(email) != null)
        {
            return false;
        }

        var person = new Person(email, name, age, town);
        this.personsByEmail.Add(email, person);

        string emailDomain = this.ExtractEmailDomain(email);
        this.personsByEmailDomain.AppendValueToKey(emailDomain, person);

        string townAndName = this.CombineNameAndTown(name, town);
        this.personsByTownAndName.AppendValueToKey(townAndName, person);

        this.personsByAge.AppendValueToKey(age, person);

        this.personsByTownAndAge.EnsureKeyExists(town);
        this.personsByTownAndAge[town].AppendValueToKey(age, person);

        return true;
    }

    public int Count
    {
        get
        {
            return this.personsByEmail.Count;
        }
    }

    public Person FindPerson(string email)
    {
        Person person;
        this.personsByEmail.TryGetValue(email, out person);

        return person;
    }

    public bool DeletePerson(string email)
    {
        var person = this.FindPerson(email);
        if (person == null)
        {
            return false;
        }

        this.personsByEmail.Remove(email);

        string emailDomain = this.ExtractEmailDomain(email);
        this.personsByEmailDomain[emailDomain].Remove(person);

        string townAndName = this.CombineNameAndTown(person.Name, person.Town);
        this.personsByTownAndName[townAndName].Remove(person);

        this.personsByAge[person.Age].Remove(person);

        this.personsByTownAndAge[person.Town][person.Age].Remove(person);

        return true;
    }

    public IEnumerable<Person> FindPersons(string emailDomain)
    {
        return this.personsByEmailDomain.GetValuesForKey(emailDomain);
    }

    public IEnumerable<Person> FindPersons(string name, string town)
    {
        string nameAndTown = this.CombineNameAndTown(name, town);

        return this.personsByTownAndName.GetValuesForKey(nameAndTown);
    }

    public IEnumerable<Person> FindPersons(int startAge, int endAge)
    {
        var range = this.personsByAge.Range(startAge, true, endAge, true);
        foreach (var personsSet in range)
        {
            foreach (var person in personsSet.Value)
            {
                yield return person;
            }
        }
    }

    public IEnumerable<Person> FindPersons(
        int startAge, int endAge, string town)
    {
        if (!this.personsByTownAndAge.ContainsKey(town))
        {
            yield break;
        }

        var range = this.personsByTownAndAge[town].Range(startAge, true, endAge, true);
        foreach (var personsSet in range)
        {
            foreach (var person in personsSet.Value)
            {
                yield return person;
            }
        }
    }

    private string ExtractEmailDomain(string email)
    {
        string emailDomain = email.Split('@')[1];

        return emailDomain;
    }

    private string CombineNameAndTown(string name, string town)
    {
        string nameAndTown = name + "|!|" + town;

        return nameAndTown;
    }
}
