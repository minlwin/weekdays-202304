import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SecurityContextHolder } from "./security-context-holder";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private context: SecurityContextHolder) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      let clone = req

      if(this.context.activeUser && this.context.activeUser.token) {
        clone = req.clone({headers : req.headers.append('Authorization', this.context.activeUser.token)})
      }

      return next.handle(clone)
  }

}
