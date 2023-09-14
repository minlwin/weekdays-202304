import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalDialogComponent } from './modal-dialog/modal-dialog.component';
import { FormGroupComponent } from './form-group/form-group.component';
import { SimpleFormComponent } from './simple-form/simple-form.component';
import { MasterLayoutComponent } from './master-layout/master-layout.component';
import { MasterSearchComponent } from './master-search/master-search.component';
import { CatalogBoxComponent } from './catalog-box/catalog-box.component';
import { CategoryBoxComponent } from './category-box/category-box.component';



@NgModule({
  declarations: [
    ModalDialogComponent,
    FormGroupComponent,
    SimpleFormComponent,
    MasterLayoutComponent,
    MasterSearchComponent,
    CatalogBoxComponent,
    CategoryBoxComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ModalDialogComponent,
    FormGroupComponent,
    SimpleFormComponent,
    MasterLayoutComponent,
    CatalogBoxComponent,
    CategoryBoxComponent
  ]
})
export class WidgetsModule { }
