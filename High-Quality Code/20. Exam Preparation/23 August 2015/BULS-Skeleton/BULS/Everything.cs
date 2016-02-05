namespace BangaloreUniversityLearningSystem
{
    using System;
    using System.Collections.Generic;

    using buls.utilities;

    public enum Role
    {
        Student,

        Lecturer
    }

    public class User
    {
        private string username;

        private string passwordHash;

        public User(string username, string password, Role role)
        {
            this.Username = username;
            if (username == null || username == string.Empty)
            {
                string message = string.Format("The username must be at least 5 symbols long.");
                throw new ArgumentException(message);
            }
            if (username.Length < 5)
            {
                string message = string.Format("The username must be at least 5 symbols long.");
                throw new ArgumentException(message);
            }
            this.Username = username;
            if (password == null || password == string.Empty)
            {
                string message = string.Format("The password must be at least 5 symbols long.");
                throw new ArgumentException(message);
            }
            if (password.Length < 6) // BUG: Off by one *shoots himself*
            {
                string message = string.Format("The password must be at least 6 symbols long."); 
                throw new ArgumentException(message);
            }
            string passwordHash = HashUtilities.HashPassword(password);
            this.Password = passwordHash;
            this.Role = role;
            this.Courses = new List<Course>();
        }

        public string Username
        {
            get
            {
                return this.username;
            }
            set
            {
                this.username = value;
            }
        }

        public string Password
        {
            get
            {
                return this.passwordHash;
            }
            set
            {
                this.passwordHash = value;
            }
        }

        public Role Role { get; private set; }

        public IList<Course> Courses { get; private set; }
    }

    public class Course
    {
        private string name;

        public Course(string name)
        {
            if (string.IsNullOrEmpty(name) || name.Length < 5)
            {
                string message = string.Format("The course name must be at least 5 symbols long.");
                throw new ArgumentException(message);
            }

            this.Name = name;
            this.Lectures = new List<Lecture>();
            this.Students = new List<User>();
        }

        public string Name
        {
            get
            {
                return this.name;
            }
            set
            {
                this.name = value;
            }
        }

        public IList<Lecture> Lectures { get; set; }

        public IList<User> Students { get; set; }

        public void AddLecture(Lecture lecture)
        {
            this.Lectures.Add(lecture);
        }

        public void AddStudent(User student)
        {
            this.Students.Add(student);
            student.Courses.Add(this);
        }
    }

    public class Lecture
    {
        private string name;

        public Lecture(string name)
        {
            this.Name = name; // BUG: Constructor called itself. so to say. 
        }

        public string Name
        {
            get
            {
                return this.name;
            }

            set
            {
                if (value == null || value.Length < 3)
                {
                    throw new ArgumentException(string.Format("The lecture name must be at least 3 symbols long."));
                }
                this.name = value;
            }
        }
    }
}
