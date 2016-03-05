namespace Problem9SequenceNToM
{
    public class Item
    {
        public Item(int value, Item previousItem)
        {
            this.Value = value;
            this.PreviousItem = previousItem;
        }

        public int Value { get; set; }

        public Item PreviousItem { get; set; }
    }
}
