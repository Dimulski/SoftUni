namespace BangaloreUniversityLearningSystem.Models
{
    using System;
    using System.Collections.Generic;

    using BangaloreUniversityLearningSystem.Utilities;

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

            // BUG: Password length was set to 5
            if (password.Length < 6) 
            {
                string message = string.Format("The password must be at least 6 symbols long.");
                throw new ArgumentException(message);
            }

            string hashedPassword = HashUtilities.HashPassword(password);
            this.Password = hashedPassword;
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
}
