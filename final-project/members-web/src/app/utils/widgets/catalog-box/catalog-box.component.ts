import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-catalog-box',
  templateUrl: './catalog-box.component.html'
})
export class CatalogBoxComponent {

  @Input()
  role: any

  @Input()
  data?: any

  @Input()
  rating?: number

}
