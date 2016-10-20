namespace InheritanceAndPolymorphism.Courses
{
    using System;
    using System.Text;
    using Interfaces;

    public class LocalCourse : Course, ILocalCourse
    {
        private string lab;

        public LocalCourse(string courseName, string teacherName, string lab)
            : base(courseName, teacherName)
        {
            this.Lab = lab;
        }

        public string Lab
        {
            get { return this.lab; }
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentNullException(nameof(this.lab), "Lab name can not be null or empty space!");
                }
                this.lab = value;
            }
        }

        public override string ToString()
        {
            StringBuilder localCourse = new StringBuilder(base.ToString());
            localCourse.Length -= 2;
            localCourse.AppendFormat("; Lab = {0}", this.Lab);
            localCourse.Append(" }");

            return localCourse.ToString();
        }
    }
}