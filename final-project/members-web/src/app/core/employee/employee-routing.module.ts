import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee.component';
import { PosComponent } from './pos/pos.component';
import { CatalogManagementComponent } from './catalog-management/catalog-management.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { CatalogDetailComponent } from './catalog-management/catalog-detail/catalog-detail.component';
import { CategoryManagementComponent } from './category-management/category-management.component';
import { CustomerDetailComponent } from './customer-management/customer-detail/customer-detail.component';

const routes: Routes = [
  { path: '', component: EmployeeComponent, children: [
    { path: 'sale', component: PosComponent, title: 'Employee | Sale' },
    { path: 'category', component: CategoryManagementComponent, title: 'Emplyee | Category Management' },
    { path: 'catalog', children: [
      { path: 'management', component: CatalogManagementComponent, title: 'Employee | Catalog Management' },
      { path: 'detail', component: CatalogDetailComponent, title: 'Employee | Catalog Detail' }
    ]},
    { path: 'customer', children: [
      { path: 'management', component: CustomerManagementComponent, title: 'Employee | Customer Management' },
      { path: 'detail', component: CustomerDetailComponent, title: 'Employee | Customer Detail' }
    ]},
    { path: '', redirectTo: '/employee/sale', pathMatch: 'full' }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }
