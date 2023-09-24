import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-category-box',
  templateUrl: './category-box.component.html'
})
export class CategoryBoxComponent {

  @Input()
  name?: string

  @Input()
  count: any

}
