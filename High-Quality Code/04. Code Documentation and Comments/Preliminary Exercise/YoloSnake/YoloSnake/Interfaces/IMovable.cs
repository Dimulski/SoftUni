namespace YoloSnake.Interfaces
{
    using Enums;

    public interface IMovable
    {
        /// <summary>
        /// Returns current direction of movement
        /// </summary>
        Direction Direction { get; }

        void Move();

        /// <summary>
        /// Changes the current
        /// direction to a given one
        /// </summary>
        /// <param name="newDirection">
        /// The direction
        /// where we have to change to
        /// </param>
        /// <see cref="YoloSnake.Enums.Direction"/>
        void ChangeDirection(Direction newDirection);
    }
}