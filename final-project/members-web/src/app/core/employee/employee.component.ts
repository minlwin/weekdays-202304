import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityContextHolder } from 'src/app/utils/apis/security/security-context-holder';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent {

  constructor(private context: SecurityContextHolder, private router: Router) {}

  logOut() {
    this.context.signOut()
    this.router.navigate(['/public'])
  }

}
