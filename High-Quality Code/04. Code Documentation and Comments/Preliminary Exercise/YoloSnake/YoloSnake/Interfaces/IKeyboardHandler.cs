namespace YoloSnake.Interfaces
{
    using System;

    /// <summary>
    /// Handling input from the keyboard
    /// </summary>
    public interface IKeyboardHandler
    {
        /// <summary>
        /// Returns the last pressed key
        /// </summary>
        ConsoleKey PressedKey { get; }

        /// <summary>
        /// Returns whether any key is pressed
        /// </summary>
        bool IsKeyAvailable { get; }
    }
}