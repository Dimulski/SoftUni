namespace InheritanceAndPolymorphism.Interfaces
{
    /// <summary>
    /// Inheritors of this interface are capable of creating Offsite Courses
    /// </summary>
    public interface IOffsiteCourse
    {
        /// <summary>
        /// Location of Offsite Course
        /// </summary>
        string Town { get; }
    }
}