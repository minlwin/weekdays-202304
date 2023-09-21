import { Injectable } from "@angular/core";

const APP_USER_KEY = 'com.jdc.members'

@Injectable({
  providedIn: 'root'
})
export class SecurityContextHolder {

  private _activeUser: any

  constructor() {
    let data = localStorage.getItem(APP_USER_KEY)

    if(data)
      this._activeUser = JSON.parse(data)
  }

  set activeUser(user: any) {
    if(user) {
      this._activeUser = user
      localStorage.setItem(APP_USER_KEY, JSON.stringify(user))
    } else {
      this.signOut()
    }
  }

  get activeUser() {
    return this._activeUser
  }

  signOut() {
    this._activeUser = undefined
    localStorage.clear()
  }

}
