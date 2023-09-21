import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-catalog-review-tab',
  templateUrl: './catalog-review-tab.component.html'
})
export class CatalogReviewTabComponent {

  @Input()
  data: any[] = []

  @Input()
  id: any

  rating: number = 0
  stars: string[] = ['bi-star', 'bi-star', 'bi-star', 'bi-star', 'bi-star']

  select(starIndex: number) {
    this.rating = starIndex + 1

    for(let i = 0; i < this.stars.length; i++) {
      if(i <= starIndex) {
        this.stars[i] = 'bi-star-fill text-success'
      } else {
        this.stars[i] = 'bi-star'
      }
    }
  }

}
