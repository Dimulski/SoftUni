using System;

public class ExamResult
{
    public ExamResult(int grade, int minGrade, int maxGrade, string comments)
    {
        if (grade < 0)
        {
            throw new ArgumentException("Grade cannot be negative!", "grade");
        }

        if (minGrade < 0)
        {
            throw new ArgumentException("MinGrade cannot be negative!", "minGrade");
        }

        if (maxGrade <= minGrade)
        {
            throw new ArgumentException("MaxGrade must be greater than Min Grade!", "maxGrade");
        }

        if (string.IsNullOrEmpty(comments))
        {
            throw new ArgumentNullException("Comments can no be null or empty!","comments");
        }

        this.Grade = grade;
        this.MinGrade = minGrade;
        this.MaxGrade = maxGrade;
        this.Comments = comments;
    }

    public int Grade { get; private set; }

    public int MinGrade { get; private set; }

    public int MaxGrade { get; private set; }

    public string Comments { get; private set; }
}
