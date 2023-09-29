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

  remove(item: CartCatalog) {
    this._carts.splice(this._carts.indexOf(item), 1)
  }

  get carts() {
    return this._carts
  }

  isExist(item: any) {
    return this._carts.filter(cc => cc.item?.id == item.id).length ? true : false
  }
}
