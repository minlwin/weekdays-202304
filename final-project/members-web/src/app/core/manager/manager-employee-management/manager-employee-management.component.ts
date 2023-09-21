import { Component, ViewChild } from '@angular/core';
import { ManagerEmployeeFormComponent } from '../manager-employee-form/manager-employee-form.component';

@Component({
  selector: 'app-manager-employee-management',
  templateUrl: './manager-employee-management.component.html'
})
export class ManagerEmployeeManagementComponent {

  @ViewChild(ManagerEmployeeFormComponent)
  employeeForm?: ManagerEmployeeFormComponent

}
