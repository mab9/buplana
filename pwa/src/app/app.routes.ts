import {Routes} from '@angular/router';
import {LandingComponent} from "./components/landing/landing.component";


export const routes: Routes = [
  { path: '',              redirectTo: '/landing', pathMatch: 'full' },
  { path: 'landing',       component: LandingComponent },  // not logged in user
  { path: '**',            redirectTo: '/landing'}
];
