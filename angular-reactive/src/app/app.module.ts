import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { PortReactiveService } from './port-reactive.service';
import { PortBlockingService } from './port-blocking.service';
import { AppComponent } from './app.component';
import { PortsComponent } from './ports.component';
import { PortDetailComponent } from './port-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    PortsComponent,
    PortDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    PortReactiveService,
    PortBlockingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
