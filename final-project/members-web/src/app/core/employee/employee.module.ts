import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeComponent } from './employee.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { CatalogManagementComponent } from './catalog-management/catalog-management.component';
import { PosComponent } from './pos/pos.component';
import { CatalogDetailComponent } from './catalog-management/catalog-detail/catalog-detail.component';
import { WidgetsModule } from 'src/app/utils/widgets/widgets.module';
import { CategoryManagmentComponent } from './category-managment/category-managment.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    EmployeeComponent,
    CustomerManagementComponent,
    CatalogManagementComponent,
    PosComponent,
    CatalogDetailComponent,
    CategoryManagmentComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule { }
