import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { QuickLink } from '../quick-link/quick-link';

@Component({
  selector: 'app-cart',
  imports: [RouterLink, QuickLink],
  templateUrl: './cart.html',
  styleUrl: './cart.css',
})
export class Cart {
}
