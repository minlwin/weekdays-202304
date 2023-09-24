import { Component, OnInit, ViewChild } from '@angular/core';
import { CategoryFormComponent } from './category-form/category-form.component';
import { EmployeeCategoryService } from 'src/app/utils/apis/services/employee/employee-category.service';

@Component({
  selector: 'app-category-management',
  templateUrl: './category-management.component.html'
})
export class CategoryManagementComponent implements OnInit {

  @ViewChild(CategoryFormComponent)
  categoryForm?: CategoryFormComponent

  targetCategory: any
  categories: any[] = []

  categoryNamesForSearch: any[] = []

  constructor(private empCategoryService: EmployeeCategoryService) {}

  ngOnInit(): void {
    this.search()
  }

  search() {
    this.empCategoryService.search().subscribe(resp => this.categories = resp)
  }

  addValue(value: any) {
    this.categoryNamesForSearch.push(value)
  }

  removeName(index: number) {
    this.categoryNamesForSearch.splice(index, 1)
  }

  openCategoryForm() {
    this.targetCategory = undefined
    this.categoryForm?.openCategoryForm()
  }

  saveCategory(category: any) {
    this.empCategoryService.save(category).subscribe(resp => {
      if(resp) {
        this.categoryForm?.hideCategoryForm()
        this.categoryForm?.initCategoryForm()
        this.search()
      }
    })
  }

  editCategory(category: any) {
    this.targetCategory = category
    this.categoryForm?.openCategoryForm()
  }

  deleteCategory(id: number) {}

}
