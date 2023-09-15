import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-catalog-box',
  templateUrl: './catalog-box.component.html'
})
export class CatalogBoxComponent {

  @Input()
  name?: string

  @Input()
  cardImage?: string

  @Input()
  category?: string

  @Input()
  price?: number

  @Input()
  weight?: number

  @Input()
  rating?: number

  @Input()
  badgeText?: string

}
