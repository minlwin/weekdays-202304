import { AfterViewInit, Component, ErrorHandler, Inject, ViewChild } from '@angular/core';
import { ErrorDialogComponent } from './utils/widgets/dialog/error-dialog/error-dialog.component';
import { AppErrorHandler } from './utils/apis/error/app-error-handler';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {

  @ViewChild(ErrorDialogComponent)
  errorDialog?: ErrorDialogComponent

  constructor(@Inject(ErrorHandler) private errorHandler: AppErrorHandler) {}

  ngAfterViewInit(): void {
      this.errorHandler.errorDialog = this.errorDialog
  }
}
