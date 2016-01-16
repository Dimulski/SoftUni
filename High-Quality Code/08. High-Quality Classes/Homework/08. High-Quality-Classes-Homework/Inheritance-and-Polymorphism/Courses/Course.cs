namespace InheritanceAndPolymorphism.Courses
{
    using System;
    using System.Collections.Generic;
    using System.Text;
    using Interfaces;

    public abstract class Course : ICourse
    {
        private readonly IList<string> students;

        private string courseName;

        private string teacherName;

        protected Course(string courseName, string teacherName)
        {
            this.CourseName = courseName;
            this.TeacherName = teacherName;
            this.students = new List<string>();
        }

        public string CourseName
        {
            get
            {
                return this.courseName;
            }
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentNullException(nameof(CourseName), "Course name can not be null or empty!");
                }
                this.courseName = value;
            }
        }

        public string TeacherName
        {
            get
            {
                return this.teacherName;
            }
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentNullException(nameof(TeacherName), "Teacher name can not be null or empty!");
                }
                this.teacherName = value;
            }
        }

        public IList<string> Students
        {
            get
            {
                return this.students;
            }
        }

        public void AddStudent(string studentName)
        {
            if (String.IsNullOrWhiteSpace(studentName))
            {
                throw new ArgumentNullException(nameof(studentName), "Students name can not be null or empty string!");
            }
            this.students.Add(studentName);
        }

        private string GetStudentsAsString()
        {
            if (this.Students == null || this.Students.Count == 0)
            {
                return "{Student list is empty!}";
            }
            return "{ " + string.Join(", ", this.Students) + " }";
        }

        public override string ToString()
        {
            StringBuilder course = new StringBuilder();
            course.AppendFormat("{0} {{ Name = {1}", this.GetType().Name, this.CourseName);
            course.AppendFormat("; Teacher = {0}", this.TeacherName);
            course.AppendFormat("; Students = {0}", this.GetStudentsAsString());
            course.Append(" }");

            return course.ToString();
        }
    }
}