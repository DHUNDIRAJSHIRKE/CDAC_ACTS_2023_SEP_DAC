using Newtonsoft.Json.Serialization;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace EmployeeMVC.Models;

public partial class TblEmployee
{
    
    public int EmployeeId { get; set; }
    [DisplayName("Employee Name")]
    [Required(ErrorMessage ="Please Enter Name!")]
    [StringLength(25,ErrorMessage ="Name can't be more than 25 characters")]
    public string EmployeeName { get; set; } = null!;
    [Required(ErrorMessage = "Please Enter City!")]
    [StringLength(20, ErrorMessage = "City can't be more than 20 characters")]
    public string EmployeeCity { get; set; } = null!;
    [Required(ErrorMessage = "Please Enter Date!")]
    public DateTime EmployeeDob { get; set; }
    [Required(ErrorMessage = "Please Enter Gender!")]
    public string EmployeeGender { get; set; } = null!;
    [Required(ErrorMessage = "Please Enter Salary!")]
    public decimal EmployeeSalary { get; set; }
}
