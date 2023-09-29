import { Component, OnInit } from '@angular/core';
import { CatalogSearchParams } from 'src/app/utils/apis/dto/search-params';
import { CartService } from 'src/app/utils/apis/services/cart.service';
import { PublicCatalogService } from 'src/app/utils/apis/services/public/public-catalog.service';
import { PublicCategoryService } from 'src/app/utils/apis/services/public/public-category.service';

@Component({
  selector: 'app-catalog',
  templateUrl: './public-catalog.component.html'
})
export class PublicCatalogComponent implements OnInit {

  searchParams: CatalogSearchParams = {
    keyword: '',
    categoryIds: []
  }

  categories: any[] = []
  catalogs: any[] = []

  constructor(private pubCategoryService: PublicCategoryService,
    private pubCatalogService: PublicCatalogService,
    private cartService: CartService) {}

  ngOnInit(): void {
    this.pubCategoryService.findAll().subscribe(resp => this.categories = resp)
    this.search()
  }

  search() {
    this.pubCatalogService.search(this.searchParams).subscribe(resp => this.catalogs = resp.content)
  }

  select(value: any) {
    this.searchParams.categoryIds = []
    if(value > 0)
      this.searchParams.categoryIds.push(value);
    this.search()
  }

  isExistCatalog(catalog: any) {
    return this.cartService.isExist(catalog)
  }

  addToCart(catalog: any) {
    if(this.isExistCatalog(catalog) == false)
      this.cartService.add({item: catalog, quantity: 1})
  }

}
