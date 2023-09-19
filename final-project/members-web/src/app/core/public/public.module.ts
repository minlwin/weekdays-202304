import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { CatalogComponent } from './catalog/catalog.component';
import { HomeComponent } from './home/home.component';
import { WidgetsModule } from 'src/app/utils/widgets/widgets.module';
import { ReactiveFormsModule } from '@angular/forms';
import { DetailComponent } from './catalog/detail/detail.component';


@NgModule({
  declarations: [
    PublicComponent,
    CatalogComponent,
    HomeComponent,
    DetailComponent
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class PublicModule { }
