import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-catalog-detail-box',
  templateUrl: './catalog-detail-box.component.html'
})
export class CatalogDetailBoxComponent implements OnInit {

  @Input()
  images: any = []

  activeCarousel?: string

  ngOnInit(): void {
    this.activeCarousel = this.images[0]
  }

}
