import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import type { Aliment } from '../types/Aliment';
import type { Materiel } from '../types/Materiel';
import type { Medic } from '../types/Medic';

type Product = Aliment | Medic | Materiel;

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  #http = inject(HttpClient);

  #products = signal<Product[]>([]);

  readonly products = this.#products.asReadonly();

  getProduct<T extends Product>(url: string) {
    return toSignal(
      this.#http.get<T[]>(url),
      { initialValue: [] }
    )
  }

  addProduct(product: Product) {
    this.#products.update((products) => [...products, product]);
  }
}
