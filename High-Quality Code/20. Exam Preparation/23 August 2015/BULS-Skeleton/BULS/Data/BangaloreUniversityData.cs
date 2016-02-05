namespace BangaloreUniversityLearningSystem.Data
{
    using BangaloreUniversityLearningSystem.Interfaces;

    using buls.Data;

    public class BangaloreUniversityData : IBangaloreUniversityData
    {
        public BangaloreUniversityData()
        {
            this.Users = new UsersRepository();
            this.Courses = new Repository<Course>();
        }

        public UsersRepository Users { get; internal set; }

        public IRepository<Course> Courses { get; protected set; }
    }
}
