import { AfterViewInit, Component, Input } from '@angular/core';

declare const bootstrap: any

@Component({
  selector: 'app-info-dialog',
  templateUrl: './info-dialog.component.html'
})
export class InfoDialogComponent implements AfterViewInit {

  dialog: any

  @Input()
  modalId: any

  message: any

  ngAfterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modalId}`)
  }

  openDialog(message: any) {
    this.message = message
    this.dialog.show()
  }

}
