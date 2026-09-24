import { Component, computed, inject } from '@angular/core';
import { QuickLink } from '../../components/quick-link/quick-link';
import { CartService } from '../../services/cart-service';
import { Product } from '../../types/Product';

@Component({
  selector: 'app-cart-page',
  imports: [QuickLink],
  templateUrl: './cart-page.html',
  styleUrl: './cart-page.css',
})
export class CartPage {
  cartService = inject(CartService);

  itemCount(newItem: Product) {
    return this.cartService.cart().filter((item) => item.id == newItem.id)
      .length;
  }

  uniqueProduct() {
    return this.cartService
      .cart()
      .filter(
        (product, index, products) =>
          products.findIndex((item) => item.id === product.id) === index,
      );
  }
}
