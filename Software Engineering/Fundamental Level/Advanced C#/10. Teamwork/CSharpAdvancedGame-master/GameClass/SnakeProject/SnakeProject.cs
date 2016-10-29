using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Win32;
using System.IO;

namespace SnakeProject
{
    struct Point
    {
        public int x;
        public int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    class SnakeProject
    {
        static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.Green;
            Console.BufferHeight = Console.WindowHeight = 25;
            Console.BufferWidth = Console.WindowWidth = 50;

            int score = 0;
            int lastFoodTime = 0;
            int savedDirection = 10;
            Console.Title = "Snake";

            OpeningScreen();
            string type = Console.ReadLine();
            char nextFood = '1';
            Console.WriteLine();
            Console.WriteLine("Press Enter to choose a level!");
            Console.ReadLine();
            Console.Clear();

            Console.ForegroundColor = ConsoleColor.Cyan;
            Console.SetCursorPosition(0, 3);
            Console.WriteLine("Choose Level from 1 to 9 and press Enter!");
            Console.SetCursorPosition(0, 5);
            Console.WriteLine("(Leave blank for 1 level)");
            Console.SetCursorPosition(0, 7);
            Console.Write("Level : ");
            int level = 0;
            string levelAssigner = Console.ReadLine();
            level = GameLevel(levelAssigner);
            int foodDissapearTime = (4000 * 9) / (level * 3 / 2 + 1);

            Console.SetCursorPosition(0, 9);
            Console.WriteLine("Press Enter to see the Instructions!");
            Console.ReadLine();
            Console.Clear();

            Console.ForegroundColor = ConsoleColor.Red;
            Instructions();
            Console.ReadLine();
            Console.CursorVisible = false;

            Console.ForegroundColor = ConsoleColor.Yellow;

            Random randomGenerator = new Random();
            int randomSnake = randomGenerator.Next(0, 4);


            Point[] directions = new Point[]
            {
                new Point(1, 0), // goingDown
                new Point(-1, 0), // goingUp
                new Point(0, 1), // goingRight
                new Point(0, -1) // goingLeft
            };

            int direction = 2; // holds the direction which the snake is moving

            Queue<Point> snakeBody = new Queue<Point>();
            for (int i = 0; i < 5; i++)
            {
                snakeBody.Enqueue(new Point(0, i));
            }
            foreach (Point position in snakeBody)
            {
                Console.SetCursorPosition(position.y, position.x);
                Console.Write(SnakeType(type, randomSnake));
            }

            Point food = new Point(randomGenerator.Next(0, Console.WindowHeight),
                randomGenerator.Next(0, Console.WindowWidth));
            lastFoodTime = Environment.TickCount;
            while (snakeBody.Contains(food)) 
            {
                food = new Point(randomGenerator.Next(0, Console.WindowHeight),
                randomGenerator.Next(0, Console.WindowWidth));
            }
            Console.SetCursorPosition(food.y, food.x);
            Console.Write(nextFood);

            while (true)
            {

                if (Console.KeyAvailable)
                {
                    ConsoleKeyInfo Input = Console.ReadKey();
                    if (Input.Key == ConsoleKey.S || Input.Key == ConsoleKey.DownArrow)
                    {
                        if (direction != 1 && savedDirection != 1)
                        {
                            direction = 0;
                        }
                    }
                    if (Input.Key == ConsoleKey.A || Input.Key == ConsoleKey.LeftArrow)
                    {
                        if (direction != 2 && savedDirection != 2)
                        {
                            direction = 3;
                        }
                    }
                    if (Input.Key == ConsoleKey.W || Input.Key == ConsoleKey.UpArrow)
                    {
                        if (direction != 0 && savedDirection != 0)
                        {
                            direction = 1;
                        }
                    }
                    if (Input.Key == ConsoleKey.D || Input.Key == ConsoleKey.RightArrow)
                    {
                        if (direction != 3 && savedDirection != 3)
                        {
                            direction = 2;
                        }
                    }
                    if (Input.Key == ConsoleKey.Spacebar)
                    {
                        savedDirection = direction;
                        direction = 5;
                        Console.SetCursorPosition(20, 11);
                        Console.WriteLine("PAUSE !");
                    }
                }
                if (direction != 5)
                {
                    savedDirection = 10;
                    Point head = snakeBody.Last();
                    Point newDirection = directions[direction];
                    Point newHeadPosition = new Point(head.x + newDirection.x, head.y + newDirection.y);

                    if (newHeadPosition.y < 0) newHeadPosition.y = Console.WindowWidth - 1;
                    if (newHeadPosition.x < 0) newHeadPosition.x = Console.WindowHeight - 1;
                    if (newHeadPosition.x >= Console.WindowHeight) newHeadPosition.x = 0;
                    if (newHeadPosition.y >= Console.WindowWidth) newHeadPosition.y = 0;


                    if (snakeBody.Contains(newHeadPosition))
                    {
                        EndGameResults(score);
                        return;
                    }

                    Console.SetCursorPosition(head.y, head.x);

                    snakeBody.Enqueue(newHeadPosition);

                    Console.SetCursorPosition(newHeadPosition.y, newHeadPosition.x);

                    char[] foodHolder = new char[]
                    {
                        '1', '2', '3', '4', '5', '6', '7', '8', '9', '$', 'Y', 'W', 'B', 'G', 'R', 'D'
                        // here you can add random bonuses and stuff
                    };


                    if (newHeadPosition.x == food.x && newHeadPosition.y == food.y)
                    {
                        if (nextFood == 'Y')
                        {
                            Console.ForegroundColor = ConsoleColor.Yellow;
                        }
                        else if (nextFood == 'W')
                        {
                            Console.ForegroundColor = ConsoleColor.White;
                        }
                        else if (nextFood == 'B')
                        {
                            Console.ForegroundColor = ConsoleColor.Blue;
                        }
                        else if (nextFood == 'G')
                        {
                            Console.ForegroundColor = ConsoleColor.DarkGray;
                        }
                        else if (nextFood == 'R')
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                        }
                        else if (nextFood == 'D')
                        {
                            Console.ForegroundColor = ConsoleColor.DarkGreen;
                        }
                        food = new Point(randomGenerator.Next(1, Console.WindowHeight - 1),
                            randomGenerator.Next(1, Console.WindowWidth - 1));
                        score = Score(nextFood, score);
                        while (snakeBody.Contains(food))
                        {
                            food = new Point(randomGenerator.Next(0, Console.WindowHeight),
                            randomGenerator.Next(0, Console.WindowWidth));
                        }
                        lastFoodTime = Environment.TickCount;
                        nextFood = foodHolder[randomGenerator.Next(0, foodHolder.Length)];
                    }
                    else
                    {
                        snakeBody.Dequeue();
                    }

                    Console.Clear();

                    foreach (Point position in snakeBody)
                    {
                        Console.SetCursorPosition(position.y, position.x);
                        Console.Write(SnakeType(type, randomSnake));
                    }
                    if (Environment.TickCount - lastFoodTime >= foodDissapearTime)
                    {
                        Console.SetCursorPosition(food.y, food.x);
                        Console.Write(" ");
                        do
                        {
                            food = new Point(randomGenerator.Next(0, Console.WindowHeight),
                                randomGenerator.Next(0, Console.WindowWidth));
                        } while (snakeBody.Contains(food));
                        lastFoodTime = Environment.TickCount;
                    }

                    Console.SetCursorPosition(food.y, food.x);
                    Console.Write(nextFood);
                    Console.Title = "Snake - Score: " + score;

                    Thread.Sleep(150 - level * 12);

                }
            }
        }

