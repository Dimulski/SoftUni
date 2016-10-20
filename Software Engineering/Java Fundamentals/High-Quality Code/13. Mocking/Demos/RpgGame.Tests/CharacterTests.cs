namespace RpgGame.Tests
{
    using System.Collections.Generic;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class CharacterTests
    {
        [TestMethod]
        public void Character_Should_Drop_First_Item()
        {
            // Arrange
            var possibleItemDrops = new List<Item>
            {
                new Item("Axe", 25, 5),
                new Item("Shield", 5, 50),
                new Item("Resilience Potion", 0, 30)
            };

            // Act
            var character = new Character(possibleItemDrops);


            // Assert
            for (int i = 0; i < 1000; i++)
            {
                var item = character.DropItem();
                Assert.AreEqual("Axe", item.Name);
            }
        }
    }
}
