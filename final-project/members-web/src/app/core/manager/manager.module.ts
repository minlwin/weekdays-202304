import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ManagerRoutingModule } from './manager-routing.module';
import { ManagerComponent } from './manager.component';
import { ManagerEmployeeManagementComponent } from './manager-employee-management/manager-employee-management.component';
import { ManagerSettingComponent } from './manager-setting/manager-setting.component';
import { ManagerEmployeeDetailComponent } from './manager-employee-management/manager-employee-detail/manager-employee-detail.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ManagerEmployeeFormComponent } from './manager-employee-management/manager-employee-form/manager-employee-form.component';
import { WidgetsModule } from 'src/app/utils/widgets/widgets.module';


@NgModule({
  declarations: [
    ManagerComponent,
    ManagerEmployeeManagementComponent,
    ManagerSettingComponent,
    ManagerEmployeeDetailComponent,
    ManagerEmployeeFormComponent
  ],
  imports: [
    CommonModule,
    ManagerRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class ManagerModule { }
