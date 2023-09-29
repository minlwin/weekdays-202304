import { Component, OnInit, ViewChild } from '@angular/core';
import { EmployeeCatalogFormComponent } from './employee-catalog-form/employee-catalog-form.component';
import { EmployeeCatalogService } from 'src/app/utils/apis/services/employee/employee-catalog.service';
import { EmployeeCategoryService } from 'src/app/utils/apis/services/employee/employee-category.service';
import { SecurityContextHolder } from 'src/app/utils/apis/security/security-context-holder';
import { CatalogSearchParams } from 'src/app/utils/apis/dto/search-params';

@Component({
  selector: 'app-catalog-management',
  templateUrl: './employee-catalog-management.component.html'
})
export class EmployeeCatalogManagementComponent implements OnInit {

  searchParams: CatalogSearchParams = {
    keyword: '',
    categoryIds: []
  }

  currentRole = undefined

  categories: any[] = []
  sharedCategories: any[] = []
  catalogs: any[] = []

  @ViewChild(EmployeeCatalogFormComponent)
  catalogForm?: EmployeeCatalogFormComponent

  constructor(private empCatalogService: EmployeeCatalogService,
    private empCategoryService: EmployeeCategoryService,
    private context: SecurityContextHolder) {}

  ngOnInit(): void {
    this.empCategoryService.search().subscribe(resp => {
      this.categories = resp
      this.sharedCategories = resp.slice(0, 4)
    })
    this.currentRole = this.context.activeUser.role
    this.search()
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

  select(id: any) {
    let prevId: any = 0
    length = this.searchParams.categoryIds.length

    if(length) {
      for (let i = 0; i < this.searchParams.categoryIds.length; i++) {

        if(id == this.searchParams.categoryIds[i]) {
          prevId = this.searchParams.categoryIds[i]
          break
        }

      }
    }

    if(prevId) {
      this.searchParams.categoryIds.splice(this.searchParams.categoryIds.indexOf(prevId), 1)
    } else {
      this.searchParams.categoryIds.push(id)
    }
  }

}
