namespace BangaloreUniversityLearningSystem.Views.Courses
{
    using System.Text;

    using BangaloreUniversityLearningSystem.Infrastructure;
    using BangaloreUniversityLearningSystem.Models;

    public class AddLecture : View // BUG: AddLecture Instead of AddLecture
    {
        public AddLecture(Course course)
            : base(course)
        {
        }

        internal override void BuildViewResult(StringBuilder viewResult)
        {
            var course = this.Model as Course;
            viewResult.AppendFormat("Lecture successfully added to course {0}.", course.Name).AppendLine();
        }
    }
}
