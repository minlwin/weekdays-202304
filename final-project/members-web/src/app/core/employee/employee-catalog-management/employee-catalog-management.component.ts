import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EmployeeCatalogFormComponent } from './employee-catalog-form/employee-catalog-form.component';

@Component({
  selector: 'app-catalog-management',
  templateUrl: './employee-catalog-management.component.html'
})
export class EmployeeCatalogManagementComponent {

  categories: any[] = []
  catalogs = []
  form: FormGroup

  @ViewChild(EmployeeCatalogFormComponent)
  catalogForm?: EmployeeCatalogFormComponent

  constructor(fb: FormBuilder) {
    this.form = fb.group({

    })
  }

}
