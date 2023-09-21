import { Component, ViewChild } from '@angular/core';
import { CategoryFormComponent } from './category-form/category-form.component';

@Component({
  selector: 'app-category-management',
  templateUrl: './category-management.component.html'
})
export class CategoryManagementComponent {

  @ViewChild(CategoryFormComponent)
  categoryForm?: CategoryFormComponent

  targetCategory: any
  categories: any[] = [
    {
      id: 1,
      name: 'Gold Ring',
      deleted: false,
      items: 21
    },
    {
      id: 2,
      name: 'Gold Ear Ring',
      deleted: false,
      items: 14
    },
    {
      id: 3,
      name: 'Hand Chain',
      deleted: true,
      items: 30
    },
    {
      id: 4,
      name: 'Necklace',
      deleted: false,
      items: 44
    }
  ]

  categoryNamesForSearch: any[] = []

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

  editCategory(category: any) {
    this.targetCategory = category
    this.categoryForm?.openCategoryForm()
  }

  deleteCategory(id: number) {}

}
