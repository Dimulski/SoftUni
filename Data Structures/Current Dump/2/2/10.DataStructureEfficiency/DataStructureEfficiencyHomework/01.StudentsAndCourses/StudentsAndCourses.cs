namespace _01.StudentsAndCourses
{
    using System;
    using System.Collections.Generic;
    using System.IO;

    public class StudentsAndCourses
    {
        public static void Main()
        {
            string path = "..\\..\\student.txt";
            var studentsByCourse = ReadTextFile(path);
            PrintStudentsAndCourses(studentsByCourse);
        }

        private static SortedDictionary<string, SortedSet<Person>> ReadTextFile(string path)
        {
            var studentsByCourse = new SortedDictionary<string, SortedSet<Person>>();

            using (var reader = new StreamReader(path))
            {
                string currLine = reader.ReadLine();
                while (currLine != null)
                {
                    var args = currLine.Split('|');
                    string firstName = args[0].Trim();
                    string lastName = args[1].Trim();
                    string course = args[2].Trim();
                    var newStudent = new Person(firstName, lastName);
                    if (!studentsByCourse.ContainsKey(course))
                    {
                        studentsByCourse.Add(course, new SortedSet<Person>());
                    }

                    studentsByCourse[course].Add(newStudent);

                    currLine = reader.ReadLine();
                }
            }

            return studentsByCourse;
        }

        private static void PrintStudentsAndCourses(SortedDictionary<string, SortedSet<Person>> studentsByCourse)
        {
            foreach (var course in studentsByCourse.Keys)
            {
                Console.WriteLine("{0}: {1}", course, string.Join(", ", studentsByCourse[course]));
            }
        }
    }
}
