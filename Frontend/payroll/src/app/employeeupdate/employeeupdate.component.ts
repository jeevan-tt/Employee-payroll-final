import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { EmpRegistraionService } from '../emp-registraion.service';

@Component({
  selector: 'app-employeeupdate',
  templateUrl: './employeeupdate.component.html',
  styleUrls: ['./employeeupdate.component.css']
})
export class EmployeeupdateComponent implements OnInit {

  empId: number;
  employee: Admin = new Admin();
  constructor(private employeeservice: AdminService,
    private route: ActivatedRoute,
    private router: Router,
    public service: EmpRegistraionService) { }
    msg='';

  ngOnInit(): void {
    this.empId = this.route.snapshot.params['empId'];
   //this.empId = this.service.getMessage()
   console.log("from empupdate",this.empId)
    this.employeeservice.getEmployeeById(this.empId).subscribe(data => {
      this.employee = data;}, error => console.log(error));
  }  
  goToEmployeeList()
{
  this.router.navigate(['/emploginsuccess'])
}
onSubmit(){
  //this.ngOnInit();
this.employeeservice.updateEmployee(this.empId, this.employee).subscribe( data =>{
this.goToEmployeeList();
}
, error => {
  console.log("exception occured");
 this.msg=error.error;
 alert('EmailId is already exists !!👎')});
}}