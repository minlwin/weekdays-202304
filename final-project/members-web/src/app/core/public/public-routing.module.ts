import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogComponent } from './catalog/catalog.component';
import { PublicComponent } from './public.component';
import { HomeComponent } from './home/home.component';
import { DetailComponent } from './catalog/detail/detail.component';

const routes: Routes = [
  { path: '', component: PublicComponent, children: [
    { path: 'home', component: HomeComponent, title: 'Public | Home' },
    { path: 'catalog', children: [
      { path: 'list', component: CatalogComponent, title: 'Public | Catalog List' },
      { path: 'detail', component: DetailComponent, title: 'Public | Catalog Detail' },
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
