import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/utils/widgets/dialog/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html'
})
export class CategoryFormComponent {

  form: FormGroup

  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  @Output()
  onSave = new EventEmitter<any>

  constructor(fb: FormBuilder) {
    this.form = fb.group({
      id: 0,
      name: ['', Validators.required],
      deleted: false
    })
  }

  get id(): FormControl {
    return this.form.get('id') as FormControl
  }

  get name(): FormControl {
    return this.form.get('name') as FormControl
  }

  @Input()
  set category(category: any) {

    this.initCategoryForm()

    if(category) {
      this.form.patchValue(category)
    }
  }

  openCategoryForm() {
    this.dialog?.openDialog()
  }

  hideCategoryForm() {
    this.dialog?.hideDialog()
  }

  saveCategory() {
    this.onSave.emit(this.form.value)
  }

  initCategoryForm() {
    this.form.patchValue({
      id: 0,
      name: '',
      deleted: false
    })
  }

}
