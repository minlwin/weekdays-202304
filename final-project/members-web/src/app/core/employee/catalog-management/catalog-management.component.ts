import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CatalogFormComponent } from './catalog-form/catalog-form.component';

@Component({
  selector: 'app-catalog-management',
  templateUrl: './catalog-management.component.html'
})
export class CatalogManagementComponent {

  form: FormGroup

  @ViewChild(CatalogFormComponent)
  catalogForm?: CatalogFormComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({

    })
  }

}
