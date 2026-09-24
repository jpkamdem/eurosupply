import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';

import { toSignal } from '@angular/core/rxjs-interop';
import type { Aliment, Materiel, Medic, Product } from '../types/Product';
import { CartService } from './cart-service';

@Injectable()
export class ProductService {
  #http = inject(HttpClient);
  #cartService = inject(CartService)

  #products = signal<Product[]>([]);

  #get<T extends Product>(url: string) {
    return toSignal(this.#http.get<T[]>(`http://127.0.0.1:3000${url}`), { initialValue: [] })
  }

  #patch<T extends Product>(url: string, body: Partial<Product>) {
    return toSignal(this.#http.patch<T>(`http://127.0.0.1:3000${url}`, body))
  }

  readonly products = this.#products.asReadonly();

  isProductAvailable(itemId: string, itemQty: number) {
    const itemsInCartCount = this.#cartService
      .cart()
      .filter((product) => product.id == itemId).length;
    return itemsInCartCount >= itemQty;
  }

  filterCart(id: string) {
    return this.#cartService.cart().filter((item) => item.id == id);
  }

  getAliments() {
    return this.#get<Aliment>('/api/foods/')
  }

  getMateriels() {
    return this.#get<Materiel>('/api/materials/')
  }

  getMedics() {
    return this.#get<Medic>('/api/medics/')
  }

  patchAliments(id: string, body: Partial<Product>) {
    return this.#patch<Aliment>(`/api/medics/${id}`, body);
  }

  patchMateriels(id: string, body: Partial<Product>) {
    return this.#patch<Materiel>(`/api/materials/${id}`, body);
  }

  patchMedics(id: string, body: Partial<Product>) {
    return this.#patch<Medic>(`/api/medics/${id}`, body);
  }
}
