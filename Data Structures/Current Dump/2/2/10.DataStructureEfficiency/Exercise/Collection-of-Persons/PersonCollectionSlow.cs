using System.Collections.Generic;
using System.Linq;

public class PersonCollectionSlow : IPersonCollection
{
    private List<Person> persons = new List<Person>(); 

    public bool AddPerson(string email, string name, int age, string town)
    {
        if (this.FindPerson(email) == default(Person))
        {
            var newPerson = new Person(email, name, age, town);
            this.persons.Add(newPerson);

            return true;
        }

        return false;
    }

    public int Count
    {
        get
        {
            return this.persons.Count;
        }
    }

    public Person FindPerson(string email)
    {
        var person = this.persons.FirstOrDefault(p => p.Email.Equals(email));

        return person;
    }

    public bool DeletePerson(string email)
    {
        var person = this.FindPerson(email);
        bool removedSuccessfully = this.persons.Remove(person);

        return removedSuccessfully;
    }

    public IEnumerable<Person> FindPersons(string emailDomain)
    {
        return this.persons
            .Where(p => p.Email.EndsWith("@" + emailDomain))
            .OrderBy(p => p.Email);
    }

    public IEnumerable<Person> FindPersons(string name, string town)
    {
        return this.persons
            .Where(p => p.Name.Equals(name) && p.Town.Equals(town))
            .OrderBy(p => p.Email);
    }

    public IEnumerable<Person> FindPersons(int startAge, int endAge)
    {
        return this.persons
            .Where(p => p.Age >= startAge && p.Age <= endAge)
            .OrderBy(p => p.Age)
            .ThenBy(p => p.Email);
    }

    public IEnumerable<Person> FindPersons(
        int startAge, int endAge, string town)
    {
        return this.persons
            .Where(p => p.Age >= startAge && p.Age <= endAge && p.Town.Equals(town))
            .OrderBy(p => p.Age)
            .ThenBy(p => p.Email);
    }
}
