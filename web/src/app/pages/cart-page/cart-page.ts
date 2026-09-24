import { Component, computed, inject } from '@angular/core';
import { Router } from '@angular/router';
import { QuickLink } from '../../components/quick-link/quick-link';
import { CartService } from '../../services/cart-service';
import { ProductService } from '../../services/product-service';
import { Product } from '../../types/Product';

@Component({
  selector: 'app-cart-page',
  imports: [QuickLink],
  providers: [ProductService, Router],
  templateUrl: './cart-page.html',
  styleUrl: './cart-page.css',
})
export class CartPage {
  cartService = inject(CartService);
  productService = inject(ProductService);
  router = inject(Router)

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

  placeOrder() {
    // 
    this.cartService.reset();
    this.router.navigate(['/']);
  }
}
