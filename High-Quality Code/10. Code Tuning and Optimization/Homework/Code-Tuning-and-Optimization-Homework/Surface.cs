namespace SolarSystem
{
    using System.Windows;
    using System.Windows.Media.Media3D;

    /// <summary>
    /// The surface.
    /// </summary>
    public abstract class Surface : ModelVisual3D
    {
        /// <summary>
        /// The material property.
        /// </summary>
        private static readonly PropertyHolder<Material, Surface> MaterialProperty =
            new PropertyHolder<Material, Surface>("Material", null, OnMaterialChanged);

        /// <summary>
        /// The back material property.
        /// </summary>
        private static readonly PropertyHolder<Material, Surface> BackMaterialProperty =
            new PropertyHolder<Material, Surface>("BackMaterial", null, OnBackMaterialChanged);

        /// <summary>
        /// The visible property.
        /// </summary>
        private static readonly PropertyHolder<bool, Surface> VisibleProperty =
            new PropertyHolder<bool, Surface>("Visible", true, OnVisibleChanged);

        /// <summary>
        /// The _content.
        /// </summary>
        private readonly GeometryModel3D content = new GeometryModel3D();

        /// <summary>
        /// Initializes a new instance of the <see cref="Surface"/> class.
        /// </summary>
        protected Surface()
        {
            this.Content = this.content;
            this.content.Geometry = this.CreateMesh();
        }

        /// <summary>
        /// Gets or sets the material.
        /// </summary>
        public Material Material
        {
            get
            {
                return MaterialProperty.Get(this);
            }

            set
            {
                MaterialProperty.Set(this, value);
            }
        }

        /// <summary>
        /// Gets or sets the back material.
        /// </summary>
        public Material BackMaterial
        {
            get
            {
                return BackMaterialProperty.Get(this);
            }

            set
            {
                BackMaterialProperty.Set(this, value);
            }
        }

        /// <summary>
        /// Gets or sets a value indicating whether visible.
        /// </summary>
        public bool Visible
        {
            get
            {
                return VisibleProperty.Get(this);
            }

            set
            {
                VisibleProperty.Set(this, value);
            }
        }

        /// <summary>
        /// The on geometry changed.
        /// </summary>
        /// <param name="sender">
        /// The sender.
        /// </param>
        /// <param name="e">
        /// The e.
        /// </param>
        protected static void OnGeometryChanged(object sender, DependencyPropertyChangedEventArgs e)
        {
            ((Surface)sender).OnGeometryChanged();
        }

        /// <summary>
        /// The create mesh.
        /// </summary>
        /// <returns>
        /// The <see cref="Geometry3D"/>.
        /// </returns>
        protected abstract Geometry3D CreateMesh();

        /// <summary>
        /// The on material changed.
        /// </summary>
        /// <param name="sender">
        /// The sender.
        /// </param>
        /// <param name="e">
        /// The e.
        /// </param>
        private static void OnMaterialChanged(object sender, DependencyPropertyChangedEventArgs e)
        {
            ((Surface)sender).OnMaterialChanged();
        }

        /// <summary>
        /// The on back material changed.
        /// </summary>
        /// <param name="sender">
        /// The sender.
        /// </param>
        /// <param name="e">
        /// The e.
        /// </param>
        private static void OnBackMaterialChanged(object sender, DependencyPropertyChangedEventArgs e)
        {
            ((Surface)sender).OnBackMaterialChanged();
        }

        /// <summary>
        /// The on visible changed.
        /// </summary>
        /// <param name="sender">
        /// The sender.
        /// </param>
        /// <param name="e">
        /// The e.
        /// </param>
        private static void OnVisibleChanged(object sender, DependencyPropertyChangedEventArgs e)
        {
            ((Surface)sender).OnVisibleChanged();
        }

        /// <summary>
        /// The on material changed.
        /// </summary>
        private void OnMaterialChanged()
        {
            this.SetContentMaterial();
        }

        /// <summary>
        /// The on back material changed.
        /// </summary>
        private void OnBackMaterialChanged()
        {
            this.SetContentBackMaterial();
        }

        /// <summary>
        /// The on visible changed.
        /// </summary>
        private void OnVisibleChanged()
        {
            this.SetContentMaterial();
            this.SetContentBackMaterial();
        }

        /// <summary>
        /// The set content material.
        /// </summary>
        private void SetContentMaterial()
        {
            this.content.Material = this.Visible ? this.Material : null;
        }

        /// <summary>
        /// The set content back material.
        /// </summary>
        private void SetContentBackMaterial()
        {
            this.content.BackMaterial = this.Visible ? this.BackMaterial : null;
        }

        /// <summary>
        /// The on geometry changed.
        /// </summary>
        private void OnGeometryChanged()
        {
            this.content.Geometry = this.CreateMesh();
        }
    }
}