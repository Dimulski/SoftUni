namespace BangaloreUniversityLearningSystem.Infrastructure
{
    using System.Text;

    using BangaloreUniversityLearningSystem.Core.Interfaces;

    public abstract class View : IView
    {
        protected View(object model) // Converted this to protected from public.
        {
            this.Model = model;
        }

        public object Model { get; private set; }

        public string Display()
        {
            var viewResult = new StringBuilder();
            this.BuildViewResult(viewResult);
            return viewResult.ToString().Trim();
        }

        internal virtual void BuildViewResult(StringBuilder viewResult) // Abstract class - This remains empty!
        {
        }
    }
}