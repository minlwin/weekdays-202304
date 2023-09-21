import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-master-layout',
  templateUrl: './master-layout.component.html'
})
export class MasterLayoutComponent {

  @Input()
  viewTitle?: string

  @Input()
  viewIcon?: string

  @Input()
  middle = false

}
