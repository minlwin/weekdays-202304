import { Component, ViewChild } from '@angular/core';
import { CategoryFormComponent } from './category-form/category-form.component';

@Component({
  selector: 'app-category-management',
  templateUrl: './category-management.component.html'
})
export class CategoryManagementComponent {

  @ViewChild(CategoryFormComponent)
  categoryForm?: CategoryFormComponent

}
