import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublicCatalogComponent } from './public-catalog/public-catalog.component';
import { PublicComponent } from './public.component';
import { HomeComponent } from './home/home.component';
import { PublicCatalogDetailComponent } from './public-catalog/public-catalog-detail/public-catalog-detail.component';

const routes: Routes = [
  { path: '', component: PublicComponent, children: [
    { path: 'home', component: HomeComponent, title: 'Public | Home' },
    { path: 'catalog', children: [
      { path: 'list', component: PublicCatalogComponent, title: 'Public | Catalog List' },
      { path: 'detail', component: PublicCatalogDetailComponent, title: 'Public | Catalog Detail' },
      { path: '', redirectTo: '/public/catalog/list', pathMatch: 'full' }
    ]},
    { path: '', redirectTo: '/public/home', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PublicRoutingModule { }
