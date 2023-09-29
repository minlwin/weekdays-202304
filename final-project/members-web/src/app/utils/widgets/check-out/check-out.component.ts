import { Component, OnInit } from '@angular/core';
import { EmployeeCustomerService } from '../../apis/services/employee/employee-customer.service';
import { CartService } from '../../apis/services/cart.service';
import { CartCatalog } from '../../apis/dto/cart-catalog';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html'
})
export class CheckOutComponent implements OnInit {

  items: any[] = []
  customer: any
  amount = 100000

  constructor(private empCustomerService: EmployeeCustomerService,
    private cartService: CartService) {}

  ngOnInit(): void {
    this.items = this.cartService.carts
  }

  search(code: any) {
    this.empCustomerService.findById(code).subscribe(resp => this.customer = resp)
  }

  plus(index: number) {
    this.items = this.cartService.plusQuantity(index)
  }

  minus(index: number) {
    this.items = this.cartService.minusQuantity(index)
  }

  remove(index: number) {
    this.items = this.cartService.remove(index)
  }

}
