namespace NinjectIoCContainer
{
    using System;
    using System.Reflection;

    using Ninject;
    using NinjectIoCContainer.Contracts;

    public class NinjectIoCExmaple
    {
        internal static void Main()
        {
            var kernel = new StandardKernel();
            kernel.Load(Assembly.GetExecutingAssembly());
            var data = kernel.Get<ICourseData>();
            Console.WriteLine(String.Join(", ", data.GetCourseNames()));
        }
    }
}
