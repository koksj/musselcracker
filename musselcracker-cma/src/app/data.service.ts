import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Content } from './content';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  constructor(private httpClient: HttpClient) {

   }

  public saveContent(content: Content): Observable<Content> {

    const url = environment.cmsapi + "/content";
    
    return this.httpClient.post<Content>(url,content,this.httpOptions).pipe();
  }

}
