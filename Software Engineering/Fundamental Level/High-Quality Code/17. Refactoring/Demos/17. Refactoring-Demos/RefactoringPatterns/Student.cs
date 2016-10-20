namespace RefactoringPatterns
{
    public enum StudentType
    {
        Online, Onsite
    }

    public class Student
    {
        public Student(StudentType type)
        {
            this.Type = type;
        }

        public StudentType Type { get; set; }
    }
}
