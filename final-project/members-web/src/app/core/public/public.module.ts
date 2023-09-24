import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { PublicCatalogComponent } from './public-catalog/public-catalog.component';
import { HomeComponent } from './home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PublicCatalogDetailComponent } from './public-catalog/public-catalog-detail/public-catalog-detail.component';
import { WidgetsModule } from 'src/app/utils/widgets/widgets.module';


@NgModule({
  declarations: [
    PublicComponent,
    PublicCatalogComponent,
    HomeComponent,
    PublicCatalogDetailComponent
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class PublicModule { }
