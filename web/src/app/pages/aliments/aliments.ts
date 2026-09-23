import { Component, inject } from '@angular/core';
import { AlimentItem } from '../../components/aliment-item/aliment-item';
import { QuickLink } from '../../components/quick-link/quick-link';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-aliments',
  imports: [QuickLink, AlimentItem],
  providers: [ProductService],
  templateUrl: './aliments.html',
  styleUrl: './aliments.css',
})
export class Aliments {
  #productService = inject(ProductService);

  alimentsList = this.#productService.getAliments();
}
