import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalDialogComponent } from './dialog/modal-dialog/modal-dialog.component';
import { FormGroupComponent } from './form-group/form-group.component';
import { SimpleFormComponent } from './simple-form/simple-form.component';
import { MasterLayoutComponent } from './master-layout/master-layout.component';
import { CatalogBoxComponent } from './catalog/catalog-box/catalog-box.component';
import { CategoryBoxComponent } from './category-box/category-box.component';
import { NoDataComponent } from './no-data/no-data.component';
import { CheckOutComponent } from './check-out/check-out.component';
import { RouterModule } from '@angular/router';
import { CatalogDetailBoxComponent } from './catalog/catalog-detail-box/catalog-detail-box.component';
import { CatalogDescriptionTabComponent } from './catalog/catalog-description-tab/catalog-description-tab.component';
import { CatalogDetailTabComponent } from './catalog/catalog-detail-tab/catalog-detail-tab.component';
import { CatalogReviewTabComponent } from './catalog/catalog-review-tab/catalog-review-tab.component';
import { StarRatingComponent } from './star-rating/star-rating.component';
import { ErrorDialogComponent } from './dialog/error-dialog/error-dialog.component';



@NgModule({
  declarations: [
    ModalDialogComponent,
    FormGroupComponent,
    SimpleFormComponent,
    MasterLayoutComponent,
    CatalogBoxComponent,
    CategoryBoxComponent,
    NoDataComponent,
    CheckOutComponent,
    CatalogDetailBoxComponent,
    CatalogDescriptionTabComponent,
    CatalogDetailTabComponent,
    CatalogReviewTabComponent,
    StarRatingComponent,
    ErrorDialogComponent
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
    NoDataComponent,
    CatalogDetailBoxComponent,
    CatalogDescriptionTabComponent,
    CatalogDetailTabComponent,
    CatalogReviewTabComponent,
    StarRatingComponent,
    ErrorDialogComponent
  ]
})
export class WidgetsModule { }
