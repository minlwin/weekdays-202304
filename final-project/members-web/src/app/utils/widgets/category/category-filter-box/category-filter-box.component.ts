import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-category-filter-box',
  templateUrl: './category-filter-box.component.html'
})
export class CategoryFilterBoxComponent {

  @Input()
  categories: any[] = []

}
