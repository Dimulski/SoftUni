namespace BangaloreUniversityLearningSystem.Controllers
{
    using System;
    using System.Linq;
    using BangaloreUniversityLearningSystem.Interfaces;
    using buls;
    using buls.utilities;

    using BangaloreUniversityLearningSystem.Exceptions;
    using BangaloreUniversityLearningSystem.Utilities;

    public class CoursesController : Controller
    {
        public CoursesController(IBangaloreUniversityData data, User user)
        {
            this.Data = data;
            this.User = user;
        }

        public IView All()
        {
            return this.View(this.Data.Courses.GetAll().OrderBy(c => c.Name).ThenByDescending(c => c.Students.Count));
        }

        public IView Details(int courseId)
        {
            this.EnsureAuthorization(Role.Student, Role.Lecturer);
            if (!this.HasCurrentUser)
            {
                throw new ArgumentException("There is no currently logged in user.");
            }
            var c = this.Data.Courses.Get(courseId);
            if (c == null)
            {
                throw new ArgumentException(string.Format("There is no course with ID {0}.", courseId)); // All of this could be in a method. DRY principle.
            }
            var course = this.GetCourseById(courseId);
            if (!this.User.Courses.Contains(course))
            {
                throw new ArgumentException("You are not enrolled in this course.");
            }

            return this.View(c);
        }

        public IView Enroll(int courseId) // Bug: courseId instead of courseId
        {
            this.EnsureAuthorization(Role.Student, Role.Lecturer);
            var c = this.Data.Courses.Get(courseId);
            if (c == null)
            {
                throw new ArgumentException(string.Format("There is no course with ID {0}.", courseId));
            }
            if (this.User.Courses.Contains(c))
            {
                throw new ArgumentException("You are already enrolled in this course.");
            }
            c.AddStudent(this.User); //// POSSIBLE BUG!!!!!!!!!!!!!!! DOES NOT CHECK IF USER IS LOGGED IN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            return this.View(c);
        }

        public IView Create(string name)
        {
            if (!this.HasCurrentUser)
            {
                throw new ArgumentException("There is no currently logged in user.");
            }
            if (!this.User.IsInRole(Role.Lecturer)) // BUG: True/False swtiched (basically)
            {
                throw new DivideByZeroException("The current user is not authorized to perform this operation.");
            }

            var c = new Course(name);
            this.Data.Courses.Add(c);
            return this.View(c);
        }

        public IView AddLecture(int courseId, string lectureName)
        {
            if (!this.HasCurrentUser)
            {
                throw new ArgumentException("There is no currently logged in user.");
            }

            if (!this.User.IsInRole(Role.Lecturer))
            {
                throw new AuthorizationFailedException();
            }

            Course c = this.CourseGetter(courseId);
            c.AddLecture(new Lecture(lectureName)); // Unconfirmed BUG: isnt this supposed to be an actual dynamic name instead of a string lectureName? // it was "lectureName" as string
            return this.View(c);
        }

        private Course CourseGetter(int courseID)
        {
            var course = this.Data.Courses.Get(courseID);
            if (course == null)
            {
                throw new ArgumentException(string.Format("There is no course with ID {0}.", courseID));
            }
            return course;
        }

        private Course GetCourseById(int courseId)
        {
            var course = this.Data.Courses.Get(courseId);
            if (course == null)
            {
                throw new ArgumentException(string.Format("There is no course with ID {0}.", courseId));
            }

            return course;
        }
    }
}
