namespace InheritanceAndPolymorphism.Interfaces
{
    using System.Collections.Generic;

    /// <summary>
    /// Inheritors of this interface are capable of creating Courses
    /// </summary>
    public interface ICourse
    {
        /// <summary>
        /// Course name
        /// </summary>
        string CourseName { get; }

        /// <summary>
        /// Teacher name for given course
        /// </summary>
        string TeacherName { get; }

        /// <summary>
        /// collection of students
        /// </summary>
        IList<string> Students { get; }

        /// <summary>
        /// Method that add students in course
        /// </summary>
        /// <param name="studentName">students name</param>
        void AddStudent(string studentName);
    }
}