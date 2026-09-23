import { Component, inject, input, signal } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { CartService } from '../../services/cart-service';

@Component({
  selector: 'app-quick-link',
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './quick-link.html',
  styleUrl: './quick-link.css',
})
export class QuickLink {
  cartService = inject(CartService)

  path = input.required<string>()
  textLink = input.required<string>()
}
