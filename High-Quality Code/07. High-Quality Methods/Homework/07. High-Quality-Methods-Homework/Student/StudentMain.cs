namespace Student
{
    using System;

    class StudentMain
    {
        static void Main()
        {
            Student peter = new Student("Peter", "Ivanov", new DateTime(1992, 03, 17));
            Student stella = new Student("Stella", "Markova", new DateTime(1993, 11, 03));

            Console.WriteLine(peter);
            Console.WriteLine(stella);

            Console.WriteLine("{0} is older than {1} -> {2}",
                peter.FullName, stella.FullName, peter.CompareStudentsBirthDates(stella));

            Console.WriteLine("{0} is older than {1} -> {2}",
               stella.FullName, peter.FullName, stella.CompareStudentsBirthDates(peter));
        }
    }
}