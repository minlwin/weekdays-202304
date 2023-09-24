import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { SecurityContextHolder } from '../security/security-context-holder';
import { throwError } from 'rxjs';

export const managerGuard: CanActivateFn = (route, state) => {
  let user = inject(SecurityContextHolder).activeUser
  return user &&
        (user.role == 'Owner' ||
         user.role == 'Manager' ||
         user.role == 'Admin') ? true :
         inject(Router).navigate(['/', user.role.toLowerCase()]);
};
