namespace BangaloreUniversityLearningSystem.Views.Users
{
    using System.Text;

    using Infrastructure;
    using Models;

    public class Register : View
    {
        public Register(User user)
            : base(user)
        {
        }

        internal override void BuildViewResult(StringBuilder viewResult)
        {
            viewResult.AppendFormat("User {0} registered successfully.", (this.Model as User).Username).AppendLine();
        }
    }
}
