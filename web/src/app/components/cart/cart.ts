import { Component, inject } from '@angular/core';
import { CartService } from '../../services/cart-service';

@Component({
  selector: 'app-cart',
  imports: [],
  templateUrl: './cart.html',
  styleUrl: './cart.css',
})
export class Cart {
  cartService = inject(CartService)
}
