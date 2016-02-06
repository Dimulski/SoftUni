namespace BangaloreUniversityLearningSystem.Views.Courses
{
    using System.Text;

    using BangaloreUniversityLearningSystem.Infrastructure;
    using BangaloreUniversityLearningSystem.Models;

    public class Create : View // BUG: Create was improperly named
    {
        public Create(Course course)
            : base(course)
        {
        }

        internal override void BuildViewResult(StringBuilder viewResult)
        {
            var course = this.Model as Course;
            viewResult.AppendFormat("Course {0} created successfully.", course.Name).AppendLine();
        }
    }
}
