﻿namespace BangaloreUniversityLearningSystem.Models
{
    using System;

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
