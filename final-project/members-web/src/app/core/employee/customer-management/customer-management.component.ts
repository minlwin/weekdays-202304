import { Component, OnInit } from '@angular/core';
import { CustomerSearchParams } from 'src/app/utils/apis/dto/search-params';
import { EmployeeCustomerService } from 'src/app/utils/apis/services/employee/employee-customer.service';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html'
})
export class CustomerManagementComponent implements OnInit {

  searchParams: CustomerSearchParams = {
    id: 0,
    name: '',
    phone: '',
    address: ''
  }
  customers: any[] = []

  constructor(private empCustomerService: EmployeeCustomerService) {
  }

  ngOnInit(): void {
    this.search()
  }

  search() {
    this.empCustomerService.search(this.searchParams).subscribe(resp => this.customers = resp.content)
  }

}
