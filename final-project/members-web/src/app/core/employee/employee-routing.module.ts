import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee.component';
import { PosComponent } from './pos/pos.component';
import { EmployeeCatalogManagementComponent } from './employee-catalog-management/employee-catalog-management.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { EmployeeCatalogDetailComponent } from './employee-catalog-management/employee-catalog-detail/employee-catalog-detail.component';
import { CategoryManagementComponent } from './category-management/category-management.component';
import { CustomerDetailComponent } from './customer-management/customer-detail/customer-detail.component';
import { CheckOutComponent } from 'src/app/utils/widgets/check-out/check-out.component';
import { EmployeeCatalogFormComponent } from './employee-catalog-management/employee-catalog-form/employee-catalog-form.component';
import { CustomerFormComponent } from './customer-management/customer-form/customer-form.component';

const routes: Routes = [
  { path: '', component: EmployeeComponent, children: [
    { path: 'sale', children: [
      { path: '', component: PosComponent, title: 'Employee | Pos' },
      { path: 'checkout', component: CheckOutComponent, title: 'Employee | Check Out' }
    ]},
    { path: 'category', component: CategoryManagementComponent, title: 'Employee | Category Management' },
    { path: 'catalog', children: [
      { path: 'management', component: EmployeeCatalogManagementComponent, title: 'Employee | Catalog Management' },
      { path: 'edit', component: EmployeeCatalogFormComponent, title: 'Employee | Catalog Edit' },
      { path: 'detail', component: EmployeeCatalogDetailComponent, title: 'Employee | Catalog Detail' },
      { path: '', redirectTo: '/employee/catalog/management', pathMatch: 'full' }
    ]},
    { path: 'customer', children: [
      { path: 'management', component: CustomerManagementComponent, title: 'Employee | Customer Management' },
      { path: 'edit', component: CustomerFormComponent, title: 'Employee | Customer Edit' },
      { path: 'detail', component: CustomerDetailComponent, title: 'Employee | Customer Detail' },
      { path: '', redirectTo: '/employee/customer/management', pathMatch: 'full' }
    ]},
    { path: '', redirectTo: '/employee/sale', pathMatch: 'full' }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }
