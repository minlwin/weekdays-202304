import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/utils/widgets/dialog/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-manager-employee-form',
  templateUrl: './manager-employee-form.component.html'
})
export class ManagerEmployeeFormComponent {

  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  form: FormGroup

  @Output()
  onSave = new EventEmitter<any>

  constructor(fb: FormBuilder) {
    this.form = fb.group({
      id: 0,
      name: ['', Validators.required],
      phone: ['', [Validators.required, Validators.minLength(8)]],
      email: ['', [Validators.required, Validators.email]],
      nrcNumber: ['', Validators.required],
      assignAt: ['', Validators.required],
      retireAt: '',
      role: ['Customer', Validators.required],
      remark: ''
    })
  }

  @Input()
  set employee(employee: any) {
    this.initEmployeeForm()


    if(employee) {
      this.form.patchValue(employee)
    }
  }

  get id(): FormControl {
    return this.form.get('id') as FormControl
  }

  get name(): FormControl {
    return this.form.get('name') as FormControl
  }

  get phone(): FormControl {
    return this.form.get('phone') as FormControl
  }

  get email(): FormControl {
    return this.form.get('email') as FormControl
  }

  get nrcNumber(): FormControl {
    return this.form.get('nrcNumber') as FormControl
  }

  get assignDate(): FormControl {
    return this.form.get('assignAt') as FormControl
  }

  get role(): FormControl {
    return this.form.get('role') as FormControl
  }

  openEmployeeForm() {
    this.dialog?.openDialog()
  }

  hideEmployeeForm() {
    this.dialog?.hideDialog()
  }

  saveEmployee() {
    this.onSave.emit(this.form.value)
  }

  initEmployeeForm() {
    this.form.patchValue({
      id: 0,
      name: '',
      phone: '',
      email: '',
      nrcNumber: '',
      assignAt: '',
      retireAt: '',
      role: 'Customer',
      remark: ''
    })
  }

}
