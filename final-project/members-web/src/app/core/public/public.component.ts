import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/utils/widgets/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-public',
  templateUrl: './public.component.html'
})
export class PublicComponent {

  form: FormGroup

  @ViewChild(ModalDialogComponent)
  modalDialog?: ModalDialogComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9]{8,}')]]
    })
  }

  get email(): FormControl {
    return this.form.get('email') as FormControl
  }

  get password(): FormControl {
    return this.form.get('password') as FormControl
  }

  openForm() {
    this.modalDialog?.openDialog()
  }

}
