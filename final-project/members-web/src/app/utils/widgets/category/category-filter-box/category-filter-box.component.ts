import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-category-filter-box',
  templateUrl: './category-filter-box.component.html'
})
export class CategoryFilterBoxComponent {

  @Input()
  categories: any[] = []

  @Input()
  showMore = false

  @Output()
  onGetNext = new EventEmitter<boolean>

  getNextCategories() {
    this.onGetNext.emit(true)
  }

}
