using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LearningSystemTests
{
    using System.Collections.Generic;

    using BangaloreUniversityLearningSystem.Core.Interfaces;
    using BangaloreUniversityLearningSystem.Data;
    using BangaloreUniversityLearningSystem.Models;

    [TestClass]
    public class IRepositoryTests
    {
        private IRepository<User> users;

        [TestInitialize]
        public void InitializeRepository()
        {
            this.users = new Repository<User>();
        }

        [TestMethod]
        public void GetId_WhenValidId_ShouldReturnElement()
        {
            // Arrange
            var userList = new List<User>()
            {
                new User("Pesho", "1234567", Role.Lecturer),
                new User("Gosho", "YoluSnaketo", Role.Student)
            };

            foreach (User user in userList)
            {
                this.users.Add(user);
            }

            // Act
            const int Id = 1;
            var actualUser = this.users.Get(1);

            // Assert
            Assert.AreEqual(userList[Id - 1], actualUser);
        }

        [TestMethod]
        public void GetId_WhenInvalidId_ShouldReturnDefaultUser()
        {
            // Arrange
            var userList = new List<User>()
            {
                new User("Pesho", "1234567", Role.Lecturer),
                new User("Gosho", "YoluSnaketo", Role.Student)
            };

            foreach (User user in userList)
            {
                this.users.Add(user);
            }

            // Act
            int id = userList.Count + 1;
            var actualUser = this.users.Get(id);

            // Assert
            Assert.AreEqual(default(User), actualUser);
        }

        [TestMethod]
        public void GetId_WhenInvalidId_ShouldReturnElement()
        {
            var actualUser = this.users.Get(1);

            // Assert
            Assert.AreEqual(default(User), actualUser);
        }
    }
}
