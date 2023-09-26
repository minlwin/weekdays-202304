import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
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
    this.form = fb.group({
      id: 0,
      name: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      nrcNumber: ['', Validators.required],
      gender: 'Male',
      dateOfBirth: '',
      address: ['', Validators.required],
      township: [0, Validators.required],
      remark: '',
      refererId: 0,
      deleted: false
    })
  }

  get id() {
    return this.form.get('id') as FormControl
  }

  get name() {
    return this.form.get('name') as FormControl
  }

  get phone() {
    return this.form.get('phone') as FormControl
  }

  get email() {
    return this.form.get('email') as FormControl
  }

  get nrcNumber() {
    return this.form.get('nrcNumber') as FormControl
  }

  get address() {
    return this.form.get('address') as FormControl
  }

  get township() {
    return this.form.get('township') as FormControl
  }

  openCustomerForm() {
    this.dialog?.openDialog()
  }

}
