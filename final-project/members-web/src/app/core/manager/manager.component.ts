import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityContextHolder } from 'src/app/utils/apis/security/security-context-holder';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html'
})
export class ManagerComponent {

  constructor(private context: SecurityContextHolder, private router: Router) {}

  logout() {
    this.context.signOut()
    this.router.navigate(['/public', 'home'])
  }

}
