import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-catalog-detail-tab',
  templateUrl: './catalog-detail-tab.component.html'
})
export class CatalogDetailTabComponent {

  @Input()
  data: any

  @Input()
  id: any

}
