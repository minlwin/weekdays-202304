import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { SecurityContextHolder } from '../security/security-context-holder';

export const ownerGuard: CanActivateFn = (route, state) => {
  let user = inject(SecurityContextHolder)
  return user.activeUser && user.activeUser.role == 'Owner' ? true : inject(Router).navigate(['/public']);
};
