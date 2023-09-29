import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/utils/apis/services/cart.service';
import { EmployeeCatalogService } from 'src/app/utils/apis/services/employee/employee-catalog.service';
import { EmployeeSaleService } from 'src/app/utils/apis/services/employee/employee-sale.service';

@Component({
  selector: 'app-pos',
  templateUrl: './pos.component.html'
})
export class PosComponent implements OnInit {

  catalogs: any[] = []

  constructor(private empSaleService: EmployeeSaleService,
    private empCatalogService: EmployeeCatalogService,
    private cartService: CartService) {}

  ngOnInit(): void {
    this.empCatalogService.search(undefined).subscribe(resp => this.catalogs = resp.content)
  }

  isExistCatalog(catalog: any) {
    return this.cartService.isExist(catalog)
  }

  addToCart(catalog: any) {
    if(!this.isExistCatalog(catalog))
      this.cartService.add({item: catalog, quantity: 1})
  }

}
