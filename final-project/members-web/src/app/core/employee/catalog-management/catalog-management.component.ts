import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CatalogFormComponent } from './catalog-form/catalog-form.component';

@Component({
  selector: 'app-catalog-management',
  templateUrl: './catalog-management.component.html'
})
export class CatalogManagementComponent {

  catalogs = [
    {
      name: 'Gold Rings',
      category: 'Rings',
      weight: 10,
      price: 340000,
      status: 'New',
      description: 'Lorem ipsum dolor sit, consectetur adipisicing elit. Fugiat aliquam magni vel sequi officiis odio eaque. Lorem ipsum dolor sit, consectetur adipisicing elit. Fugiat aliquam magni vel sequi officiis odio eaque.',
      images: [
        'https://images.unsplash.com/photo-1611107683227-e9060eccd846?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80'
      ]
    },
    {
      name: 'Gold Ear Rings',
      category: 'Ear Rings',
      weight: 8,
      price: 300000,
      status: 'Popular',
      images: [
        'https://images.unsplash.com/photo-1567523977592-7959bc5df51e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1402&q=80'
      ]
    }
  ]
  form: FormGroup

  @ViewChild(CatalogFormComponent)
  catalogForm?: CatalogFormComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({

    })
  }

}
