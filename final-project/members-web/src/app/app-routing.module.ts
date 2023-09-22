import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { customerGuard } from './utils/apis/guards/customer.guard';
import { employeeGuard } from './utils/apis/guards/employee.guard';
import { managerGuard } from './utils/apis/guards/manager.guard';
import { ownerGuard } from './utils/apis/guards/owner.guard';

const routes: Routes = [
  { path: 'public',
    loadChildren: () =>
      import('./core/public/public.module')
        .then(m => m.PublicModule)
  },
  { path: 'customer',
    loadChildren: () =>
      import('./core/customer/customer.module')
        .then(m => m.CustomerModule),
    canMatch: [customerGuard]
  },
  { path: 'employee',
    loadChildren: () =>
      import('./core/employee/employee.module')
        .then(m => m.EmployeeModule),
    canMatch: [employeeGuard]
  },
  { path: 'manager',
    loadChildren: () =>
      import('./core/manager/manager.module')
        .then(m => m.ManagerModule),
    canMatch: [managerGuard]
  },
  { path: 'owner',
    loadChildren: () =>
      import('./core/owner/owner.module')
        .then(m => m.OwnerModule),
    canMatch: [ownerGuard]
  },
  { path: '', redirectTo: '/public', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
