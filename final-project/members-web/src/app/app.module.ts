import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http'
import { ErrorInterceptor } from './utils/apis/error/error-interceptor';
import { AppErrorHandler } from './utils/apis/error/app-error-handler';
import { WidgetsModule } from './utils/widgets/widgets.module';

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
      useClass: ErrorInterceptor, multi: true },
    { provide: ErrorHandler,
      useClass: AppErrorHandler }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
