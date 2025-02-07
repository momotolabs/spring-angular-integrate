import { Location } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fact-modal',
  standalone: true,
  imports: [],
  templateUrl: './fact-modal.component.html',
  styleUrls: ['./fact-modal.component.css']
})
export class FactModalComponent {
  constructor(
    public dialogRef: MatDialogRef<FactModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { fact: string }, private router: Router, private location: Location
  ) {}

  closeAndRefresh() {
    this.dialogRef.close();
    window.location.reload();
  }
}
