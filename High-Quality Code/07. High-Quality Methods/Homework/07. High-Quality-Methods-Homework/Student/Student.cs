namespace Student
{
    using System;
    using System.Globalization;

    class Student
    {
        private string firstName;

        private string lastName;

        private DateTime birthDate;

        public Student(string firstName, string lastName, DateTime birthDate)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.BirthDate = birthDate;
        }

        public string FirstName
        {
            get
            {
                return this.firstName;
            }
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentNullException(nameof(FirstName), "First name can not be empty or null!");
                }
                this.firstName = value;
            }
        }

        public string LastName
        {
            get
            {
                return this.lastName;
            }
            private set
            {
                if (String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentNullException(nameof(LastName), "Last name can not be empty or null!");
                }
                this.lastName = value;
            }
        }

        public string FullName
        {
            get
            {
                return string.Format("{0} {1}", this.FirstName, this.LastName);
            }
        }

        public DateTime BirthDate
        {
            get
            {
                return this.birthDate;
            }
            private set
            {
                var minimalBirthDate = new DateTime(1940, 1, 1);
                if (value < minimalBirthDate || value > DateTime.Now)
                {
                    throw new ArgumentException(
                        string.Format(
                            "BirthDate must be in the range {0} - {1}",
                            minimalBirthDate.ToString(CultureInfo.InvariantCulture),
                            DateTime.Now.ToString(CultureInfo.InvariantCulture)));
                }
                this.birthDate = value;
            }
        }

        public bool CompareStudentsBirthDates(Student other)
        {
            bool isStudentOlder = this.BirthDate.CompareTo(other.BirthDate) < 0;
            return isStudentOlder;
        }

        public override string ToString()
        {
            return string.Format(
                "Name: {0}, Birth Date: [{1}.{2}.{3} year]",
                this.FullName,
                this.BirthDate.Day,
                this.BirthDate.Month,
                this.BirthDate.Year);
        }
    }
}