        public static void EndGameResults(int score)
        {
            StringBuilder builder = new StringBuilder();
            int counter = 0;

            Dictionary<string, int> topTenHighScore = new Dictionary<string, int>();
            var array = File.ReadAllLines("highscores2.txt");

            for (var i = 0; i < array.Length; i += 2)
            {
                topTenHighScore.Add(array[i + 1], int.Parse(array[i]));
            }
            var items = from pair in topTenHighScore orderby pair.Value descending select pair;

            Console.Clear();
            Console.SetCursorPosition(13, 3);
            Console.WriteLine("Sorry Dude, GAME OVER!");
            if (score > topTenHighScore.Values.Max())
            {
                Console.SetCursorPosition(17, 5);
                Console.WriteLine("New High Score!");
                Console.SetCursorPosition(13, 7);
                Console.Write("Enter your name: ");
                string playerName = Console.ReadLine();
                while (topTenHighScore.ContainsKey(playerName))
                {
                    Console.SetCursorPosition(13, 9);
                    Console.WriteLine("Was your previous best: {0} ?", topTenHighScore.Values.Max());
                    Console.SetCursorPosition(21, 11);
                    Console.Write("Y / N :  ");
                    string yesNo = Console.ReadLine();
                    switch (yesNo)
                    {
                        case "":
                        case "Y":
                        case "y":
                        case "Yes":
                        case "yes":
                        case "YES":
                            Console.Clear();
                            topTenHighScore[playerName] = score;
                            Console.SetCursorPosition(12, 1);
                            Console.WriteLine("HIGH SCORES");
                            foreach (var item in items)
                            {
                                Console.SetCursorPosition(4, 3 + counter);
                                if (counter == 10)
                                {
                                    break;
                                }
                                counter++;
                                Console.WriteLine("{0}. {1}{2}{3}{4}", counter, new string(' ', 2 - counter.ToString().Length), item.Key, new string(' ', 20 - item.Key.Length), item.Value);
                                builder.Append(item.Value + Environment.NewLine + item.Key + Environment.NewLine);
                            }
                            File.WriteAllText("highscores2.txt", builder.ToString());
                            builder.Clear();
                            return;
                        case "N":
                        case "n":
                        case "No":
                        case "no":
                        case "NO":
                            Console.SetCursorPosition(13, 12);
                            Console.Write("Choose another name: ");
                            playerName = Console.ReadLine();
                            break;
                    }
                }
                topTenHighScore.Add(playerName, score);
                counter = 0;
                Console.Clear();
                Console.SetCursorPosition(12, 1);
                Console.WriteLine("HIGH SCORES");
                foreach (var item in items)
                {
                    Console.SetCursorPosition(4, 3 + counter);
                    if (counter == 10)
                    {
                        break;
                    }
                    counter++;
                    Console.WriteLine("{0}. {1}{2}{3}{4}", counter, new string(' ', 2 - counter.ToString().Length), item.Key, new string(' ', 20 - item.Key.Length), item.Value);
                    builder.Append(item.Value + Environment.NewLine + item.Key + Environment.NewLine);
                }
                File.WriteAllText("highscores2.txt", builder.ToString());
                builder.Clear();
            }

            else if (score <= topTenHighScore.Values.Max())
            {
                Console.SetCursorPosition(13, 5);
                Console.Write("Enter your name: ");
                string playerName = Console.ReadLine();
                while (topTenHighScore.ContainsKey(playerName))
                {
                    Console.SetCursorPosition(13, 7);
                    Console.WriteLine("Was your previous best: {0} ?", topTenHighScore[playerName]);
                    Console.SetCursorPosition(21, 9);
                    Console.Write("Y / N :  ");
                    string yesNo = Console.ReadLine();
                    switch (yesNo)
                    {
                        case "":
                        case "Y":
                        case "y":
                        case "Yes":
                        case "yes":
                        case "YES":
                            topTenHighScore[playerName] = Math.Max(score, topTenHighScore[playerName]);
                            counter = 0;
                            Console.Clear();
                            Console.SetCursorPosition(12, 1);
                            Console.WriteLine("HIGH SCORES");
                            foreach (var item in items)
                            {
                                Console.SetCursorPosition(4, 3 + counter);
                                if (counter == 10)
                                {
                                    break;
                                }
                                counter++;
                                Console.WriteLine("{0}. {1}{2}{3}{4}", counter, new string(' ', 2 - counter.ToString().Length), item.Key, new string(' ', 20 - item.Key.Length), item.Value);
                                builder.Append(item.Value + Environment.NewLine + item.Key + Environment.NewLine);
                            }
                            File.WriteAllText("highscores2.txt", builder.ToString());
                            builder.Clear();
                            return;
                        case "N":
                        case "n":
                        case "No":
                        case "no":
                        case "NO":
                            Console.SetCursorPosition(13, 12);
                            Console.Write("Choose another name: ");
                            playerName = Console.ReadLine();
                            break;
                    }
                }
                topTenHighScore.Add(playerName, score);
                counter = 0;
                Console.Clear();
                Console.SetCursorPosition(12, 1);
                Console.WriteLine("HIGH SCORES");
                foreach (var item in items)
                {
                    Console.SetCursorPosition(4, 3 + counter);
                    if (counter == 10)
                    {
                        break;
                    }
                    counter++;
                    Console.WriteLine("{0}. {1}{2}{3}{4}", counter, new string(' ', 2 - counter.ToString().Length), item.Key, new string(' ', 20 - item.Key.Length), item.Value);
                    builder.Append(item.Value + Environment.NewLine + item.Key + Environment.NewLine);
                }
                File.WriteAllText("highscores2.txt", builder.ToString());
                builder.Clear();
            }
        }

