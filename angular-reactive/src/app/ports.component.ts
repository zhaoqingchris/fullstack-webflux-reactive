import {Component} from '@angular/core';

import {Port} from './port';
import {PortReactiveService} from './port-reactive.service';
import {PortBlockingService} from './port-blocking.service';

import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-component-quotes',
  providers: [PortReactiveService],
  templateUrl: './ports.component.html'
})
export class PortsComponent {
  ports: Observable<Port[]>;
  selectedPort: Port;
  mode: String;

  constructor(private portReactiveService: PortReactiveService, private portBlockingService: PortBlockingService) {
    this.mode = 'reactive';
  }

  requestPortStream(): void {
    this.ports = this.portReactiveService.getPortStream();
  }

  requestPortBlocking(): void {
    this.ports = this.portBlockingService.getPorts();
  }

  onSelect(port: Port): void {
    this.selectedPort = port;
  }
}
