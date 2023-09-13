import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'public',
    loadChildren: () =>
      import('./core/public/public.module')
        .then(m => m.PublicModule)
  },
  { path: 'customer',
    loadChildren: () =>
      import('./core/customer/customer.module')
        .then(m => m.CustomerModule)
  },
  { path: 'employee',
    loadChildren: () =>
      import('./core/employee/employee.module')
        .then(m => m.EmployeeModule)
  },
  { path: 'manager',
    loadChildren: () =>
      import('./core/manager/manager.module')
        .then(m => m.ManagerModule)
  },
  { path: 'owner',
    loadChildren: () =>
      import('./core/owner/owner.module')
        .then(m => m.OwnerModule)
  },
  { path: '', redirectTo: '/public', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
