import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ManagerComponent } from './manager.component';
import { ManagerEmployeeManagementComponent } from './manager-employee-management/manager-employee-management.component';
import { ManagerEmployeeDetailComponent } from './manager-employee-management/manager-employee-detail/manager-employee-detail.component';
import { ManagerSettingComponent } from './manager-setting/manager-setting.component';

const routes: Routes = [
  { path: '', component: ManagerComponent, children: [
    { path: 'employee', children: [
      { path: 'management', component: ManagerEmployeeManagementComponent, title: 'Manager | Employee Management' },
      { path: 'detail', component: ManagerEmployeeDetailComponent, title: 'Manager | Employee Detail' },
      { path: '', redirectTo: '/manager/employee/management', pathMatch: 'full' }
    ]},
    { path: 'setting', component: ManagerSettingComponent, title: 'Manager | Setting' },
    { path: '', redirectTo: '/manager/employee/management', pathMatch: 'full' }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ManagerRoutingModule { }
