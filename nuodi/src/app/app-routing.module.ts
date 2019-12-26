import {RouterModule,Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {WelcomeComponent} from './welcome/welcome.component';
import {SignupComponent} from './auth/signup/signup.component';
import {LoginComponent} from './auth/login/login.component';
import {NbConfigComponent} from './nbConfig/nbConfig.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
    {path: '', component: WelcomeComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'login', component: LoginComponent},
    {path: 'nbConfig', component: NbConfigComponent, canActivate: [AuthGuard]}
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [RouterModule],
    providers: [AuthGuard]
})
export class AppRoutingModule {}