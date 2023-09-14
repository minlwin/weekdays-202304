import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee.component';
import { PosComponent } from './pos/pos.component';
import { CatalogManagementComponent } from './catalog-management/catalog-management.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { CatalogDetailComponent } from './catalog-management/catalog-detail/catalog-detail.component';
import { CategoryManagmentComponent } from './category-managment/category-managment.component';

const routes: Routes = [
  { path: '', component: EmployeeComponent, children: [
    { path: 'sale', component: PosComponent, title: 'Employee | Sale' },
    { path: 'category', component: CategoryManagmentComponent, title: 'Emplyee | Category Management' },
    { path: 'catalog', children: [
      { path: 'management', component: CatalogManagementComponent, title: 'Employee | Catalog Management' },
      { path: 'detail', component: CatalogDetailComponent, title: 'Employee | Catalog Detail' }
    ]},
    { path: 'customer-management', component: CustomerManagementComponent, title: 'Employee | Customer Management' },
    { path: '', redirectTo: '/employee/sale', pathMatch: 'full' }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }
