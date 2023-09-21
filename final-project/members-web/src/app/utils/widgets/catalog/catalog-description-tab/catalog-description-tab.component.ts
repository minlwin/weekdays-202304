import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-catalog-description-tab',
  templateUrl: './catalog-description-tab.component.html'
})
export class CatalogDescriptionTabComponent {

  @Input()
  data: any

  @Input()
  id: any

}
