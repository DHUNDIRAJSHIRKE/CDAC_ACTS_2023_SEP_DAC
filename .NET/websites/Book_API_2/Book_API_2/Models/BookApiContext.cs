using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace Book_API_2.Models;

public partial class BookApiContext : DbContext
{
    public BookApiContext()
    {
    }

    public BookApiContext(DbContextOptions<BookApiContext> options)
        : base(options)
    {
    }

    public virtual DbSet<TblBook> TblBooks { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Book_API;Integrated Security=True");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<TblBook>(entity =>
        {
            entity.HasKey(e => e.BookId).HasName("PK__tbl_book__3DE0C22723EA0ABC");

            entity.ToTable("tbl_books");

            entity.Property(e => e.BookId).HasColumnName("BookID");
            entity.Property(e => e.BookAuthor)
                .HasMaxLength(20)
                .IsUnicode(false);
            entity.Property(e => e.BookName)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.BookPrice).HasColumnType("decimal(18, 2)");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
