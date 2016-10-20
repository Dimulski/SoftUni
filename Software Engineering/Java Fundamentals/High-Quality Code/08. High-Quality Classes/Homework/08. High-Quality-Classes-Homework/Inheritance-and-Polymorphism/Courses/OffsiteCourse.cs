namespace InheritanceAndPolymorphism.Courses
{
    using System;
    using System.Text;
    using Interfaces;

    public class OffsiteCourse : Course, IOffsiteCourse
    {
        private string town;

        public OffsiteCourse(string courseName, string teacherName, string town)
            : base(courseName, teacherName)
        {
            this.Town = town;
        }

        public string Town
        {
            get { return this.town; }
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentNullException(nameof(this.town), "Town name can not be null or empty space!");
                }
                this.town = value;
            }
        }

        public override string ToString()
        {
            StringBuilder offsiteCourse = new StringBuilder(base.ToString());
            offsiteCourse.Length -= 2;
            offsiteCourse.AppendFormat("; Town = {0}", this.Town);
            offsiteCourse.Append(" }");

            return offsiteCourse.ToString();
        }
    }
}