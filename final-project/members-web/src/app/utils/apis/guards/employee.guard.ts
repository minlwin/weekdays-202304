import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { SecurityContextHolder } from '../security/security-context-holder';

export const employeeGuard: CanActivateFn = (route, state) => {
  let user = inject(SecurityContextHolder).activeUser
  return user && (user.role == 'Owner' || user.role == 'Manager' || user.role == 'Employee') ? true : inject(Router).navigate(['/public']);
};
