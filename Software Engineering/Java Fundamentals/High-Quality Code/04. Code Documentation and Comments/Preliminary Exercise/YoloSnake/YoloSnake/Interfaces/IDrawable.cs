namespace YoloSnake.Interfaces
{
    /// <summary>
    /// Implementations of this interface
    /// should draw using a certain drawer
    /// </summary>
    public interface IDrawable
    {
        /// <summary>
        /// Draws on a canvas using
        /// an implementation of a drawer
        /// </summary>
        /// <param name="drawer">
        /// Implementation of drawer
        /// to draw a point
        /// </param>
        void Draw(IDrawer drawer);
    }
}