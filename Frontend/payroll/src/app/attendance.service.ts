import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Attendance } from './attendance';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  

  private baseURL="http://localhost:8085/api/v3/attendances";

  constructor(private HttpClient:HttpClient) { }

  getAttendanceList():Observable<Attendance[]>{
    return this.HttpClient.get<Attendance[]>(`${this.baseURL}`);
  }

  createAttendance(employee:Attendance):Observable<object>{
    return this.HttpClient.post(`${this.baseURL}`,employee);
  }
  getAttendanceByEmpId(empId: number): Observable<Attendance>{
    return this.HttpClient.get<Attendance>(`http://localhost:8085/api/v3/${empId}`);
  }

  deleteAttendance(empId: number):Observable<object>{
    return this.HttpClient.delete(`${this.baseURL}/${empId}`);
  }
  }

