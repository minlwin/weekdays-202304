import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeComponent } from './employee.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { CatalogManagementComponent } from './catalog-management/catalog-management.component';
import { PosComponent } from './pos/pos.component';
import { CatalogDetailComponent } from './catalog-management/catalog-detail/catalog-detail.component';
import { WidgetsModule } from 'src/app/utils/widgets/widgets.module';
import { CategoryManagementComponent } from './category-management/category-management.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CustomerDetailComponent } from './customer-management/customer-detail/customer-detail.component';
import { CategoryFormComponent } from './category-management/category-form/category-form.component';
import { CatalogFormComponent } from './catalog-management/catalog-form/catalog-form.component';
import { CustomerFormComponent } from './customer-management/customer-form/customer-form.component';


@NgModule({
  declarations: [
    EmployeeComponent,
    CustomerManagementComponent,
    CatalogManagementComponent,
    PosComponent,
    CatalogDetailComponent,
    CategoryManagementComponent,
    CustomerDetailComponent,
    CategoryFormComponent,
    CatalogFormComponent,
    CustomerFormComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule { }
