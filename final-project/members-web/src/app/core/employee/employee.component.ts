import { Component, OnInit } from '@angular/core';
import { Router, RouterEvent } from '@angular/router';
import { SecurityContextHolder } from 'src/app/utils/apis/security/security-context-holder';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent implements OnInit {

  isCheckoutView = false

  constructor(private context: SecurityContextHolder,
    private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe(e => {
      if(e instanceof RouterEvent) {
        if(e.url == '/employee/sale/checkout') {
          this.isCheckoutView = true
        } else {
          this.isCheckoutView = false
        }
      }
    })
  }

  logOut() {
    this.context.signOut()
    this.router.navigate(['/public'])
  }

}
