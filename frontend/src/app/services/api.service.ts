import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class ApiService {
  constructor(private http: HttpClient) {}

  // Método para obtener la lista de registros
  getRecords(): Observable<any[]> {
    return this.http.get<any[]>(environment.apiUrlService+'list').pipe(
      catchError(this.handleError)
    );
  }

  // Método para obtener el detalle del segundo servicio
  getFact(): Observable<any> {
    return this.http.get<any>(environment.apiUrlService+'save').pipe(
      catchError(this.handleError)
    );
  }

  // Manejo de errores
  private handleError(error: HttpErrorResponse) {
    console.error('An error occurred:', error);
    return throwError(() => new Error('API no disponible. Por favor, inténtalo más tarde.'));
  }
}
