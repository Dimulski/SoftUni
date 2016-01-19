namespace SolarSystem
{
    using System.Windows;

    /// <summary>
    /// The property holder.
    /// </summary>
    /// <typeparam name="TPropertyType">Property Type
    /// </typeparam>
    /// <typeparam name="THoldingType">Holding Type
    /// </typeparam>
    public class PropertyHolder<TPropertyType, THoldingType> where THoldingType : DependencyObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="PropertyHolder{TPropertyType,THoldingType}"/> class.
        /// </summary>
        /// <param name="name">
        /// The name.
        /// </param>
        /// <param name="defaultValue">
        /// The default value.
        /// </param>
        /// <param name="propertyChangedCallback">
        /// The property changed callback.
        /// </param>
        public PropertyHolder(string name, TPropertyType defaultValue, PropertyChangedCallback propertyChangedCallback)
        {
            this.Property =
                DependencyProperty.Register(
                    name,
                    typeof(TPropertyType),
                    typeof(THoldingType),
                    new PropertyMetadata(defaultValue, propertyChangedCallback));
        }

        /// <summary>
        /// Gets the property.
        /// </summary>
        public DependencyProperty Property { get; private set; }

        /// <summary>
        /// The get.
        /// </summary>
        /// <param name="obj">
        /// The object.
        /// </param>
        /// <returns>
        /// The <see cref="TPropertyType"/>.
        /// </returns>
        public TPropertyType Get(THoldingType obj)
        {
            return (TPropertyType)obj.GetValue(this.Property);
        }

        /// <summary>
        /// The set.
        /// </summary>
        /// <param name="obj">
        /// The object.
        /// </param>
        /// <param name="value">
        /// The value.
        /// </param>
        public void Set(THoldingType obj, TPropertyType value)
        {
            obj.SetValue(this.Property, value);
        }
    }
}