import { Component, Input, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/utils/widgets/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html'
})
export class CategoryFormComponent {

  form: FormGroup


  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({})
  }

  openCategoryForm() {
    this.dialog?.openDialog()
  }

}
