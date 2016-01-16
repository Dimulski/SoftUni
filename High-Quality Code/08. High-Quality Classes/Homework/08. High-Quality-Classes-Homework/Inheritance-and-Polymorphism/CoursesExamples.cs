namespace InheritanceAndPolymorphism
{
    using System;
    using Courses;

    class CoursesExamples
    {
        static void Main()
        {
            LocalCourse localCourse = new LocalCourse("Databases", "Svetlin Nakov", "Open Source");
            Console.WriteLine(localCourse);

            localCourse.AddStudent("Peter");
            localCourse.AddStudent("Maria");
            Console.WriteLine(localCourse);

            localCourse.AddStudent("Milena");
            localCourse.AddStudent("Todor");
            Console.WriteLine(localCourse);

            OffsiteCourse offsiteCourse = new OffsiteCourse("PHP and WordPress Development", "Mario Peshev", "Plovdiv");
            offsiteCourse.AddStudent("Thomas");
            offsiteCourse.AddStudent("Ani");
            offsiteCourse.AddStudent("Steve");
            Console.WriteLine(offsiteCourse);
        }
    }
}