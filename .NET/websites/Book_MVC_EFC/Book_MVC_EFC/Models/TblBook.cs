using System;
using System.Collections.Generic;

namespace Book_MVC_EFC.Models;

public partial class TblBook
{
    public int Id { get; set; }

    public string BookName { get; set; } = null!;

    public string BookAuthor { get; set; } = null!;

    public decimal BookPrice { get; set; }
}
