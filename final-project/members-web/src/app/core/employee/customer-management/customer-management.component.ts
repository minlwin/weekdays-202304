import { Component, OnInit } from '@angular/core';
import { EmployeeCustomerService } from 'src/app/utils/apis/services/employee/employee-customer.service';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html'
})
export class CustomerManagementComponent implements OnInit {

  customers: any[] = []


  constructor(private empCustomerService: EmployeeCustomerService) {
  }

  ngOnInit(): void {
    this.search(undefined)
  }

  search(params: any) {
    this.empCustomerService.search(params).subscribe(resp => this.customers = resp.content)
  }

  updateCustomer(customer: any) {}

}
