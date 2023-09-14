import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/utils/widgets/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-catalog-management',
  templateUrl: './catalog-management.component.html'
})
export class CatalogManagementComponent {

  form: FormGroup

  constructor(fb: FormBuilder) {
    this.form = fb.group({

    })
  }

  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  openCatalogForm() {
    this.dialog?.openDialog()
  }

}
