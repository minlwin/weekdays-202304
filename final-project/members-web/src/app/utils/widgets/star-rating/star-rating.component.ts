import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html'
})
export class StarRatingComponent implements OnInit {

  @Input()
  rating: number = 0

  @Input()
  isBlock = false

  @Input()
  marginSide: any

  @Input()
  marginUnit: any

  stars: any = []

  ngOnInit(): void {
    this.getRating()
  }

  getStar(): string {
    if(this.rating <= -2) {
      return 'bi-star'
    } else if(this.rating == -1) {
      return 'bi-star-half'
    } else {
      return 'bi-star-fill'
    }
  }

  getRating() {
    let arr = new Array(5)
    for(let i = 0; i < arr.length; i++) {
      this.rating -= 2
      arr[i] = this.getStar()
    }
    this.stars = arr
  }

}
