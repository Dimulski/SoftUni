namespace BangaloreUniversityLearningSystem.Core.Interfaces
{
    using System.Collections.Generic;

    /// <summary>
    /// Serves to store objects in a collection and adds basic functionality for their manipulation
    /// </summary>
    /// <typeparam name="T"></typeparam>
    public interface IRepository<T>
    {
        /// <summary>
        /// Returns all the elements in the collection
        /// </summary>
        /// <returns>
        /// An IEnumerable collection of all the elements in the repository
        /// </returns>
        IEnumerable<T> GetAll();

        /// <summary>
        /// Gets an item by it's id
        /// </summary>
        /// <param name="id"></param>
        /// <returns>
        /// T element from the collection, corresponding to the element's id
        /// </returns>
        T Get(int id);

        /// <summary>
        /// Adds an element to the collection
        /// </summary>
        /// <param name="item"></param>
        void Add(T item);
    }
}
