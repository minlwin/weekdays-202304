import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalDialogComponent } from './modal-dialog/modal-dialog.component';
import { FormGroupComponent } from './form-group/form-group.component';
import { SimpleFormComponent } from './simple-form/simple-form.component';



@NgModule({
  declarations: [
    ModalDialogComponent,
    FormGroupComponent,
    SimpleFormComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ModalDialogComponent,
    FormGroupComponent,
    SimpleFormComponent
  ]
})
export class WidgetsModule { }
