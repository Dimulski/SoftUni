namespace BangaloreUniversityLearningSystem.Interfaces
{
    using buls.Data;

    public interface IBangaloreUniversityData
    {
        UsersRepository Users { get; }

        IRepository<Course> Courses { get; }
    }
}
