import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  
  title = 'musselcracker-cma';

  constructor(private router: Router) {

  }

  public home(): void {
    this.router.navigate(['/home']);
  }

  public editor(): void {
    this.router.navigate(['/editor']);
  }

}
