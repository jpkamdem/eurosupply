import { Component, inject } from '@angular/core';
import { MedicItem } from '../../components/medic-item/medic-item';
import { QuickLink } from '../../components/quick-link/quick-link';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-medics',
  imports: [QuickLink, MedicItem],
  providers: [ProductService],
  templateUrl: './medics.html',
  styleUrl: './medics.css',
})
export class Medics {
  #productService = inject(ProductService);

  medicsList = this.#productService.getMedics();
}
