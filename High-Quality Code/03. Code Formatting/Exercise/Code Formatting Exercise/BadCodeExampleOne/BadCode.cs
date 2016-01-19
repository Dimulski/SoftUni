﻿// Exercise Assignement, http://govnokod.ru/17926

using System;

namespace BadCodeExampleOne
{
    class BadCode
    {
        private BaseApplicationTableControl Parent;

        protected virtual string GetParentTableControlID()
        {
            try
            {
                if (this.Parent is BaseApplicationTableControl) return this.Parent.ID;
                if (this.Parent.Parent is BaseApplicationTableControl) return this.Parent.Parent.ID;
                if (this.Parent.Parent.Parent is BaseApplicationTableControl) return this.Parent.Parent.Parent.ID;
                if (this.Parent.Parent.Parent.Parent is BaseApplicationTableControl) return this.Parent.Parent.Parent.Parent.ID;
            }
            catch (Exception)
            {
            }
            return "";
        }

        private class BaseApplicationTableControl // Dummy implementation
        {
            public BaseApplicationTableControl Parent { get; internal set; }
            public string ID { get; set; }
        }
    }
}