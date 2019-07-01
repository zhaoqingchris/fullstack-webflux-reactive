import { Injectable } from '@angular/core';

import { Port } from './port';

import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class PortBlockingService {

  quotes: Port[] = [];
  url = 'http://localhost:8080/ports';

  constructor(private http: HttpClient) {}

  getPorts(): Observable<Array<Port>> {
    this.quotes = [];
    return this.http.get<Array<Port>>(this.url);
  }

}
