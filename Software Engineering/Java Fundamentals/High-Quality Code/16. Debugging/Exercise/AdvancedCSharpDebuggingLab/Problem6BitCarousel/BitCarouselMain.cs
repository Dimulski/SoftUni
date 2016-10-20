namespace Problem6BitCarousel
{
    using System;

    public class BitCarouselMain
    {
        static void Main()
        {
            byte number = byte.Parse(Console.ReadLine());
            byte rotations = byte.Parse(Console.ReadLine());

            for (int i = 0; i < rotations; i++)
            {
                string direction = Console.ReadLine();

                if (direction == "right")
                {
                    int rightMostBit = number & 1;
                    number >>= 1;
                    number |= (byte)(rightMostBit << 5);
                }
                else if (direction == "left")
                {
                    int leftMostBit = (number >> 5) & 1;
                    number <<= 1;
                    number |= (byte)leftMostBit;
                    number = (byte)(number & 63);
                }
            }

            Console.WriteLine(number);
        }
    }
}
