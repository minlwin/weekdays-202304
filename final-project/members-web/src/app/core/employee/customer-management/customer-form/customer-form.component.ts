import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeCustomerService } from 'src/app/utils/apis/services/employee/employee-customer.service';
import { PublicLocationService } from 'src/app/utils/apis/services/public/public-location.service';
import { ModalDialogComponent } from 'src/app/utils/widgets/dialog/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html'
})
export class CustomerFormComponent implements OnInit {

  form: FormGroup

  townships: any[] = []

  @ViewChild(ModalDialogComponent)
  dialog?: ModalDialogComponent

  constructor(fb: FormBuilder, private router: Router,
    private route: ActivatedRoute,
    private empCustomerService: EmployeeCustomerService,
    private pubLocationService: PublicLocationService) {
    this.form = fb.group({
      id: 0,
      name: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      nrcNumber: ['', Validators.required],
      gender: 'Male',
      dateOfBirth: '',
      address: ['', Validators.required],
      township: [0, Validators.required],
      remark: '',
      refererId: 0,
      deleted: false
    })
  }

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(param => {
      if(param.get('id')) {
        this.empCustomerService.findByIdForEdit(+(param.get('id') as string)).subscribe(resp => {
          if(resp) {
            console.log(resp)
            this.form.patchValue(resp)
          }
        })
      }
    })
    this.pubLocationService.getTownshipByDivision(0).subscribe(resp => this.townships = resp)
  }

  get id() {
    return this.form.get('id') as FormControl
  }

  get name() {
    return this.form.get('name') as FormControl
  }

  get phone() {
    return this.form.get('phone') as FormControl
  }

  get email() {
    return this.form.get('email') as FormControl
  }

  get nrcNumber() {
    return this.form.get('nrcNumber') as FormControl
  }

  get address() {
    return this.form.get('address') as FormControl
  }

  get township() {
    return this.form.get('township') as FormControl
  }

  openCustomerForm() {
    this.dialog?.openDialog()
  }

  saveCustomer() {
    this.empCustomerService.save(this.form.value).subscribe(resp => {
      if(resp) {
        this.router.navigate(['/employee', 'customer', 'management'])
      }
    })
  }

}
