import { Component, inject } from '@angular/core';
import { QuickLink } from '../../components/quick-link/quick-link';
import { CartService } from '../../services/cart-service';

@Component({
  selector: 'app-cart-page',
  imports: [QuickLink],
  templateUrl: './cart-page.html',
  styleUrl: './cart-page.css',
})
export class CartPage {
  cartService = inject(CartService);
}