        private static void OpeningScreen()
        {
            Console.SetCursorPosition(9, 2);
            Console.WriteLine("Welcome to Snake Game !");
            Console.WriteLine();
            Console.WriteLine("Choose a snake type: \r\n");
            Console.WriteLine("Press 1 for: OOOOO");
            Console.WriteLine("Press 2 for: *****");
            Console.WriteLine("Press 3 for: #####");
            Console.WriteLine("Press 4 for: @@@@@");
            Console.WriteLine();
            Console.WriteLine("(Leave blank for a random snake body)\r\n");
            Console.Write("Press :  ");
        }

        public static char[] bodyHolder = new char[]
                {
                    'O', '*', '#', '@'
                };

        public static char SnakeType(string type, int random)
        {
            char snake = ' ';

            switch (type)
            {
                case "1":
                    snake = bodyHolder[0];
                    break;
                case "2":
                    snake = bodyHolder[1];
                    break;
                case "3":
                    snake = bodyHolder[2];
                    break;
                case "4":
                    snake = bodyHolder[3];
                    break;
                default:
                    snake = bodyHolder[random];
                    break;
            }
            return snake;
        }

        public static void Instructions()
        {
            Console.SetCursorPosition(0, 1);
            Console.WriteLine("Instructions");
            Console.WriteLine();
            Console.WriteLine("Move Up = \"W\" or \"Up Arrow\"\r\nMove Down = \"S\" or \"Down Arrow\"\r\n" +
                              "Move Left = \"A\" or \"Left Arrow\"\r\nMove Right = \"D\" or \"Right Arrow\"\r\n" +
                              "PAUSE = \"Space\"\r\n");
            Console.WriteLine("Numbers Increase score.\r\n");
            Console.WriteLine("Special Food: \r\n\"B\" = Blue Snake\r\n\"W\" = White Snake\r\n\"R\" = Red Snake" +
                              "\r\n\"G\" = Dark Grey Snake\r\n\"D\" = Dark Green Snake\r\n\"Y\" = Yellow Snake\r\n");
            Console.WriteLine("Good Luck ! :)\r\n");
            Console.WriteLine("Press Enter to begin the game !");
        }

        static int Score(char nextFood, int score)
        {
            switch (nextFood)
            {
                case '1':
                    score += 1;
                    break;
                case '2':
                    score += 2;
                    break;
                case '3':
                    score += 3;
                    break;
                case '4':
                    score += 4;
                    break;
                case '5':
                    score += 5;
                    break;
                case '6':
                    score += 6;
                    break;
                case '7':
                    score += 7;
                    break;
                case '8':
                    score += 8;
                    break;
                case '9':
                    score += 9;
                    break;
                case 'B':
                    score += 10;
                    break;
                case 'W':
                    score += 10;
                    break;
                case 'R':
                    score += 10;
                    break;
                case 'G':
                    score += 10;
                    break;
                case 'Y':
                    score += 10;
                    break;
                case 'D':
                    score += 10;
                    break;
                case '$':
                    score += 25;
                    break;
            }
            return score;
        }

        public static int GameLevel(string levelAssigner)
        {
            int level = 0;
            if (int.TryParse(levelAssigner, out level))
            {
                if (level <= 9 && level > 0)
                {
                    level = Convert.ToInt32(levelAssigner);
                }
                else
                {
                    level = 0;
                }
            }
            else
            {
                level = 0;
            }
            return level;
        }
    }
}
