import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeComponent } from './employee.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { EmployeeCatalogManagementComponent } from './employee-catalog-management/employee-catalog-management.component';
import { PosComponent } from './pos/pos.component';
import { EmployeeCatalogDetailComponent } from './employee-catalog-management/employee-catalog-detail/employee-catalog-detail.component';
import { WidgetsModule } from 'src/app/utils/widgets/widgets.module';
import { CategoryManagementComponent } from './category-management/category-management.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CustomerDetailComponent } from './customer-management/customer-detail/customer-detail.component';
import { CategoryFormComponent } from './category-management/category-form/category-form.component';
import { EmployeeCatalogFormComponent } from './employee-catalog-management/employee-catalog-form/employee-catalog-form.component';
import { CustomerFormComponent } from './customer-management/customer-form/customer-form.component';
import { PosCustomerComponent } from './pos/pos-customer/pos-customer.component';
import { PosCatalogComponent } from './pos/pos-catalog/pos-catalog.component';


@NgModule({
  declarations: [
    EmployeeComponent,
    CustomerManagementComponent,
    EmployeeCatalogManagementComponent,
    PosComponent,
    EmployeeCatalogDetailComponent,
    CategoryManagementComponent,
    CustomerDetailComponent,
    CategoryFormComponent,
    EmployeeCatalogFormComponent,
    CustomerFormComponent,
    PosCustomerComponent,
    PosCatalogComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule { }
