namespace AvlTreeTests
{
    using System.Linq;

    public static class TestUtils
    {
        public static int[] ToIntArrayUnique(string input)
        {
            return input.Split(' ')
                .Select(int.Parse)
                .Distinct()
                .ToArray();
        }
    }
}
