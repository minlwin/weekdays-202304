import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/utils/widgets/dialog/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html'
})
export class CustomerFormComponent {

  form: FormGroup

  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({})
  }

  openCustomerForm() {
    this.dialog?.openDialog()
  }

}
