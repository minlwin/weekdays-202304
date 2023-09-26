import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html'
})
export class CustomerManagementComponent {

  form: FormGroup
  customers: any[] = []


  constructor(fb: FormBuilder) {
    this.form = fb.group({})
  }

  updateCustomer(customer: any) {}
}
