import { Injectable } from '@angular/core';
import { CartCatalog } from '../dto/cart-catalog';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'any'
})
export class CartService {

  private _carts: CartCatalog[] = []

  constructor() {}

  add(item: CartCatalog) {
    this._carts.push(item)
  }

  remove(index: number) {
    this._carts.splice(index, 1)
    return this._carts
  }

  get carts() {
    return this._carts
  }

  findByIndex(index: number) {
    return this._carts.at(index) as CartCatalog
  }

  plusQuantity(index: number) {
    let result = this.findByIndex(index)
    result.quantity = result.quantity + 1
    return this._carts
  }

  minusQuantity(index: number) {
    let result = this.findByIndex(index)
    if(result.quantity > 1)
      result.quantity = result.quantity - 1
    return this.carts
  }

  isExist(item: any) {
    return this._carts.filter(cc => cc.item?.id == item.id).length ? true : false
  }
}
