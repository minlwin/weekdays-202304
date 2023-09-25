import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CustomerFormComponent } from './customer-form/customer-form.component';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html'
})
export class CustomerManagementComponent {

  form: FormGroup
  customers: any[] = []

  @ViewChild(CustomerFormComponent)
  customerForm?: CustomerFormComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({})
  }

  openCustomerForm() {
    this.customerForm?.openCustomerForm()
  }

  updateCustomer(customer: any) {}
}
