import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Employee } from "./employee";
import { environment } from "src/environments/environment";

@Injectable({providedIn: 'root'})
export class EmployeeService {
    private apiServerUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient) {}

    public getEmployees(): Observable<Employee[]> {
        const arr = this.http.get<Employee[]>(`${this.apiServerUrl}/v1/employees`);
        /*const arr: Employee[] = [
            {
            userId: 'anaand1234',
            firstName: 'Ana',
            lastName: 'Andersson',
            personalNumber: '900719-XXXX',
            email: 'ana@gmail.com',
            phoneNumber: '012345678',
            street: 'Anagatan 3',
            zip:'123-45',
            city: 'Göteborg',
            jobTitle: 'Developer',
            parentCompany: undefined,
            startDate: new Date(),
            endDate: undefined,
            //imageUrl: "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png",
        }]*/
        return arr;
    }

    public addEmployee(employee: Employee): Observable<Employee> {
       return this.http.post<Employee>(`${this.apiServerUrl}/v1/employees`, employee);
       /*public addEmployee(employee: Employee): Employee {
        const emp: Employee = {
            userId: 'anaand1234',
            firstName: 'Ana',
            lastName: 'Andersson',
            personalNumber: '900719-XXXX',
            email: 'ana@gmail.com',
            phoneNumber: '012345678',
            street: 'Anagatan 3',
            zip:'123-45',
            city: 'Göteborg',
            jobTitle: 'Developer',
            parentCompany: undefined,
            startDate: new Date(),
            endDate: undefined,
            //imageUrl: "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png",
        }
        return emp*/
    }

    /*public updateEmployee(employee: Employee): Observable<Employee> {
        return this.http.put<Employee>(`${this.apiServerUrl}/employees/${employee.userId}`, employee);
    }*/

    /*public deleteEmployee(userId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/employees/${userId}`);
    }*/
}