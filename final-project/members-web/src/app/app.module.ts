import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http'
import { AppErrorHandler } from './utils/apis/error/app-error-handler';
import { WidgetsModule } from './utils/widgets/widgets.module';
import { TokenInterceptor } from './utils/apis/security/token-interceptor';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    WidgetsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor, multi: true },
    { provide: ErrorHandler,
      useClass: AppErrorHandler }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
