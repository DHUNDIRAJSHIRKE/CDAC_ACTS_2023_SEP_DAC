using System;
using System.Collections.Generic;

namespace EmployeeWebAPI.Models;

public partial class TblEmployee
{
    public int EmployeeId { get; set; }

    public string EmployeeName { get; set; } = null!;

    public string EmployeeCity { get; set; } = null!;

    public DateTime EmployeeDob { get; set; }

    public string EmployeeGender { get; set; } = null!;

    public decimal EmployeeSalary { get; set; }
}
