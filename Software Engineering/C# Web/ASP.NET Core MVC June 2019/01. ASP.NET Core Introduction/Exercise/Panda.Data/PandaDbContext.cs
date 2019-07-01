using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using Panda.Domain;
using System;

namespace Panda.Data
{
    public class PandaDbContext : IdentityDbContext<PandaUser>
    {
        public PandaDbContext(DbContextOptions<PandaDbContext> options) : base(options)
        {

        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<PandaUser>()
                .HasKey(user => user.Id);

            builder.Entity<PandaUser>()
                .HasMany(user => user.Packages)
                .WithOne(package => package.Recipient)
                .HasForeignKey(package => package.RecipientId);

            builder.Entity<PandaUser>()
                .HasMany(user => user.Receipts)
                .WithOne(receipt => receipt.Recipient)
                .HasForeignKey(receipt => receipt.RecipientId);

            builder.Entity<Receipt>()
                .HasOne(receipt => receipt.Package)
                .WithOne()
                .OnDelete(DeleteBehavior.Restrict);

            base.OnModelCreating(builder);
        }
    }
}
