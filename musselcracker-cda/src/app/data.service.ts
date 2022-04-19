import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Content } from './content';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private httpClient: HttpClient) {

  }

  public getAllcontent(): Observable<Content[]> {

    const url = environment.cmsapi + "/content";

    return this.httpClient.get<Content[]>(url).pipe();
  }

}
