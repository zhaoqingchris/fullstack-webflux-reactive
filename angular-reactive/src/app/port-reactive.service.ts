import { Injectable } from '@angular/core';

import { Port } from './port';

import * as EventSource from 'eventsource';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class PortReactiveService {

  quotes: Port[] = [];
  url = 'http://localhost:8081/ports';

  getPortStream(): Observable<Array<Port>> {
    this.quotes = [];
    return Observable.create((observer) => {
      const eventSource = new EventSource(this.url);
      eventSource.onmessage = (event) => {
        console.debug('Received event: ', event);
        const json = JSON.parse(event.data);
        this.quotes.push(new Port(json['id'], json['name'], json['location']));
        observer.next(this.quotes);
      };
      eventSource.onerror = (error) => {
        // readyState === 0 (closed) means the remote source closed the connection,
        // so we can safely treat it as a normal situation. Another way of detecting the end of the stream
        // is to insert a special element in the stream of events, which the client can identify as the last one.
        if (eventSource.readyState === 0) {
          console.log('The stream has been closed by the server.');
          eventSource.close();
          observer.complete();
        } else {
          observer.error('EventSource error: ' + error);
        }
      }
    });
  }

}
