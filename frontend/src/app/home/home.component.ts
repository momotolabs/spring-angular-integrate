import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../services/api.service';
import { MatDialog } from '@angular/material/dialog';
import { FactModalComponent } from './fact-modal/fact-modal.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  records: any[] = [];
  errorMessage: string = '';
  isLoading: boolean = true;

  private apiService = inject(ApiService);
  private dialog = inject(MatDialog);

  constructor() {
    this.fetchRecords();
  }

  fetchRecords(): void {
    this.apiService.getRecords().subscribe({
      next: (data) => {
        this.records = data;
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = err.message;
        this.isLoading = false;
      }
    });
  }

  openFactModal(): void {
    this.apiService.getFact().subscribe({
      next: (data) => {
        this.dialog.open(FactModalComponent, {
          data: { fact: data.fact }
        });
      },
      error: (err) => {
        this.errorMessage = err.message;
      }
    });
  }
}
