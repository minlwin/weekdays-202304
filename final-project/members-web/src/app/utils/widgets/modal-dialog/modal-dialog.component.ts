import { AfterViewInit, Component, Input } from '@angular/core';

declare var bootstrap: any

@Component({
  selector: 'app-modal-dialog',
  templateUrl: './modal-dialog.component.html'
})
export class ModalDialogComponent implements AfterViewInit {

  dialog: any

  @Input()
  modalId?: string

  @Input()
  modalTitle?: string

  @Input()
  modalIcon?: string

  ngAfterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modalId}`, { backdrop: false })
  }

  openDialog() {
    this.dialog.show()
  }

  hideDialog() {
    this.dialog.hide()
  }

}
