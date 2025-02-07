import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { provideAnimations } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

import { HomeComponent } from './app/home/home.component';

bootstrapApplication(HomeComponent, {
  providers: [
    provideHttpClient(),
    provideAnimations(),
    MatDialogModule,
    MatButtonModule
  ]
}).catch(err => console.error(err));
