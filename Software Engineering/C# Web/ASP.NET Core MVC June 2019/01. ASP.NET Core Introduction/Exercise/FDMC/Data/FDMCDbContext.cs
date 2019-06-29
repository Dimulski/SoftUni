using FDMC.Models;
using Microsoft.EntityFrameworkCore;

namespace FDMC.Data
{
    public class FDMCDbContext : DbContext
    {
        public DbSet<Cat> Cats { get; set; }

        public FDMCDbContext(DbContextOptions<FDMCDbContext> options) 
            : base(options)
        {
        }
    }
}
