import { Component, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeCatalogService } from 'src/app/utils/apis/services/employee/employee-catalog.service';
import { EmployeeCategoryService } from 'src/app/utils/apis/services/employee/employee-category.service';
import { ModalDialogComponent } from 'src/app/utils/widgets/dialog/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-catalog-form',
  templateUrl: './employee-catalog-form.component.html'
})
export class EmployeeCatalogFormComponent implements OnInit {

  form: FormGroup
  categories: any[] = []

  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  constructor(private fb: FormBuilder,
    private empCategoryService: EmployeeCategoryService,
    private empCatalogService: EmployeeCatalogService,
    private route: ActivatedRoute,
    private router: Router) {
    this.form = fb.group({
      id: 0,
      categories: fb.array([]),
      name: ['', Validators.required],
      weight: [0, [Validators.required, Validators.min(1)]],
      purity: [0, [Validators.required, Validators.min(1)]],
      goldSmithFees: [0, [Validators.required, Validators.min(1)]],
      lostWeight: [0, [Validators.required, Validators.min(1)]],
      price: [0, [Validators.required, Validators.min(1)]],
      description: ['', Validators.required]
    })
  }

  ngOnInit(): void {
    this.empCategoryService.search().subscribe(resp => this.categories = resp)

    this.route.queryParamMap.subscribe(param => {
      if(param.get('id')) {
        this.empCatalogService.findById(+ (param.get('id') as string)).subscribe(resp => {
          if(resp) {
            this.form.patchValue(resp.info)
            let arr: string[] = resp.info.categories
            arr.map(name => this.categoriesControl.push(this.fb.control(name)))
          }
        })
      }
    })
  }

  get id() {
    return this.form.get('id') as FormControl
  }

  get categoriesControl() {
    return this.form.get('categories') as FormArray
  }

  get name() {
    return this.form.get('name') as FormControl
  }

  get weight() {
    return this.form.get('weight') as FormControl
  }

  get purity() {
    return this.form.get('purity') as FormControl
  }

  get goldSmithFees() {
    return this.form.get('goldSmithFees') as FormControl
  }

  get underCount() {
    return this.form.get('lostWeight') as FormControl
  }

  get price() {
    return this.form.get('price') as FormControl
  }

  get description() {
    return this.form.get('description') as FormControl
  }

  choose(value: any) {
    console.log(value)
  }

  selectCategory(name: any) {
    let isSame = this.categories.filter(cat => name == cat.name)
    let isExist = this.categoriesControl.controls.filter(ctrl => ctrl.value == name)
    if(name && isExist.length == 0 && isSame.length == 1)
      this.categoriesControl.push(this.fb.control(name))
  }

  removeSelected(index: number) {
    this.categoriesControl.removeAt(index)
  }

  openCatalogForm() {
    this.dialog?.openDialog()
  }

  saveCatalog() {

    let result: any[] = []

    for (let i = 0; i < this.categoriesControl.controls.length; i++) {
      let value = this.categoriesControl.controls[i].value

      for (let j = 0; j < this.categories.length; j++) {
        if(this.categories[j].name == value) {
          result.push(this.categories[j].id)
          break
        }
      }
    }

    this.form.patchValue({categories: result})

    this.empCatalogService.save(this.form.value).subscribe(resp => {
      if(resp) {
        this.router.navigate(['/employee', 'catalog', 'management'])
      }
    })
  }

}
