import { Component, OnInit, ViewChild } from '@angular/core';
import { ManagerEmployeeFormComponent } from './manager-employee-form/manager-employee-form.component';
import { ManagerEmployeeService } from 'src/app/utils/apis/services/manager/manager-employee.service';
import { EmployeeSearchParams } from 'src/app/utils/apis/dto/search-params';

@Component({
  selector: 'app-manager-employee-management',
  templateUrl: './manager-employee-management.component.html'
})
export class ManagerEmployeeManagementComponent implements OnInit {

  searchParams: EmployeeSearchParams = {
    id: 0,
    name: '',
    phone: ''
  }

  @ViewChild(ManagerEmployeeFormComponent)
  employeeForm?: ManagerEmployeeFormComponent

  targetEmplyoee: any
  employees: any[] = []

  constructor(private manEmpService: ManagerEmployeeService) {}

  ngOnInit(): void {
    this.search()
  }

  search() {
    this.manEmpService.search(this.searchParams).subscribe(resp => this.employees = resp.content)
  }

  saveEmployee(data: any) {
    this.manEmpService.save(data).subscribe(resp => {
      if(resp) {
        this.employeeForm?.hideEmployeeForm()
        this.employeeForm?.initEmployeeForm()
        this.search()
      }
    })
  }

  updateEmployee(employee: any) {
    this.targetEmplyoee = employee
    this.employeeForm?.openEmployeeForm()
  }

  openEmployeeForm() {
    this.targetEmplyoee = undefined
    this.employeeForm?.openEmployeeForm()
  }

}
