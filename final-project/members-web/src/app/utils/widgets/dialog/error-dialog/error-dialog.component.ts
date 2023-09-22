import { Component, Input } from '@angular/core';

declare const bootstrap: any

@Component({
  selector: 'app-error-dialog',
  templateUrl: './error-dialog.component.html'
})
export class ErrorDialogComponent {

  dialog: any

  messages: any[] = []

  @Input()
  modalId?: string

  ngAfterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modalId}`)
  }

  openDialog(error: any) {
    if(error.error) {
      this.messages = error.error.messages
    } else {
      console.log(error)
      this.messages.push('Application Error!')
    }
    this.dialog.show()
  }

  hideDialog() {
    this.dialog.hide()
  }

}
