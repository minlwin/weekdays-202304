import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee.component';
import { PosComponent } from './pos/pos.component';
import { CatalogManagementComponent } from './catalog-management/catalog-management.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { CatalogDetailComponent } from './catalog-management/catalog-detail/catalog-detail.component';
import { CategoryManagementComponent } from './category-management/category-management.component';
import { CustomerDetailComponent } from './customer-management/customer-detail/customer-detail.component';
import { CheckOutComponent } from 'src/app/utils/widgets/check-out/check-out.component';

const routes: Routes = [
  { path: '', component: EmployeeComponent, children: [
    { path: 'sale', children: [
      { path: '', component: PosComponent, title: 'Employee | Pos' },
      { path: 'checkout', component: CheckOutComponent, title: 'Employee | Check Out' }
    ]},
    { path: 'category', component: CategoryManagementComponent, title: 'Employee | Category Management' },
    { path: 'catalog', children: [
      { path: 'management', component: CatalogManagementComponent, title: 'Employee | Catalog Management' },
      { path: 'detail', component: CatalogDetailComponent, title: 'Employee | Catalog Detail' },
      { path: '', redirectTo: '/employee/catalog/management', pathMatch: 'full' }
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
