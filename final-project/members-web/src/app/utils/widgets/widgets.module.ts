import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalDialogComponent } from './modal-dialog/modal-dialog.component';
import { FormGroupComponent } from './form-group/form-group.component';
import { SimpleFormComponent } from './simple-form/simple-form.component';
import { MasterLayoutComponent } from './master-layout/master-layout.component';
import { CatalogBoxComponent } from './catalog-box/catalog-box.component';
import { CategoryBoxComponent } from './category-box/category-box.component';
import { NoDataComponent } from './no-data/no-data.component';
import { CheckOutComponent } from './check-out/check-out.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    ModalDialogComponent,
    FormGroupComponent,
    SimpleFormComponent,
    MasterLayoutComponent,
    CatalogBoxComponent,
    CategoryBoxComponent,
    NoDataComponent,
    CheckOutComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    ModalDialogComponent,
    FormGroupComponent,
    SimpleFormComponent,
    MasterLayoutComponent,
    CatalogBoxComponent,
    CategoryBoxComponent,
    NoDataComponent
  ]
})
export class WidgetsModule { }
