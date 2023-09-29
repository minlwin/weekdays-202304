import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityContextHolder } from 'src/app/utils/apis/security/security-context-holder';

declare const bootstrap: any

@Component({
  selector: 'app-error-dialog',
  templateUrl: './error-dialog.component.html'
})
export class ErrorDialogComponent {

  dialog: any

  messages: string[] = []

  @Input()
  modalId?: string

  constructor(private context: SecurityContextHolder,
    private router: Router) {}

  ngAfterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modalId}`)
  }

  openDialog(error: Error | any) {
    if(error.error) {
      this.messages = error.error.messages
      if(this.messages[0].startsWith("You have to authenticate")) {
        this.context.signOut()
        this.router.navigate(['/public'])
      }
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
