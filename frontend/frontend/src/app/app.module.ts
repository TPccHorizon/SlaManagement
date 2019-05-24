import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule,
  MatDatepickerModule, MatExpansionModule, MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule, MatMenuModule, MatNativeDateModule, MatProgressSpinnerModule, MatSelectModule,
  MatSidenavModule, MatSnackBar, MatSnackBarModule, MatStepperModule, MatTableModule,
  MatToolbarModule
} from "@angular/material";
import {AppRoutes} from "./app.routing";
import { NavigationComponent } from './core/navigation/navigation.component';
import { AuthenticationComponent } from './core/authentication/authentication.component';
import {ErrorInterceptor} from "./core/interceptors/error.interceptor";
import {Config} from "./config";
import {LoginComponent} from "./modules/authentication/login/login.component";
import {ReactiveFormsModule} from "@angular/forms";
import { RegisterComponent } from './modules/authentication/register/register.component';
import {JwtInterceptor} from "./core/interceptors/jwt.interceptor";
import {AuthGuard} from "./core/guards/auth.guard";
import {ResponseInterceptor} from "./core/interceptors/response.interceptor";
import { BaseLayoutComponent } from './shared/base-layout/base-layout.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import { SlaCreateComponent } from './modules/sla-creation/sla-create/sla-create.component';
import { SlaOverviewComponent } from './modules/sla-overview/sla-overview/sla-overview.component';
import { SlaItemComponent } from './modules/sla-overview/sla-item/sla-item.component';
import { SlaDetailsComponent } from './modules/sla-overview/sla-details/sla-details.component';
import { SlaStepperComponent } from './modules/sla-creation/sla-stepper/sla-stepper.component';
import { SloCreationComponent } from './modules/sla-creation/slo-creation/slo-creation.component';
import { UptimeFormComponent } from './modules/sla-creation/uptime-form/uptime-form.component';
import { ThroughputFormComponent } from './modules/sla-creation/throughput-form/throughput-form.component';
import { SloOverviewComponent } from './modules/sla-creation/slo-overview/slo-overview.component';
import { AverageResponseFormComponent } from './modules/sla-creation/average-response-form/average-response-form.component';
import { UptimeComponent } from './modules/sla-overview/slo-details/uptime/uptime.component';
import { ThroughputComponent } from './modules/sla-overview/slo-details/throughput/throughput.component';
import { AverageResponseTimeComponent } from './modules/sla-overview/slo-details/average-response-time/average-response-time.component';
import { HomeComponent } from './modules/home/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    AuthenticationComponent,
    LoginComponent,
    RegisterComponent,
    BaseLayoutComponent,
    SlaCreateComponent,
    SlaOverviewComponent,
    SlaItemComponent,
    SlaDetailsComponent,
    SlaStepperComponent,
    SloCreationComponent,
    UptimeFormComponent,
    ThroughputFormComponent,
    SloOverviewComponent,
    AverageResponseFormComponent,
    UptimeComponent,
    ThroughputComponent,
    AverageResponseTimeComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(AppRoutes),
    MatInputModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatListModule,
    MatMenuModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCardModule,
    MatExpansionModule,
    MatButtonModule,
    MatGridListModule,
    MatProgressSpinnerModule,
    MatTableModule,
    MatStepperModule,
    MatSelectModule,
    MatSnackBarModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ResponseInterceptor, multi: true},
    Config,
    AuthGuard
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
