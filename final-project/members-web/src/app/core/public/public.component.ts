import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityContextHolder } from 'src/app/utils/apis/security/security-context-holder';
import { SecurityService } from 'src/app/utils/apis/services/security.service';
import { ModalDialogComponent } from 'src/app/utils/widgets/dialog/modal-dialog/modal-dialog.component';

@Component({
  selector: 'app-public',
  templateUrl: './public.component.html'
})
export class PublicComponent implements OnInit {

  form: FormGroup
  activeUser: any

  @ViewChild(ModalDialogComponent)
  modalDialog?: ModalDialogComponent

  constructor(fb: FormBuilder,
    private securityService: SecurityService,
    private context: SecurityContextHolder,
    private router: Router) {
    this.form = fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(5)]] // Validators.pattern('[a-zA-Z0-9]{8,}')
    })
  }

  ngOnInit(): void {
    this.activeUser = this.context.activeUser
  }

  get email(): FormControl {
    return this.form.get('email') as FormControl
  }

  get password(): FormControl {
    return this.form.get('password') as FormControl
  }

  openForm() {
    this.modalDialog?.openDialog()
  }

  signIn() {
    this.securityService.singIn(this.form.value)
        .subscribe(resp => {
          if(resp) {
            this.context.activeUser = resp
            this.modalDialog?.hideDialog()
            this.router.navigate(['/', resp.role == 'Admin' ? 'manager' : resp.role.toLowerCase()])
          }
        })
  }

  logOut() {
    this.activeUser = undefined
    this.context.signOut()
  }

  navigateDashboard() {
    this.router.navigate(['/', this.activeUser.role.toLowerCase()])
  }

}
