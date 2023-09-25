import { Component, OnInit, ViewChild } from '@angular/core';
import { EmployeeCatalogFormComponent } from './employee-catalog-form/employee-catalog-form.component';
import { EmployeeCatalogService } from 'src/app/utils/apis/services/employee/employee-catalog.service';
import { EmployeeCategoryService } from 'src/app/utils/apis/services/employee/employee-category.service';

@Component({
  selector: 'app-catalog-management',
  templateUrl: './employee-catalog-management.component.html'
})
export class EmployeeCatalogManagementComponent implements OnInit {

  searchParams = {
    keyword: '',
    categoryId: 0
  }

  categories: any[] = []
  sharedCategories: any[] = []
  catalogs: any[] = []

  @ViewChild(EmployeeCatalogFormComponent)
  catalogForm?: EmployeeCatalogFormComponent

  constructor(private empCatalogService: EmployeeCatalogService, private empCategoryService: EmployeeCategoryService) {}

  ngOnInit(): void {
    this.empCategoryService.search().subscribe(resp => {
      this.categories = resp
      this.sharedCategories = resp.slice(0, 4)
    })


  }

  search() {
    this.empCatalogService.search(this.searchParams).subscribe(resp => this.catalogs = resp.content)
  }

  get isShowMore() {
    return this.categories.length > this.sharedCategories.length
  }

  getNext(event: any) {
    if(event && this.isShowMore) {

      let copy = this.categories.slice(this.sharedCategories.length, this.sharedCategories.length + 4)

      for(let i = 0; i < copy.length; i++) {
        this.sharedCategories.push(copy[i])
      }

    }
  }

}
