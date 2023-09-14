import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/utils/widgets/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html'
})
export class CustomerManagementComponent {

  form: FormGroup

  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({})
  }

  openCatalogForm() {
    this.dialog?.openDialog()
  }

}
